package main.java.com.goyalsw.modals;

import java.util.ArrayList;
import java.util.List;

public class Over {
    String id;
    List<Ball> ballList;

    public Over(String id) {
        this.id = id;
        this.ballList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Ball> getBallList() {
        return ballList;
    }

    public void setBallList(List<Ball> ballList) {
        this.ballList = ballList;
    }

    public void addBall(Ball ball) {
        ballList.add(ball);
    }

    public int getTotalScore() {
        int totalScore = 0;

        for(Ball ball : ballList) {
            totalScore += ball.getRun().getScore();
        }

        return totalScore;
    }

    public int getTotalWicket() {
        int totalWicket = 0;

        for(Ball ball : ballList) {
            if(ball.isWicketBall())
                totalWicket ++;
        }

        return totalWicket;
    }

    public int getTotalFours() {
        int totalFours = 0;

        for(Ball ball : ballList) {
            if(ball.getRun().isFour())
                totalFours ++;
        }

        return totalFours;
    }

    public int getTotalSixes() {
        int totalSixes = 0;

        for(Ball ball : ballList) {
            if(ball.getRun().isSix())
                totalSixes ++;
        }

        return totalSixes;
    }
}
