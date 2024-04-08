package main.views;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import main.Leaderboard;

public class LeaderboardView {
    Leaderboard leaderboard = new Leaderboard();

    public void display()
    {

        JFrame frame = new JFrame("Leaderboard");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> leaderboardList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(leaderboardList);
        scrollPane.setPreferredSize(new Dimension(250, 150));

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        ArrayList<Integer> topScores = leaderboard.getAllScores();
        for (Integer score : topScores) {
            listModel.addElement(String.valueOf(score));
        }

        frame.setVisible(true);
    }
}
