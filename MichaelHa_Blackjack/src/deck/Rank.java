package deck;

//enum used to hold constants for the card ranks and values
public enum Rank {
    ACE(11, "ace"), TWO(2, "two"), THREE(3, "three"), FOUR(4, "four"), FIVE(5, "five"), SIX(6, "six"), SEVEN(7, "seven"),
    EIGHT(8, "eight"), NINE(9, "nine"), TEN(10, "ten"), JACK(10, "jack"), QUEEN(10, "queen"), KING(10, "king");

    private int value;
    private String name;

    Rank(int rankVal, String rankName) {
        value = rankVal;
        name = rankName;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
