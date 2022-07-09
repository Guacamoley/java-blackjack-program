package deck;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Deck {
    //creating an arraylist to hold all cards in the deck
    private ArrayList<Card> deck = new ArrayList<>();

    //loads the deck at the beginning of creation
    public Deck() {
        loadDeck();
    }

    //removes the first card in the deck for when cards get distributed
    public Card dealCard() {
        return deck.remove(0);
    }

    //method used to reset the deck after each game of blackjack is completed
    public void resetDeck() {
        //removes every card in the deck, and then loads the deck
        deck.removeAll(deck);
        loadDeck();
    }

    public void shuffleDeck() {
        //uses secure random for true shuffling
        SecureRandom rand = new SecureRandom();

        //temporary int and card variables used to hold information for swapping
        int randIndex;
        Card tempCard;

        //for loop that runs through the whole deck
        for (int i = 0; i < deck.size(); i++) {
            //for each iteration, a new random index is chosen
            randIndex = rand.nextInt(deck.size());
            //tempCard holds the value of the iteration
            tempCard = deck.get(i);
            //sets the current iteration index 'i' with the value of randIndex
            deck.set(i, deck.get(randIndex));
            //sets the random index with tempCard which is the value of index i
            deck.set(randIndex, tempCard);
        }
    }

    public void loadDeck() {
        //loads the deck using enhanced for loop for each suit and rank
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck.add(new Card(s, r));
            }
        }
    }

    //prints out the whole deck if called upon
    public void printDeck() {
        for (Card c : deck) {
            System.out.print("" + c + ", ");
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

}
