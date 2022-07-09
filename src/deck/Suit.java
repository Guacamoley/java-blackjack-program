package deck;

//enum used to hold suit value constants
public enum Suit {
    HEART("hearts"), DIAMONDS("diamonds"), CLUB("club"), SPADES("spades");

    String name;

    Suit(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }
}
