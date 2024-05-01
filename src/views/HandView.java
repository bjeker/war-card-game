package views;

import main.Card;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class HandView extends JPanel {
    private ArrayList<Card> cards;
    private HashMap<Card,Rectangle> cardPositions;

    public HandView(ArrayList<Card> cards) {
        this.cards = cards;
        setPreferredSize(new Dimension(200, 100)); // Set preferred size for the panel
        cardPositions = new HashMap<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cardWidth = 40; // Width of each card

        for (int i = 0; i < 5; i++) {
            if(cards.get(i) != null){
                Card card = cards.get(i);
                drawCard(g, 5 + i * cardWidth, 5, card);
            }

        }
    }

    private void drawCard(Graphics g, int x, int y, Card card) {
        g.setColor(Color.WHITE);
        g.fillRoundRect(x, y, 40, 60, 10, 10); // Draw rounded rectangle as card background

        // Draw card value at the top-left corner
        g.setColor(card.getSuit().equals("hearts") || card.getSuit().equals("diamonds") ? Color.RED : Color.BLACK);
        g.drawString(formatCardValue(card.getValue()), x + 5, y + 15);

        // Draw card suit below the value
        g.drawString(formatCardSuit(card.getSuit()), x + 5, y + 35);

        Rectangle bounds = new Rectangle(x, y, 40, 60);
        cardPositions.put(card, bounds);
    }

    private String formatCardValue(int value) {
        if (value >= 2 && value <= 10) {
            return String.valueOf(value);
        } else {
            return switch (value) {
                case 11 -> "J";
                case 12 -> "Q";
                case 13 -> "K";
                case 14 -> "A";
                default -> "";
            };
        }
    }

    private String formatCardSuit(String suit) {
        return switch (suit) {
            case "hearts" -> "♥";
            case "diamonds" -> "♦";
            case "clubs" -> "♣";
            case "spades" -> "♠";
            default -> "";
        };
    }

    public HashMap<Card, Rectangle> getCardPositions() {
        return cardPositions;
    }
}
