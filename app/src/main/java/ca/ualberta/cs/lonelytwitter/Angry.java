package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by qpang on 1/19/17.
 */

public class Angry extends Mood {


    public Angry(Date date, Date date1) {
        super(date);
    }


    public Angry(){
        this.date=new Date();
    }


    public String moodDependent(){
        return  "- -!" ;
    }
}
