package main;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Deck of cards used
 */
public class Deck {
    private ArrayList<Card> cards;

    /**
     * Add cards to the deck for each suit
     */
    public Deck() {
        cards = new ArrayList<>();
        for(int i = 2; i < 15; i++) {
            Card clubs = new Card(i,"clubs");
            cards.add(clubs);
            Card diamonds = new Card(i,"diamonds");
            cards.add(diamonds);
            Card hearts = new Card(i,"hearts");
            cards.add(hearts);
            Card spades = new Card(i,"spades");
            cards.add(spades);
        }
    }

    /**
     * Shuffle the deck of cards
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Deal the deck of cards to players
     *
     * @param p1 Player 1
     * @param p2 Player 2
     */
    public void deal(Player p1,Player p2) {
        ArrayList<Card> playerDeck1 = new ArrayList<>();
        ArrayList<Card> playerDeck2 = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            playerDeck1.add(cards.get(i));
        }
        for(int i = 26; i < 52; i++) {
            playerDeck2.add(cards.get(i));
        }
        p1.setDeck(playerDeck1);
        p2.setDeck(playerDeck2);
    }

}
