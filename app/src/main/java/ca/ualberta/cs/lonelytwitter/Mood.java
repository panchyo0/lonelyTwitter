package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by qpang on 1/19/17.
 */

public abstract class Mood {
    public Date date;

    public Mood(Date date) {
        this.date = date;
    }

    public Mood(){       // default methed
        this.date=new Date();// if use Data date it will become a zan shi de bian liang. yong this.data hui zhuan dao public Date date bian cheng yong jiu
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String moodDependent();


}
