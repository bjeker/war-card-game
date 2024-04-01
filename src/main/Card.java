package main;

public class Card
{
    int value;
    String suit;

    Card(int val, String s)
    {
        value = val;
        suit = s;
    }
    int getValue()
    {
        return value;
    }

    String getSuit()
    {
        return suit;
    }

}
