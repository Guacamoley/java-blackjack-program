package game;

import deck.Deck;
import players.Player;

import java.util.Scanner;

public class Game {
    //instance variables for class Game
    private Deck deck;
    private Player player, dealer;
    private int winCount, lossCount, drawCount;
    //boolean variables to help with game flow
    private boolean playerMoveDone, dealerMoveDone;
    private Scanner input = new Scanner(System.in);

    //constructor to run the game
    public Game(Deck deck, Player player, Player dealer) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
    }

    //this is the method that will run the game and is called on in main method
    public void runGame() {
        //boolean endGame is used to either keep the game going or to end it
        boolean endGame = false;
        String userInput;

        //while endGame is false, the game will keep on running
        while (!endGame) {
            gameUtil.printStartGame();
            userInput = input.next();

            //if user keeps on entering 'play' the game will keep running
            if (userInput.equalsIgnoreCase("play")) {
                this.createBlackJack();
            }
            //else the game ends and the program stops
            else if(userInput.equalsIgnoreCase("quit")){
                endGame = true;
                gameUtil.quitGameMessage();
            }
        }
    }

    //creates the blackjack game to be run later
    public void createBlackJack() {
        //boolean blackjack is used in case a natural hand is drawn
        boolean blackjack = false;

        //setting move done to false
        this.playerMoveDone = false;
        this.dealerMoveDone = false;

        //resetting hands for when a new round of blackjack has started
        player.resetHand();
        dealer.resetHand();

        //shuffling deck every time createBlackJack is looped
        deck.shuffleDeck();

        gameUtil.printWelcome();

        //handing cards out to both player and dealer
        distributeCards(player);
        distributeCards(dealer);

        //prints out the hand of both dealer and player
        gameUtil.printDeal();
        gameUtil.printHand(player);
        gameUtil.printDealerHand(dealer);

        //calls the method isBlackJack to check if theres a natural blackjack
        blackjack = this.isBlackJack();

        //if not a natural, players go through their turns
        doMoves();

        //each players hands are then compared to find the winner
        if (!blackjack) {
            compareHands(player, dealer);
        }
        //win loss counter is shown at the end
        gameUtil.printWinLoss(winCount, lossCount, drawCount);
        //resets the deck for the next game
        deck.resetDeck();
    }

    //method used to let players make their move. Player goes first and then the dealer
    public void doMoves() {
        while (!this.playerMoveDone || !this.dealerMoveDone) {
            if (!this.playerMoveDone) {
                playerTurn(this.player);
            }
            else {
                gameUtil.dealerTurn();
                dealerTurn(this.dealer);
            }
        }
    }

    //this method is used to let the player make their move
    public void playerTurn(Player p) {
        String userIn;
        gameUtil.printUserOptions(p);
        //user input dictates whether they would like to hit, stand or surrender
        userIn = input.next();

        //hit, stand, surrender methods are called accordingly
        if (userIn.equalsIgnoreCase("hit")) {
            hit(p);
        }
        else if (userIn.equalsIgnoreCase("stand")) {
            stand(p);
        }
        else if (userIn.equalsIgnoreCase("surrender")) {
            surrender(p);
        }
    }

    //when its the dealers turn, this will be called
    public void dealerTurn(Player d) {
        //while loop keeps running as long as their hand is below 17
        while (d.getValue() < 17) {
            gameUtil.printHit(d);
            d.addCard(deck.dealCard());
        }
        //after the while loop, this checks if its below 21, if it is, then dealer stands
        if (d.getValue() >= 17 && d.getValue() <= 21) {
            gameUtil.printStand(d);
            dealerMoveDone = true;
        }
        //if over 21, dealer is busted
        else if (d.getValue() > 21) {
             gameUtil.printBust(d);
            dealerMoveDone = true;
        }
    }

    //used to check a natural blackjack hand
    public boolean isBlackJack() {
        boolean blackjack = false;

        //if the players hand is 21, then moves are done
        if (player.getValue() == 21) {
            playerMoveDone = true;
            dealerMoveDone = true;

            //double checks both hands
            if (player.getValue() > dealer.getValue() || dealer.getValue() > 21) {
                //if the check is true, blackjack gets true, and the game ends
                gameUtil.blackJackWin(player, dealer);
                blackjack = true;
            }
        }
        //if dealers hand is 21, then you automatically lose
        else if (dealer.getValue() == 21) {
            gameUtil.dealerBlackJack();
            blackjack = true;
            dealerMoveDone = true;
            playerMoveDone = true;
        }
        return blackjack;
    }

    //used to compare the hands of player and dealer
    public void compareHands(Player p, Player d) {
        //if your hand is bigger than dealers and is less than 21, you win
        if (p.getValue() > d.getValue() && p.getValue() <= 21 || d.getValue() > 21) {
            gameUtil.printWin(p, d);
            winCount++;
        }
        //if both hands are equal, then its draw
        else if (p.getValue() == d.getValue()) {
            gameUtil.printTie();
            drawCount++;
        }
        //otherwise you lose
        else {
            gameUtil.printLost(p, d);
            lossCount++;
        }
    }

    public void distributeCards(Player p) {
        //while loop distributes cards to players with less than 2 in hand
        while (p.getHand().size() < 2) {
            p.addCard(deck.dealCard());
        }
    }

    //method used to hit when called on
    public void hit(Player p) {
        gameUtil.printHit(p);
        //adds a card
        player.addCard(deck.dealCard());
        gameUtil.printHand(p);

        //if player went over 21, they lose and round is over
        if (player.getValue() > 21) {
            playerMoveDone = true;
            dealerMoveDone = true;

        }
    }

    //stand method used to stand. Nothing happens except turn is over
    public void stand(Player p) {
        gameUtil.printStand(p);
        playerMoveDone = true;
    }

    //surrender method in case you wanted to surrender
    public void surrender(Player p) {
        gameUtil.printSurrender(p, dealer);
        playerMoveDone = true;
        dealerMoveDone = true;
        lossCount++;
    }
}
