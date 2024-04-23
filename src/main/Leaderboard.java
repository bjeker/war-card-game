package main;

import java.util.ArrayList;
import java.util.Collections;

public class Leaderboard
{
    private static Leaderboard self = new Leaderboard();

    private ArrayList<Integer> topScores = new ArrayList<>();

    public static Leaderboard get() {
        return self;
    }

    public ArrayList<Integer> getAllScores(){
        Collections.sort(topScores, Collections.reverseOrder());
        return topScores;
    }

    public int getMaxScore()
    {
        if (!topScores.isEmpty()) {
            return topScores.get(0);
        } else {
            return -1;
        }
    }

    public int getMinScore()
    {
        if (!topScores.isEmpty()) {
            return topScores.get(topScores.size() - 1);
        } else {
            return -1;
        }
    }

    public void addScore(Player player)
    {
        int newScore = player.getScore();
        if(topScores.isEmpty()){
            topScores.add(0, newScore);
        }else if(topScores.size() < 10){
            topScores.add(newScore);
            Collections.sort(topScores, Collections.reverseOrder());
        }else if(newScore <= getMinScore()){
            System.out.print("Score is not greater than the minimum score");
        }else{
            int index = Collections.binarySearch(topScores, newScore);
            if (index < 0) {
                index = -(index + 1);
            }
            topScores.add(index, newScore);
            removeScore();
        }

    }

    public void removeScore()
    {
        if (!topScores.isEmpty()) {
            topScores.remove(topScores.size() - 1);
        }
    }
}
