package main;

import java.util.Collections;

public class Game {
    private String opponentType;
    private String numRounds;
    private Deck initialDeck;
    private Leaderboard leaderboard = Leaderboard.get();
    private int currentRound = 0;
    private int roundLimit = 0;

    public Game(){}

    public void setOpponentType(String opponent) {
        opponentType = opponent;
    }

    public void setRoundLimit(String rounds) {
        numRounds = rounds;
    }

    public void playGame() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        playerOne.setName("Player 1");
        playerTwo.setName("Player 2");
        initialDeck = new Deck();
        initialDeck.shuffle();
        initialDeck.deal(playerOne,playerTwo);
        for(int i = 0; i < 5; i++) {
            playerOne.drawCard();
            playerTwo.drawCard();
        }
        if(numRounds.equals("150")) {
            roundLimit = 150;
        }
        else if(numRounds.equals("300")) {
            roundLimit = 300;
        }
        currentRound = 1;

        /*
        while( (roundLimit == 0 || currentRound <= roundLimit)
                && !playerOne.deck.isEmpty() && !playerTwo.deck.isEmpty() ) {
            int p1Value,p2Value,points;
            Card p1Card = playerOne.playCard();
            Card p2Card = playerTwo.playCard();
            int cardsPlayed = 1;
            boolean winner = false;
            while(!winner) {
                System.out.println("Round " + currentRound);
                System.out.print(playerOne.getName() + " card: ");
                p1Card.display();
                System.out.print(playerTwo.getName() + " card: ");
                p2Card.display();
                p1Value = p1Card.getValue();
                p2Value = p2Card.getValue();
                if(p1Value > p2Value) {
                    winner = true;
                    points = p1Value - p2Value;
                    System.out.println(playerOne.getName() + " gets " + points + " points");
                    playerOne.setScore(points);
                    playerOne.deck.add(p1Card);
                    playerOne.deck.add(p2Card);
                    Collections.shuffle(playerOne.deck);
                }
                else if(p2Value > p1Value) {
                    winner = true;
                    points = p2Value - p1Value;
                    System.out.println(playerTwo.getName() + " gets " + points + " points");
                    playerTwo.setScore(points);
                    playerTwo.deck.add(p1Card);
                    playerTwo.deck.add(p2Card);
                    Collections.shuffle(playerTwo.deck);
                }
                else {
                    p1Card = playerOne.playCard();
                    p2Card = playerTwo.playCard();
                    cardsPlayed += 1;
                }
            }
            for(int i = 0; i < cardsPlayed; i++) {
                if (!playerOne.deck.isEmpty()) {
                    playerOne.drawCard();
                }
                if (!playerTwo.deck.isEmpty()) {
                    playerTwo.drawCard();
                }
            }
            currentRound += 1;
        }
        System.out.println("\nGame Over");
        */

        if( (roundLimit != 0) && (currentRound > roundLimit) ) {
            System.out.println("Round limit has been reached");
        }
        else if(playerOne.deck.isEmpty()) {
            System.out.println(playerOne.getName() + " is out of cards");
        }
        else if(playerTwo.deck.isEmpty()) {
            System.out.println(playerTwo.getName() + " is out of cards");
        }
        int p1Score = playerOne.getScore();
        int p2Score = playerTwo.getScore();
        System.out.println(playerOne.getName() + " has a score of " + p1Score);
        System.out.println(playerTwo.getName() + " has a score of " + p2Score);
        if(p1Score > p2Score){
            System.out.println(playerOne.getName() + " is the winner!\n");
            leaderboard.addScore(playerOne);
        }
        else if(p2Score > p1Score) {
            System.out.println(playerTwo.getName() + " is the winner!\n");
            leaderboard.addScore(playerTwo);
        }
    }

    //getters and setters for vars
    public int getCurrentRound()
    {
        return currentRound;
    }

    public void setCurrentRound()
    {
        currentRound += 1;
    }

    public int getRoundLimit()
    {
        return roundLimit;
    }
}