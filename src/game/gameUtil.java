package game;

import players.Player;

public class gameUtil {

    //extra utilities class used to make Game class more clean
    //These methods are used in place of println and printf in game

    public static void printWelcome() {
        System.out.println("\nWelcome to Blackjack!");
    }

    public static void printDeal() {
        System.out.println("\nCards dealt:");
    }

    public static void printHit(Player p) {
        System.out.printf("\n%s hits.\n", p.getName());
    }

    public static void printStand(Player p) {
        System.out.printf("\n%s stands.\n", p.getName());
    }

    public static void printBust(Player p) {
        System.out.printf("\n%s busted!\n\n%s\n", p.getName(), p.toString());
    }

    public static void printUserOptions(Player p) {
        System.out.printf("\nYour hand is: %s\n", p.toString());
        System.out.println("\nWould you like to hit, stand or surrender?\n");
    }

    public static void printWin(Player p, Player d) {
        System.out.printf("\nYou win!\n%s\n\nDealers hand: %s\n", p.toString(), d.toString());
    }

    public static void printHand(Player p) {
        System.out.printf("\nYour current hand is: %s\n", p.toString());
    }

    public static void printPlayerBust(Player p, Player d) {
        System.out.printf("\nYour hand was: %d. You busted!\nThe dealers hand was: %d.\n", p.getValue(), d.getValue());
    }

    public static void printSurrender(Player p, Player d) {
        System.out.printf("\nYour hand was so bad you surrendered! Your hand: %d\nThe dealers hand was: %d\n", p.getValue(), d.getValue());
    }

    public static void printTie() {
        System.out.println("\nBoth hands were the same. Its a tie!\n");
    }

    public static void printLost(Player p, Player d) {
        System.out.printf("\nYou lost! Your hand was %s\nThe dealers hand was %s\n", p.toString(), d.toString());
    }

    public static void blackJackWin(Player p, Player d) {
        System.out.printf("\nBlackjack! You won by default.\nYour hand was: %s\nDealers hand was: %s", p.toString(), d.toString());
    }

    public static void dealerBlackJack() {
        System.out.println("\nDealer blackjack! You lost by default.\n");
    }

    public static void printDealerHand(Player d) {
        System.out.printf("\nThe dealers hand is: %s & hidden\n", d.getHand().get(0));
    }

    public static void printStartGame() {
        System.out.println("\nWould you like to play Blackjack? Enter 'play' or 'quit'\n");
    }

    public static void printWinLoss(int w, int l, int d) {
        System.out.printf("\nYour WLD ratio: %d-%d-%d\n", w, l, d);
    }

    public static void quitGameMessage() {
        System.out.println("\nThank you for playing!\n");
    }

    public static void dealerTurn() {
        System.out.println("\nDealers turn:");
    }
}
