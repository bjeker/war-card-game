package main;

import java.util.ArrayList;

/**
 * Player hand.
 */
public class Hand {

    private ArrayList<Card> cards;

    /**
     * Initialize the cards.
     *
     * @param initialCards initially dealt cards
     */
    public Hand(ArrayList<Card> initialCards) {
        this.cards = initialCards;
    }

    /**
     * Add a card to the hand.
     *
     * @param card current card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Remove a card from the hand.
     *
     * @param card current card
     */
    public void removeCard(Card card) {
        cards.remove(card);
    }

    /**
     * Clear cards from play
     */
    public void clear() {
        cards.clear();
    }

    /**
     * Get cards in play
     *
     * @return return the current cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }
    
}
