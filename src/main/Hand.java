package main;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    public Hand(ArrayList<Card> initialCards) {
        this.cards = initialCards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public void display() {
        System.out.println("Cards in Hand:");
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    public void clear() {
        cards.clear();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
    
}
