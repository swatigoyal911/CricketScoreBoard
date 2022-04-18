package main.java.com.goyalsw;

import main.java.com.goyalsw.modals.Ball;
import main.java.com.goyalsw.modals.Over;
import main.java.com.goyalsw.modals.Team;
import main.java.com.goyalsw.modals.enums.BallType;
import main.java.com.goyalsw.modals.user.Player;
import main.java.com.goyalsw.services.CricketScoreBoardManager;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        CricketScoreBoardManager manager = new CricketScoreBoardManager("1");

        Scanner scanner = new Scanner(System.in);
        System.out.println("No. of players for each team: ");
        int noOfPlayers = scanner.nextInt();
        System.out.println("No. of overs for each team: ");
        int noOfOvers = scanner.nextInt();

        Team team1 = new Team(Integer.toString(0));
        Team team2 = new Team(Integer.toString(1));
        manager.addTeam(Integer.toString(0), team1);
        manager.addTeam(Integer.toString(1), team2);

        for(int team=0; team<=1; team++) {
            manager.init();
            Team team1Object = manager.getTeamMap().get(Integer.toString(team)); //batter
            Team team2Object = manager.getTeamMap().get(Integer.toString(1-team)); //bowler
            manager.setTeamId1(Integer.toString(team));
            manager.setTeamId2(Integer.toString(1-team));

            Queue<Player> battingOrderOfPlayers = new LinkedList<>();
            System.out.println("Batting Order for team " + team + ":");
            for(int i=0; i<noOfPlayers; i++) {
                String name = scanner.next();
                String id = Integer.toString(team*2 + i+1);
                Player player = new Player(id,name);
                battingOrderOfPlayers.add(player);

                team1Object.addPlayer(player);
            }
            manager.setBattingOrderOfPlayers(battingOrderOfPlayers);

            for (int over = 1; over <= noOfOvers; over++) {
                Over overObject = new Over(Integer.toString(over));
                System.out.println("Over " + over + ":");

                int ball;
                for (ball = 1; ball <=6; ball++) {
                    String str = scanner.next();
                    Ball ballObj = manager.process(str, Integer.toString(ball));
                    overObject.addBall(ballObj);

                    if(ballObj.getBallType().equals(BallType.WIDE) || ballObj.getBallType().equals(BallType.NO_BALL)) {
                        ball --;
                    }

                    if(team2Object.getTotalWicketTaken() == noOfPlayers-1)
                        break;
                }

                manager.addOver(overObject);
                manager.swapStriker();

                System.out.println("Scorecard for team " + team + ":");
                manager.showScoreCard();
                System.out.println("Overs: " + (double)(over*6 -6 + ball)/6.0);

                if(team2Object.getTotalWicketTaken() == noOfPlayers-1)
                    break;
            }
        }

        manager.showResult();
    }
}
