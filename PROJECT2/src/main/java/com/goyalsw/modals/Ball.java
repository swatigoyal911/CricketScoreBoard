package main.java.com.goyalsw.modals;

import main.java.com.goyalsw.modals.enums.BallType;
import main.java.com.goyalsw.modals.enums.WicketType;
import main.java.com.goyalsw.modals.user.Player;

public class Ball {
    String id;
    BallType ballType;
    WicketType wicketType;
    Run run;
    Player batterAtStrikerEnd;
    Player batterAtNonStrikerEnd;
    Player bowler;

    public Ball(String id, BallType ballType, WicketType wicketType, Run run, Player batterAtStrikerEnd, Player batterAtNonStrikerEnd, Player bowler) {
        this.id = id;
        this.ballType = ballType;
        this.wicketType = wicketType;
        this.run = run;
        this.batterAtStrikerEnd = batterAtStrikerEnd;
        this.batterAtNonStrikerEnd = batterAtNonStrikerEnd;
        this.bowler = bowler;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }

    public WicketType getWicketType() {
        return wicketType;
    }

    public void setWicketType(WicketType wicketType) {
        this.wicketType = wicketType;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }

    public Player getBatterAtStrikerEnd() {
        return batterAtStrikerEnd;
    }

    public void setBatterAtStrikerEnd(Player batterAtStrikerEnd) {
        this.batterAtStrikerEnd = batterAtStrikerEnd;
    }

    public Player getBatterAtNonStrikerEnd() {
        return batterAtNonStrikerEnd;
    }

    public void setBatterAtNonStrikerEnd(Player batterAtNonStrikerEnd) {
        this.batterAtNonStrikerEnd = batterAtNonStrikerEnd;
    }

    public Player getBowler() {
        return bowler;
    }

    public void setBowler(Player bowler) {
        this.bowler = bowler;
    }

    public boolean isDotBall() {
        return this.run.getScore()==0;
    }

    public boolean isWicketBall() {
        return this.ballType.equals(BallType.WICKET) && !this.getWicketType().equals(WicketType.RUN_OUT);
    }

    public boolean isExtras() {
        switch(this.run.getRunType()) {
            case BYE:
            case NO_BALL:
            case WIDE:
            case LEG_BYE:
                return true;
            default:
                return false;
        }
    }
}
