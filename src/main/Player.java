package main;

import java.util.ArrayList;

public class Player
{
    private String name;
    private int score;
    private ArrayList<Card> deck;

    //class references
    private Hand currentHand;

    public Player()
    {
        name = null;
        score = 0;
        deck = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();
        currentHand = new Hand(hand);
    }

    //set the initial deck
    public void setDeck(ArrayList<Card> playerDeck)
    {
        deck = playerDeck;
    }

    public void drawCard()
    {
        //add card to the current hand
        currentHand.addCard(deck.removeFirst());
    }

    public Card playCard()
    {
        //passing players current hand to update and display
        currentHand.display();
        Card chosenCard = currentHand.getCards().getFirst(); //placeholder for UI selection
        currentHand.removeCard(chosenCard);
        return chosenCard;
    }

    private void setScore(int roundScore)
    {
        //update score based on turn
        score += roundScore;
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
