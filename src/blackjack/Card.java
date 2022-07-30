package blackjack;

public class Card {
    private int suit; //suit 0-> clubs / suit 1-> diamonds / suit 2-> hearts / suit 4-> spades
    private int rank; // 0-9 -> numbers 0-10  10-12 -> jack / queen / king
    private int value; // 1-10 value = number , in another way value 0-9 = rank +1  / 11-13 = 10, in another way 10-12 = 10

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public Card(Card c)
    {
        this.suit=c.suit;
        this.rank=c.rank;
        this.value=c.value;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
}
