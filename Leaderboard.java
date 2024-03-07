import java.util.ArrayList;

public class Leaderboard
{
    ArrayList<Integer> topScores = new ArrayList<>();

    void display()
    {
    }

    int getMaxScore()
    {
        //placeholder
        return topScores.get(0);
    }

    int getMinScore()
    {
        return topScores.get(9);
    }

    void addScore()
    {
        //need access to the newScore to be added
        //Collections.binarySearch(topScores, newScore);
        int index = 0

        if (index < 0) {
            // Element not found, calculate the insertion point
            index = -(index + 1);
        }

        // Insert newElement at the calculated index
        // topScores.add(index, newScore);
    }

    void removeScore()
    {
        topScores.remove(9);
    }
}
