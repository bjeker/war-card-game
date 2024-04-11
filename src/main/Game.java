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
        if(numRounds.equals("150")) {
            roundLimit = 150;
        }
        else if(numRounds.equals("300")) {
            roundLimit = 300;
        }
        currentRound = 1;

        /*
        while( (roundLimit == 0 || currentRound <= roundLimit)
                && !player1.deck.isEmpty() && !player2.deck.isEmpty() ) {
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
        */
    }

    public void endGame()
    {
        Player playerOne = new Player();
        Player playerTwo = new Player();

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