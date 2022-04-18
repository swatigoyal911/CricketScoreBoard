package main.java.com.goyalsw.utility;

import main.java.com.goyalsw.modals.Run;
import main.java.com.goyalsw.modals.enums.RunType;

import java.util.Objects;

public class RunUtil {
    public Run createRun(String str) {
        if(Objects.equals(str, "W") || Objects.equals(str, "Wd"))
            return new Run(0, this.getRunTypeFromString(str));
        int score = Integer.parseInt(str);
        RunType runType;
        if(score == 4)
            runType = RunType.FOUR;
        else if(score == 6)
            runType = RunType.SIX;
        else
            runType = RunType.NORMAL;
        return new Run(score, runType);
    }

    public RunType getRunTypeFromString(String str) {
        switch(str) {
            case "Wd":
                return RunType.WIDE;
            case "Nb":
                return RunType.NO_BALL;
            default:
                return RunType.NORMAL;
        }
    }
}
