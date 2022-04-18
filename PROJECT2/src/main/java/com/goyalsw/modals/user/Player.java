package main.java.com.goyalsw.modals.user;

import main.java.com.goyalsw.modals.Ball;
import main.java.com.goyalsw.modals.Over;
import main.java.com.goyalsw.modals.enums.BallType;
import main.java.com.goyalsw.modals.enums.RunType;
import main.java.com.goyalsw.modals.enums.WicketType;

public class Player extends User{
    //BATTER
    int score;
    int noOfFours;
    int noOfSixes;
    int noOfBallsFaced;
    //BOWLER
    int totalOversBowled;
    int totalRunConceded;
    int wicketsTaken;
    int maidenOvers;
    int dotBalls;
    int totalBalls;

    public Player(String id, String name) {
        super(id, name);
        score = 0;
        noOfFours = 0;
        noOfSixes = 0;
        noOfBallsFaced = 0;
        //BOWLER
        totalOversBowled = 0;
        totalRunConceded = 0;
        wicketsTaken = 0;
        maidenOvers = 0;
        dotBalls = 0;
        totalBalls = 0;
    }

    public int getScore() {
        return score;
    }

    public int getNoOfFours() {
        return noOfFours;
    }

    public int getNoOfSixes() {
        return noOfSixes;
    }

    public int getNoOfBallsFaced() {
        return noOfBallsFaced;
    }

    public int getTotalOversBowled() {
        return totalOversBowled;
    }

    public int getTotalRunConceded() {
        return totalRunConceded;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public int getMaidenOvers() {
        return maidenOvers;
    }

    public int getDotBalls() {
        return dotBalls;
    }

    public int getTotalBalls() {
        return totalBalls;
    }

    public double getEconomy() {
        return (double) this.totalRunConceded/this.totalBalls;
    }

    public double getBatsManStrikeRate() {
        return ((double) this.score/this.noOfBallsFaced)*100;
    }

    public void updateBatterInfo(Ball ball) {
        if(!ball.getBallType().equals(BallType.WIDE)) {
            this.noOfBallsFaced++;
            if(!ball.getRun().getRunType().equals(RunType.LEG_BYE) && !ball.getRun().getRunType().equals(RunType.BYE)) {
                System.out.println("IN UPDATE: " + ball.getRun().getScore());
                this.score += ball.getRun().getScore();
                if (ball.getRun().isFour())
                    this.noOfFours++;
                if (ball.getRun().isSix())
                    this.noOfSixes++;
            }
        }
    }

    public void updateBowlerInfo(Ball ball) {
        if(!ball.getBallType().equals(BallType.WIDE)) {
            this.totalBalls++;

            if(!ball.getRun().getRunType().equals(RunType.LEG_BYE) && !ball.getRun().getRunType().equals(RunType.BYE))
                this.totalRunConceded += ball.getRun().getScore();

            if (ball.isWicketBall())
                this.wicketsTaken++;
            if (ball.isDotBall())
                this.dotBalls++;
        }
    }

    public void updateBowlerInfo(Over over) {
        this.totalOversBowled++;
        int totalScore = 0;

        for(Ball ball : over.getBallList()) {
            totalScore += ball.getRun().getScore();
            this.updateBowlerInfo(ball);
        }

        if(totalScore == 0)
            maidenOvers++;
    }
}
