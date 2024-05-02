package test;

import main.Leaderboard;
import main.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LeaderboardTest
{
    Leaderboard leaderboard = new Leaderboard();
    Player playerOne = new Player();
    Player playerTwo = new Player();
    ArrayList<Integer> scores = new ArrayList<>();

    public void setPlayerOne(Player playerOne)
    {
        this.playerOne.setScore(20);
        scores.add(20);
    }

    public void setPlayerTwo(Player playerTwo)
    {
        this.playerTwo.setScore(40);
        scores.add(40);
    }

    @Test
    @DisplayName("Get all leaderboard score values")
    void getAllScores()
    {
        assertEquals(scores, leaderboard.getAllScores(), "Leaderboard displays score");

    }

    @Test
    @DisplayName("Get top leaderboard score")
    void getMaxScore()
    {
        assertEquals(scores.indexOf(1), leaderboard.getMaxScore(), "Leaderboard displays top score");
    }

    @Test
    @DisplayName("Get lowest leaderboard score")
    void getMinScore()
    {
        assertEquals(scores.indexOf(0), leaderboard.getMinScore(), "Leaderboard displays lowest score");
    }

    @Test
    @DisplayName("Adds a new score to the leaderboard")
    void addScore()
    {
        playerOne.setScore(70);
        leaderboard.addScore(playerOne);
        assertEquals(70, leaderboard.getMaxScore(), "Add new score to leaderboard as top");
    }

    @Test
    @DisplayName("Removes a score from leaderboard")
    void removeScore()
    {
        playerOne.setScore(30);
        playerTwo.setScore(50);
        leaderboard.addScore(playerOne);
        leaderboard.addScore(playerTwo);
        leaderboard.removeScore();
        assertEquals(50, leaderboard.getMinScore(), "Remove lowest score from leaderboard");
    }
}