package main;

public class Card
{
    private int value;
    private String suit;

    public Card(int val, String s)
    {
        value = val;
        suit = s;
    }
    public int getValue()
    {
        return value;
    }

    public String getSuit()
    {
        return suit;
    }

}
