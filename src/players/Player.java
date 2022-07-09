package players;

import deck.Card;

import java.util.ArrayList;

public class Player {
    //instance variables
    private String name;
    //array list used to hold cards in players hand
    private ArrayList<Card> hand = new ArrayList<>();
    //used to hold the total value of cards in the players hand
    private int value;

    //constructor for Player that requires a name when created
    public Player(String name) {
        this.name = name;
    }

    //resets the hand of the player when called
    public void resetHand() {
        hand.clear();
        this.value = 0;
    }

    //adds a card to the players hand when called
    public void addCard(Card c) {
        hand.add(c);
        //value is incremented with the value of the card added value
        this.value += c.getRankValue();
    }

    //used to get the value of a players hand
    public int getValue() {
        return value;
    }

    //used to get the name of the player
    public String getName() {
        return name;
    }

    //used to print the players hand
    public ArrayList<Card> getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "" + getHand() + " " + value;
    }
}
