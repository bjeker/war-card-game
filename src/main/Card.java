package main;

/**
 * Card used by players.
 * <p>
 *     Suit and value included.
 * </p>
 */
public class Card {
    private int value;
    private String suit;

    /**
     * Set value and suit of card.
     *
     * @param val value of the card
     * @param s suit of the card
     */
    public Card(int val, String s) {
        value = val;
        suit = s;
    }

    /**
     * Get value of the card.
     *
     * @return returns card value
     */
    public int getValue() {
        return value;
    }

    /**
     * Get suit of the card.
     *
     * @return returns card suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Display face cards according to their value.
     *
     * @return returns the face of the card
     */
    public String display() {
        switch(value) {
            case 11:
                return "Jack of " + suit;
            case 12:
                return "Queen of " + suit;
            case 13:
                return "King of " + suit;
            case 14:
                return "Ace of " + suit;
            default:
                return value + " of " + suit;
        }
    }

}
