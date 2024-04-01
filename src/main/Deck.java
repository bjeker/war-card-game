package main;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    int size;
    ArrayList<Card> cards = new ArrayList<>();

    Deck()
    {
        size = 52;
        for(int i = 2; i < 15; i++)
        {
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
    void shuffle()
    {
        Collections.shuffle(cards);
    }

    void deal(Player p1,Player p2)
    {
        ArrayList<Card> playerDeck1 = new ArrayList<>();
        ArrayList<Card> playerDeck2 = new ArrayList<>();
        for(int i = 0; i < size/2; i++)
        {
            playerDeck1.add(cards.get(i));
        }
        for(int i = size/2; i < size; i++)
        {
            playerDeck2.add(cards.get(i));
        }
        p1.setDeck(playerDeck1);
        p2.setDeck(playerDeck2);
    }
}
