package main.java.com.goyalsw.modals;

import main.java.com.goyalsw.modals.enums.BallType;
import main.java.com.goyalsw.modals.user.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    String id;
    List<Player> playerList;
    //Batter
    int totalScore;
    int totalExtras;
    //Bowler
    int totalWicketTaken;

    public Team(String id) {
        this.id = id;
        this.playerList = new ArrayList<>();
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getTotalExtras() {
        return totalExtras;
    }

    public int getTotalWicketTaken() {
        return totalWicketTaken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void addPlayer(Player player) {
        this.playerList.add(player);
    }

    public int getTotalPlayers() {
        return this.playerList.size();
    }

    public void updateBatterInformation(Ball ball) {
        if(ball.isExtras())
            this.totalExtras++;
        if(ball.getBallType().equals(BallType.WIDE))
            this.totalScore++;
        else
            this.totalScore += ball.getRun().getScore();
    }

    public void updateBowlerInformation(Ball ball) {
        if(ball.isWicketBall())
            this.totalWicketTaken++;
    }
}
