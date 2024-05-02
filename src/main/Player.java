package main;

import java.util.ArrayList;

/**
 * Player data.
 * <p>
 *     Includes information on the player.
 * </p>
 */
public class Player {
    private String name;
    private int score;
    public ArrayList<Card> deck;
    private Hand currentHand;

    /**
     * Player object initializer.
     */
    public Player() {
        name = null;
        score = 0;
        ArrayList<Card> hand = new ArrayList<>();
        currentHand = new Hand(hand);
    }

    /**
     * Set players deck to dealt deck.
     *
     * @param playerDeck deck for player to use
     */
    //set the initial deck
    public void setDeck(ArrayList<Card> playerDeck) {
        deck = playerDeck;
    }

    /**
     * Draw a new card to the hand from deck.
     */
    public void drawCard() {
        //add card to the current hand
        Card newCard = deck.remove(0);
        currentHand.addCard(newCard);
    }

    /**
     * Play card from the hand.
     *
     * @param chosenCard card to remove from hand
     */
    public void playCard(Card chosenCard) {
        currentHand.removeCard(chosenCard);
    }

    /**
     * Score keeper.
     *
     * @param roundScore score of current round
     */
    public void setScore(int roundScore)
    {
        //update score based on turn
        score += roundScore;
    }

    /**
     * Get the current score.
     *
     * @return returns the current score
     */
    public int getScore()
    {
        //placeholder
        return score;
    }

    /**
     * Set the name for the player
     *
     * @param chosenName name chosen for player
     */
    public void setName(String chosenName)
    {
        name = chosenName;
    }

    /**
     * Get name of player
     *
     * @return name of player
     */
    public String getName()
    {
        return name;
    }

    public ArrayList<Card> getDeck() {return deck; };

    /**
     * Get the current hand.
     *
     * @return return hand cards
     */
    public ArrayList<Card> getHand() {
        return currentHand.getCards();
    }

}

