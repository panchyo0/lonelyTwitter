package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by qpang on 1/19/17.
 */

public class Happy extends  Mood{



    public Happy(Date date) {
        super(date);

    }

    public  Happy(){
        this.date=new Date();
    }


    public String moodDependent(){
       return  "-,-" ;
    }
}
