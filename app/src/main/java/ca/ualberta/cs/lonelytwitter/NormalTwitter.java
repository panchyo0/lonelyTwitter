package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by qpang on 1/19/17.
 */

public class NormalTwitter extends Twitter {

    public NormalTwitter(String message) {
        super(message);
    }

    public NormalTwitter(Date date, String message) {
        super(date, message);
    }

    public  Boolean isImportant(){
        return  true;
    }
}
