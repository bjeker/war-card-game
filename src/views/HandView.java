package views;

import main.Card;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HandView extends JPanel {
    private ArrayList<Card> cards;

    public HandView(ArrayList<Card> cards) {
        this.cards = cards;
        setPreferredSize(new Dimension(200, 100)); // Set preferred size for the panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cardWidth = 40; // Width of each card
        int overlap = 10; // Amount of overlap between cards
        int startX = (getWidth() - cards.size() * (cardWidth - overlap)) / 2; // Starting x-coordinate for drawing cards

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            drawCard(g, startX + i * (cardWidth - overlap), getHeight() / 2, card);
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
}
