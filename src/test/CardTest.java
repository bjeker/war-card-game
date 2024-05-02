package test;

import main.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest
{
    Card card = new Card(20, "Jack");
    @Test
    @DisplayName("Get card value")
    void getValue()
    {
        assertEquals(20, card.getValue(), "Card value should be set");
    }

    @Test
    @DisplayName("Get card suit")
    void getSuit()
    {
        assertEquals("Jack", card.getSuit(), "Card suit should be set");
    }
}