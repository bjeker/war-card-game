package main;

import java.util.ArrayList;

public class Player {
    private String name;
    private int score;
    public ArrayList<Card> deck;
    private Hand currentHand;

    public Player() {
        name = null;
        score = 0;
        ArrayList<Card> hand = new ArrayList<>();
        currentHand = new Hand(hand);
    }

    //set the initial deck
    public void setDeck(ArrayList<Card> playerDeck) {
        deck = playerDeck;
    }

    public void drawCard() {
        //add card to the current hand
        Card newCard = deck.remove(0);
        currentHand.addCard(newCard);
    }

    public void playCard(Card chosenCard) {
        currentHand.removeCard(chosenCard);
    }

    public void setScore(int roundScore)
    {
        //update score based on turn
        score += roundScore;
    }

    public int getScore()
    {
        //placeholder
        return score;
    }

    public void setName(String chosenName)
    {
        name = chosenName;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Card> getDeck() {return deck; };

    public ArrayList<Card> getHand() {
        return currentHand.getCards();
    }

}

