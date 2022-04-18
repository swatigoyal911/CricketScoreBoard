package main.java.com.goyalsw.utility;

import main.java.com.goyalsw.modals.enums.WicketType;

public class WicketUtil {
    public WicketType getWicketTypeFromString(String str) {
        switch(str) {
            case "W":
                return WicketType.CAUGHT;
            default:
                return WicketType.NONE;
        }
    }
}
