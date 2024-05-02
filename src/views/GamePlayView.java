package views;

import main.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Displays the gameplay along with buttons for actions
 */
public class GamePlayView {
    JFrame gameFrame = new JFrame("War: A Card Game");
    JFrame handFrame1 = new JFrame("Player 1 Hand");
    JFrame handFrame2 = new JFrame("Player 2 Hand");

    private String opponentType;
    private int roundLimit;
    private Deck initialDeck;
    private Leaderboard leaderboard = Leaderboard.get();
    private Player p1,p2;
    private HandView handView,handView2;
    private Card cardSelected;
    private int currentRound;
    private boolean war;
    private ArrayList<Card> p1Pile = new ArrayList<>();
    private ArrayList<Card> p2Pile = new ArrayList<>();

    /**
     * Displays the current game and features
     *
     * @param opponent the opponent to play against
     * @param rounds rounds to play to
     */
    public void display(String opponent, String rounds) {


        gameFrame.setSize(800,400);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel scoreP1 = new JLabel();
        JLabel scoreP2 = new JLabel();
        JPanel panel = new JPanel(new FlowLayout());
        JPanel scoreP1Panel = new JPanel(new FlowLayout());
        JPanel scoreP2Panel = new JPanel(new FlowLayout());
        JButton playButton = new JButton("Play Again");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when "Play Again" button is clicked
                gameFrame.dispose();
                handFrame1.dispose();
                handFrame2.dispose();
                GameSetupView gameSetupView = new GameSetupView();
                gameSetupView.display();
            }
        });
        JButton returnButton = new JButton("Return to Main Menu");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when "Return to Main Menu" button is clicked
                gameFrame.dispose();
                handFrame1.dispose();
                handFrame2.dispose();
                MainMenuView mainMenuView = new MainMenuView();
                mainMenuView.displayMainMenu();
            }
        });
        JButton exitButton = new JButton("Exit Game");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when "Exit Game" button is clicked
                System.exit(0);
            }
        });
        panel.add(playButton);
        panel.add(returnButton);
        panel.add(exitButton);
        scoreP1Panel.add(scoreP1);
        scoreP2Panel.add(scoreP2);
        panel.add(scoreP1Panel);
        panel.add(scoreP2Panel);
        gameFrame.add(panel);

        //center game frame above the hand
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int gf_x = (screenSize.width - gameFrame.getWidth()) / 2;
        int gf_y = 180;

        // Set the frame location
        gameFrame.setLocation(gf_x, gf_y);

        //below starts functionality for the game and hand
        initialDeck = new Deck();
        p1 = new Player();
        p2 = new Player();
        p1.setName("Player 1");
        p2.setName("Player 2");
        opponentType = opponent;
        if(rounds.equals("150")) {
            roundLimit = 150;
        }
        else if(rounds.equals("300")) {
            roundLimit = 300;
        }
        else {
            roundLimit = -1;
        }
        initialDeck.shuffle();
        initialDeck.deal(p1, p2);
        for(int i = 0; i < 5; i++) {
            p1.drawCard();
            p2.drawCard();
        }
        currentRound = 1;

        handView = new HandView(p1.getHand());
        handView2 = new HandView(p2.getHand());
        handView.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point pointClicked = e.getPoint();
                // Calculate the index of the clicked card based on the x-coordinate of the click
                int indexClicked = (int) (pointClicked.getX() / 40); // since card width is 40
                // Ensure the index is within the bounds of the hand
                if (indexClicked >= 0 && indexClicked < p1.getHand().size()) {
                    cardSelected = p1.getHand().get(indexClicked);
                }
                Card p1Card = cardSelected;
                Card p2Card = p2.getHand().get(0);
                for(Card card : p2.getHand()) {
                    if(card.getValue() > p2Card.getValue()) {
                        p2Card = card;
                    }
                }
                p1.playCard(cardSelected);
                p2.playCard(p2Card);
                playRound(p1Card, p2Card);
                handView.repaint();
                handView2.repaint();
                // Display the scores for each player
                scoreP1.setText(p1.getName() + " score: " + p1.getScore());
                scoreP2.setText(p2.getName() + " score: " + p2.getScore());
            }
        });

        //prevents the user from losing access to their hand
        handFrame1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        handFrame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        handFrame1.getContentPane().add(handView);
        handFrame2.getContentPane().add(handView2);

        handFrame1.pack();
        handFrame2.pack();

        int frameWidth = 260; // Set initial width
        int frameHeight = 120; // Set initial height
        handFrame1.setSize(frameWidth, frameHeight);
        handFrame2.setSize(frameWidth, frameHeight);

        int h_x = (screenSize.width - handFrame1.getWidth()) / 2; // Center horizontally
        int h_y = gameFrame.getHeight() + 20; // Position below the game JFrame
        handFrame1.setLocation(h_x, h_y+gf_y);
        handFrame2.setLocation(h_x, 10);

        handFrame1.setVisible(true);
        handFrame2.setVisible(true);
        //hand functionality finished

        //game over
        //need to add round limit to this condition
        //Calculate winner and display p1 or p2 winner with the score
        String message = "";
        if(p2.getDeck().isEmpty() || p1.getDeck().isEmpty()) {
            JOptionPane.showMessageDialog(null, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            gameFrame.dispose();
            MainMenuView mainMenuView = new MainMenuView();
            mainMenuView.displayMainMenu();
        }

        gameFrame.setVisible(true);
    }

    /**
     * <p>
     *     Play the round itself.
     * </p>
     * <p>
     * Cards are chosen and scores are updated.
     * Game ending logic is contained here.
     * </p>
     *
     * @param p1Card Card chosen by Player 1
     * @param p2Card Card chosen by Player 2
     */
    public void playRound(Card p1Card, Card p2Card) {
        p1Pile.add(p1Card);
        p2Pile.add(p2Card);
        int p1Value, p2Value, points = 0;
        String title = "Round " + currentRound;
        String cardsChosen = p1.getName() + " card: " + p1Card.display() + "\n"
                + p2.getName() + " card: " + p2Card.display();
        p1Value = p1Card.getValue();
        p2Value = p2Card.getValue();
        if (p1Value > p2Value) {
            war = false;
            points = p1Value - p2Value;
            String pointsWon = p1.getName() + " gets " + points + " points";
            String message = cardsChosen + "\n" + pointsWon;
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
            p1.setScore(points);
            p1.deck.addAll(p1Pile);
            p1Pile.clear();
            p1.deck.addAll(p2Pile);
            p2Pile.clear();
            Collections.shuffle(p1.deck);
        } else if (p2Value > p1Value) {
            war = false;
            points = p2Value - p1Value;
            String pointsWon = p2.getName() + " gets " + points + " points";
            String message = cardsChosen + "\n" + pointsWon;
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
            p2.setScore(points);
            p2.deck.addAll(p1Pile);
            p1Pile.clear();
            p2.deck.addAll(p2Pile);
            p2Pile.clear();
            Collections.shuffle(p2.deck);
        } else {
            war = true;
            String message = cardsChosen + "\n" + "It's war!" + "\nChoose another card to play";
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
            p1Pile.add(p1Card);
            p2Pile.add(p2Card);
            for (int i = 0; i < 3; i++) {
                if (!p1.deck.isEmpty()) {
                    p1Pile.add(p1.deck.remove(0));
                }
                if (!p2.deck.isEmpty()) {
                    p2Pile.add(p2.deck.remove(0));
                }
            }
        }
        if (!p1.deck.isEmpty()) {
            p1.drawCard();
        }
        if (!p2.deck.isEmpty()) {
            p2.drawCard();
        }
        if (!war) {
            currentRound += 1;
        }
        //game over
        //Calculate winner and display p1 or p2 winner with the score
        if((roundLimit != -1 && currentRound > roundLimit) || p2.getDeck().isEmpty() || p1.getDeck().isEmpty()) {
            int p1Score = p1.getScore();
            int p2Score = p2.getScore();
            String scores = p1.getName() + " has a score of " + p1Score + "\n" + p2.getName() + " has a score of " + p2Score;
            String winner = "";
            if(p1Score > p2Score){
                winner = p1.getName() + " is the winner!";
                leaderboard.addScore(p1);
            }
            else if(p2Score > p1Score) {
                winner = p2.getName() + " is the winner!";
                leaderboard.addScore(p2);
            }

            String message = scores + "\n" + winner;

            JOptionPane.showMessageDialog(null, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
            gameFrame.dispose();
            handFrame1.dispose();
            handFrame2.dispose();
            MainMenuView mainMenuView = new MainMenuView();
            mainMenuView.displayMainMenu();
        }
    }

}
