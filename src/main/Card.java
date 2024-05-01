package main;

public class Card {
    private int value;
    private String suit;

    public Card(int val, String s) {
        value = val;
        suit = s;
    }
    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

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
