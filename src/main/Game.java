package main;

public class Game {
    private int numPlayers;
    private int roundLimit;
    private Deck initialDeck;
    private Leaderboard lb;

    public Game() {
        numPlayers = 0;
        roundLimit = 0;
        initialDeck = new Deck();
        lb = new Leaderboard();
    }

    public void setNumPlayers(int players) {
        numPlayers = players;
    }

    public void setRoundLimit(int rounds) {
        roundLimit = rounds;
    }

    public void playGame() {
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setName("Player 1");
        player2.setName("Player 2");
        initialDeck.shuffle();
        initialDeck.deal(player1,player2);
        for(int i = 0; i < 5; i++) {
            player1.drawCard();
            player2.drawCard();
        }
        int currentRound = 1;
        while(currentRound <= roundLimit) {
            int p1Value,p2Value,points;
            Card p1Card = player1.playCard();
            Card p2Card = player2.playCard();
            p1Value = p1Card.getValue();
            p2Value = p2Card.getValue();
            if(p1Value > p2Value) {
                points = p1Value - p2Value;
                player1.setScore(points);
            }
            else if(p2Value > p1Value) {
                points = p2Value - p1Value;
                player2.setScore(points);
            }
            player1.drawCard();
            player2.drawCard();
            currentRound += 1;
        }
        int p1Score = player1.getScore();
        int p2Score = player2.getScore();
        System.out.println(player1.getName() + " has a score of " + p1Score);
        System.out.println(player2.getName() + " has a score of " + p2Score);
        if(p1Score > p2Score){
            System.out.println(player1.getName() + " is the winner!");
            if(p1Score > lb.getMinScore()) {
                lb.addScore(player1);
            }
        }
        else if(p2Score > p1Score) {
            System.out.println(player2.getName() + " is the winner!");
            if(p1Score > lb.getMinScore()) {
                lb.addScore(player2);
            }
        }
    }

    public void viewLeaderboard() {
        lb.display();
    }

    public static void main(String[] args) {
        Game game = new Game();
        boolean stopPlay = false;
        while (!stopPlay) {
            game.setNumPlayers(1);
            game.setRoundLimit(150);
            game.playGame();
            stopPlay = true;
        }
    }
}