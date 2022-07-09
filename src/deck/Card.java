package deck;

public class Card {
    //instance variable for card suits & rank
    private Suit suit;
    private Rank rank;

    //constructor for creating cards
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    //getters and setters used to get card information if need be
    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    //used to get the value of a card for calculating blackjack
    public int getRankValue() {
        return rank.getValue();
    }

    public String getRankName() {
        return rank.getName();
    }

    //toString used to print the whole deck if required
    @Override
    public String toString() {
        return rank.getName() + " of " + suit.getName();
    }
}
