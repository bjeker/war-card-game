import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import main.Leaderboard;
import main.Player;

public class LeaderboardTest {

    private Leaderboard leaderboard;

    @Before
    public void setUp() {
        leaderboard = new Leaderboard();
    }

    @Test
    public void testAddScore() {
        Player player1 = new Player("Player1", 100);
        Player player2 = new Player("Player2", 50);
        Player player3 = new Player("Player3", 75);

        leaderboard.addScore(player1);
        leaderboard.addScore(player2);
        leaderboard.addScore(player3);

        assertEquals(100, leaderboard.getMaxScore());
        assertEquals(50, leaderboard.getMinScore());
    }

    @Test
    public void testRemoveScore() {
        Player player1 = new Player("Player1", 100);
        Player player2 = new Player("Player2", 50);

        leaderboard.addScore(player1);
        leaderboard.addScore(player2);

        assertEquals(100, leaderboard.getMaxScore());
        leaderboard.removeScore();
        assertEquals(50, leaderboard.getMaxScore());
        leaderboard.removeScore();
        assertEquals(-1, leaderboard.getMaxScore());
    }

    @Test
    public void testDisplay() {
        // Since the display() method is mainly for GUI, we can't directly test its output.
        // Instead, we can test if it runs without errors.
        try {
            leaderboard.display();
        } catch (Exception e) {
            fail("Exception thrown while displaying leaderboard.");
        }
    }

    @Test
    public void testAddScoreWithEmptyList() {
        Player player1 = new Player("Player1", 100);
        leaderboard.addScore(player1);

        assertEquals(100, leaderboard.getMaxScore());
        assertEquals(100, leaderboard.getMinScore());
    }

    @Test
    public void testAddScoreBeyondLimit() {
        Player player1 = new Player("Player1", 100);
        Player player2 = new Player("Player2", 90);
        Player player3 = new Player("Player3", 80);
        Player player4 = new Player("Player4", 70);
        Player player5 = new Player("Player5", 60);
        Player player6 = new Player("Player6", 50);
        Player player7 = new Player("Player7", 40);
        Player player8 = new Player("Player8", 30);
        Player player9 = new Player("Player9", 20);
        Player player10 = new Player("Player10", 10);
        Player player11 = new Player("Player11", 5);

        leaderboard.addScore(player1);
        leaderboard.addScore(player2);
        leaderboard.addScore(player3);
        leaderboard.addScore(player4);
        leaderboard.addScore(player5);
        leaderboard.addScore(player6);
        leaderboard.addScore(player7);
        leaderboard.addScore(player8);
        leaderboard.addScore(player9);
        leaderboard.addScore(player10);
        leaderboard.addScore(player11);  // Beyond limit

        assertEquals(100, leaderboard.getMaxScore());
        assertEquals(10, leaderboard.getMinScore());
    }

    @Test
    public void testAddScoreNotGreater() {
        Player player1 = new Player("Player1", 100);
        Player player2 = new Player("Player2", 90);

        leaderboard.addScore(player1);
        leaderboard.addScore(player2);

        // Adding a score that is not greater than the minimum
        Player player3 = new Player("Player3", 80);
        leaderboard.addScore(player3);

        // Scores should remain the same
        assertEquals(100, leaderboard.getMaxScore());
        assertEquals(90, leaderboard.getMinScore());
    }

    @Test
    public void testRemoveScoreWithEmptyList() {
        leaderboard.removeScore();  // Removing from empty list

        assertEquals(-1, leaderboard.getMaxScore());
        assertEquals(-1, leaderboard.getMinScore());
    }
}
