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

    public void display() {
        switch(value) {
            case 11:
                System.out.println("Jack of " + suit);
                break;
            case 12:
                System.out.println("Queen of " + suit);
                break;
            case 13:
                System.out.println("King of " + suit);
                break;
            case 14:
                System.out.println("Ace of " + suit);
                break;
            default:
                System.out.println(value + " of " + suit);
                break;
        }
    }

}
