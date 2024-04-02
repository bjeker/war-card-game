package main;

import java.util.ArrayList;
import java.util.Vector;

public class Player
{
    private String name;
    private int score;
    //see card method in Deck class for reference
    private ArrayList<Integer> hand = new ArrayList<Integer>();

    //class references
    Hand currentHand;

    //set the initial deck
    public void setDeck(ArrayList<Integer> playerDeck)
    {
        hand = playerDeck;
    }

    public void drawCard()
    {
        //add card to the current hand
        currentHand.addCard(hand);
    }

    public void playCard()
    {
        //passing players current hand to update and display
        currentHand.display(hand);
        currentHand.removeCard(hand);
    }

    private void setScore(int roundScore)
    {
        //update score based on turn
        score = roundScore;
    }

    public int getScore()
    {
        //placeholder
        return score;
    }

    private void setName(String chosenName)
    {
        name = chosenName;
    }

    public String getName()
    {
        return name;
    }
}
