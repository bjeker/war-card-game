package main;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Leaderboard for top player scores.
 */
public class Leaderboard
{
    private static Leaderboard self = new Leaderboard();

    private ArrayList<Integer> topScores = new ArrayList<>();

    public static Leaderboard get() {
        return self;
    }

    /**
     * Get all leaderboard top scores.
     *
     * @return return the top scores
     */
    public ArrayList<Integer> getAllScores(){
        Collections.sort(topScores, Collections.reverseOrder());
        return topScores;
    }

    /**
     * Get the top score.
     *
     * @return return top score
     */
    public int getMaxScore()
    {
        if (!topScores.isEmpty()) {
            return topScores.get(0);
        } else {
            return -1;
        }
    }

    /**
     * Get the minimum score.
     *
     * @return return the min score
     */
    public int getMinScore()
    {
        if (!topScores.isEmpty()) {
            return topScores.get(topScores.size() - 1);
        } else {
            return -1;
        }
    }

    /**
     * Add a score to the leaderboard.
     *
     * @param player Current player with new high score
     */
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

    /**
     * Remove score from leaderboard.
     */
    public void removeScore()
    {
        if (!topScores.isEmpty()) {
            topScores.remove(topScores.size() - 1);
        }
    }
}
