package main;

import main.Leaderboard;
import main.Player;
import main.Deck;
import main.Card;
import main.Hand;

import java.util.Collections;

public class Game {
    private int numPlayers;
    private int roundLimit;
    private Deck initialDeck;
    private Leaderboard lb = new Leaderboard();

    public Game() {
        numPlayers = 0;
        roundLimit = 0;
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
        initialDeck = new Deck();
        initialDeck.shuffle();
        initialDeck.deal(player1,player2);
        for(int i = 0; i < 5; i++) {
            player1.drawCard();
            player2.drawCard();
        }
        int currentRound = 1;
        while(currentRound <= roundLimit && !player1.deck.isEmpty() && !player2.deck.isEmpty()) {
            int p1Value,p2Value,points;
            Card p1Card = player1.playCard();
            Card p2Card = player2.playCard();
            int cardsPlayed = 1;
            boolean winner = false;
            while(!winner) {
                System.out.println("Round " + currentRound);
                System.out.print(player1.getName() + " card: ");
                p1Card.display();
                System.out.print(player2.getName() + " card: ");
                p2Card.display();
                p1Value = p1Card.getValue();
                p2Value = p2Card.getValue();
                if(p1Value > p2Value) {
                    winner = true;
                    points = p1Value - p2Value;
                    System.out.println(player1.getName() + " gets " + points + " points");
                    player1.setScore(points);
                    player1.deck.add(p1Card);
                    player1.deck.add(p2Card);
                    Collections.shuffle(player1.deck);
                }
                else if(p2Value > p1Value) {
                    winner = true;
                    points = p2Value - p1Value;
                    System.out.println(player2.getName() + " gets " + points + " points");
                    player2.setScore(points);
                    player2.deck.add(p1Card);
                    player2.deck.add(p2Card);
                    Collections.shuffle(player2.deck);
                 }
                else {
                    p1Card = player1.playCard();
                    p2Card = player2.playCard();
                    cardsPlayed += 1;
                }
            }
            for(int i = 0; i < cardsPlayed; i++) {
                if (!player1.deck.isEmpty()) {
                    player1.drawCard();
                }
                if (!player2.deck.isEmpty()) {
                    player2.drawCard();
                }
            }
            currentRound += 1;
        }
        System.out.println("\nGame Over");
        if(currentRound > roundLimit) {
            System.out.println("Round limit has been reached");
        }
        else if(player1.deck.isEmpty()) {
            System.out.println(player1.getName() + " is out of cards");
        }
        else if(player2.deck.isEmpty()) {
            System.out.println(player2.getName() + " is out of cards");
        }
        int p1Score = player1.getScore();
        int p2Score = player2.getScore();
        System.out.println(player1.getName() + " has a score of " + p1Score);
        System.out.println(player2.getName() + " has a score of " + p2Score);
        if(p1Score > p2Score){
            System.out.println(player1.getName() + " is the winner!\n");
            lb.addScore(player1);
        }
        else if(p2Score > p1Score) {
            System.out.println(player2.getName() + " is the winner!\n");
            lb.addScore(player2);
        }
    }

    public void viewLeaderboard() {
        lb.getAllScores();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setRoundLimit(150);
        game.playGame();
        game.playGame();
        game.playGame();
        game.viewLeaderboard();
    }

}