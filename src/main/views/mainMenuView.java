package main.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenuView {

    private JFrame frame;
    private LeaderboardView leaderboardView;
    private PlayGameView playGameView;

    public void displayMainMenu() {
        frame = new JFrame("Main Menu");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton playButton = new JButton("Play Game");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action to perform when "Play Game" button is clicked
                if (playGameView == null) {
                    playGameView = new PlayGameView();
                }
                playGameView.display();
            }
        });

        JButton leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (leaderboardView == null) {
                    leaderboardView = new LeaderboardView();
                }
                leaderboardView.display();
            }
        });

        panel.add(playButton);
        panel.add(leaderboardButton);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

