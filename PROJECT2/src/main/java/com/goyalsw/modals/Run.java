package main.java.com.goyalsw.modals;

import main.java.com.goyalsw.modals.enums.RunType;

public class Run {
    int score;
    RunType runType;

    public Run(int score, RunType runType) {
        this.score = score;
        this.runType = runType;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public RunType getRunType() {
        return runType;
    }

    public void setRunType(RunType runType) {
        this.runType = runType;
    }

    public boolean isFour() {
        return this.runType.equals(RunType.FOUR);
    }

    public boolean isSix() {
        return this.runType.equals(RunType.SIX);
    }
}
