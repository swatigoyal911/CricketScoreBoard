package main.java.com.goyalsw.utility;

import main.java.com.goyalsw.modals.enums.BallType;

public class BallUtil {
    public BallType getBallTypeFromString(String str) {
        switch(str) {
            case "Wd":
                return BallType.WIDE;
            case "W":
                return BallType.WICKET;
            default:
                return BallType.NORMAL;
        }
    }
}
