package views;

import main.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSetupView {
    private JFrame frame;
    private JComboBox<String> playerTypeComboBox;
    private JComboBox<String> roundLimitComboBox;
    public String opponentSelection;
    public String roundSelection;

    public void display()
    {
        frame = new JFrame("Game Setup");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        JPanel playerTypePanel = new JPanel(new FlowLayout());
        JLabel playerTypeLabel = new JLabel("Opponent Type: ");
        playerTypeComboBox = new JComboBox<>(new String[]{"Select one","Computer","Player"});
        playerTypePanel.add(playerTypeLabel);
        playerTypePanel.add(playerTypeComboBox);

        playerTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when opponent type selection is made
                opponentSelection = (String)playerTypeComboBox.getSelectedItem();
            }
        });

        JPanel roundLimitPanel = new JPanel(new FlowLayout());
        JLabel roundLimitLabel = new JLabel("Round Limit: ");
        roundLimitComboBox = new JComboBox<>(new String[]{"Select one","150","300","Unlimited"});

        roundLimitComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when round limit selection is made
                roundSelection = (String)roundLimitComboBox.getSelectedItem();
            }
        });

        roundLimitPanel.add(roundLimitLabel);
        roundLimitPanel.add(roundLimitComboBox);

        // Start Game Button
        JPanel startGamePanel = new JPanel(new FlowLayout());
        JButton startGameButton = new JButton("Start Game");

        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when "Start Game" button is clicked
                frame.dispose();
                Game newGame = new Game();
                newGame.setOpponentType(opponentSelection);
                newGame.setRoundLimit(roundSelection);
                GamePlayView gamePlayView = new GamePlayView();
                gamePlayView.display();
                newGame.playGame();
            }
        });

        startGamePanel.add(startGameButton);

        mainPanel.add(playerTypePanel);
        mainPanel.add(roundLimitPanel);
        mainPanel.add(startGamePanel);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}