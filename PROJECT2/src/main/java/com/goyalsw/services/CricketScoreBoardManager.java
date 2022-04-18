package main.java.com.goyalsw.services;

import main.java.com.goyalsw.modals.Ball;
import main.java.com.goyalsw.modals.Over;
import main.java.com.goyalsw.modals.Run;
import main.java.com.goyalsw.modals.Team;
import main.java.com.goyalsw.modals.enums.BallType;
import main.java.com.goyalsw.modals.enums.WicketType;
import main.java.com.goyalsw.modals.user.Player;
import main.java.com.goyalsw.utility.BallUtil;
import main.java.com.goyalsw.utility.RunUtil;
import main.java.com.goyalsw.utility.WicketUtil;

import java.util.*;

public class CricketScoreBoardManager {
    static RunUtil runUtil;
    static BallUtil ballUtil;
    static WicketUtil wicketUtil;

    String id;
    String teamId1, teamId2;
    Map<String, Team> teamMap;
    Queue<Player> battingOrderOfPlayers;
    List<Over> overList;
    Player batterAtStrikerEnd;
    Player batterAtNonStrikerEnd;
    Player bowler;

    public CricketScoreBoardManager(String id) {
        runUtil = new RunUtil();
        ballUtil = new BallUtil();
        wicketUtil = new WicketUtil();

        this.id = id;
        this.teamMap = new HashMap<>();
        this.overList = new LinkedList<>();

        this.init();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamId1() {
        return teamId1;
    }

    public void setTeamId1(String teamId1) {
        this.teamId1 = teamId1;
    }

    public String getTeamId2() {
        return teamId2;
    }

    public void setTeamId2(String teamId2) {
        this.teamId2 = teamId2;
    }

    public void addTeam(String teamId, Team team) {
        this.teamMap.put(teamId, team);
    }

    public void addOver(Over over) {
        this.overList.add(over);
    }

    public Map<String, Team> getTeamMap() {
        return teamMap;
    }

    public void setBattingOrderOfPlayers(Queue<Player> battingOrderOfPlayers) {
        this.battingOrderOfPlayers = battingOrderOfPlayers;
    }

    public void swapStriker() {
        Player temp = this.batterAtStrikerEnd;
        this.batterAtStrikerEnd = this.batterAtNonStrikerEnd;
        this.batterAtNonStrikerEnd = temp;
    }

    public void init() {
        this.battingOrderOfPlayers = new LinkedList<>();
        this.batterAtStrikerEnd = null;
        this.batterAtNonStrikerEnd = null;
        this.bowler = null;
    }

    public Ball process(String str, String ballId) {
        Run run = runUtil.createRun(str);
        WicketType wicketType = wicketUtil.getWicketTypeFromString(str);

        if(this.batterAtStrikerEnd == null) {
            this.batterAtStrikerEnd = this.battingOrderOfPlayers.poll();
            this.batterAtNonStrikerEnd = this.battingOrderOfPlayers.poll();
        }

        System.out.println(run.getScore() + " " + run.getRunType() + " " + this.batterAtStrikerEnd.getName() + " " + this.batterAtNonStrikerEnd);
        Ball ball = new Ball(ballId, ballUtil.getBallTypeFromString(str), wicketType, run, batterAtStrikerEnd, batterAtNonStrikerEnd, bowler);
        this.batterAtStrikerEnd.updateBatterInfo(ball);

        Team team1 = teamMap.get(teamId1);
        team1.updateBatterInformation(ball);

        Team team2 = teamMap.get(teamId2);
        team2.updateBowlerInformation(ball);

        if(!wicketType.equals(WicketType.NONE)) {
            if(this.battingOrderOfPlayers.size() == 0)
                this.batterAtStrikerEnd = null;
            else
                this.batterAtStrikerEnd = this.battingOrderOfPlayers.poll();
        }
        else if(run.getScore()%2!=0)
        {
            this.swapStriker();
        }

        return ball;
    }

    public void showScoreCard() {
        Team team1 = teamMap.get(teamId1);
        Team team2 = teamMap.get(teamId2);

        System.out.println("PlayerName      Score       4s      6s       Balls");
        for(Player player : team1.getPlayerList()) {
            System.out.println(player.getName() + "              " + player.getScore() + "        " + player.getNoOfFours() + "        " +
                    player.getNoOfSixes() + "        " + player.getNoOfBallsFaced());
        }

        System.out.println("Total: " + team1.getTotalScore() + "/" + team2.getTotalWicketTaken());
    }

    public void showResult() {
        Team team1 = teamMap.get(teamId1);
        Team team2 = teamMap.get(teamId2);
        int score1 = team1.getTotalScore();
        int score2 = team2.getTotalScore();

        if(score1 > score2)
            System.out.println("Team " + team1.getId() + " won the match by " + (score1-score2) + " runs");
        else
            System.out.println("Team " + team2.getId() + " won the match by " + (score2-score1) + " runs");
    }
}
