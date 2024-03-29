package main;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import java.awt.*;

public class Leaderboard
{
    ArrayList<Integer> topScores = new ArrayList<>();

    void display()
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

        for (Integer score : topScores) {
            listModel.addElement(String.valueOf(score));
        }

        frame.setVisible(true);
    }

    int getMaxScore()
    {
        if (!topScores.isEmpty()) {
            return topScores.get(0);
        } else {
            return -1;
        }
    }

    int getMinScore()
    {
        if (!topScores.isEmpty()) {
            return topScores.get(topScores.size() - 1);
        } else {
            return -1;
        }
    }

    void addScore(Player player)
    {
        int newScore = player.getScore();
        if(topScores.isEmpty()){
            topScores.add(0, newScore);
        }else if(newScore <= getMinScore() && topScores.size() < 10){
            topScores.add(newScore);
            Collections.sort(topScores, Collections.reverseOrder());
        }else if(newScore <= getMinScore()){
            System.out.print("Score is not greater than the minimun score");
            return;
        }else{
            int index = Collections.binarySearch(topScores, newScore);
            if (index < 0) {
                // Element not found, calculate the insertion point
                index = -(index + 1);
            }
            topScores.add(index, newScore);
        }

    }

    void removeScore()
    {
        if (!topScores.isEmpty()) {
            topScores.remove(topScores.size() - 1);
        }
    }
}
