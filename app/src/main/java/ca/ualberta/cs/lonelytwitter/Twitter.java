package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by qpang on 1/19/17.
 */
// abstract class cant have that instance of their object like twitter  in the same package will zi dong lian jie

public abstract class Twitter implements  TwitterAble {

    private Date date;
    private String message;
    private ArrayList<Mood>moodArrayList;


    public ArrayList<Mood> getMoodArrayList() {
        return moodArrayList;
    }



    //protected String a;//just access from itself and it child class
    public Twitter(String message){
        this.message=message;
        this.date=new Date();
        moodArrayList=new ArrayList<Mood>();

    }

    public Twitter(Date date, String message){
        this.message=message;
        this.date=date;
        moodArrayList=new ArrayList<Mood>();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) throws Exception {
        if (message.length()>140){
            throw new Exception(); // mean someting bad happend need throws
        }
        this.message = message;
    }
    //every class is a childclass of object
    //you jian dian ji zi dong chuang jiang get he set fang fa

    public  abstract  Boolean isImportant();
    // abstract fang fa yi ding cun zai yu abstract class zhong

    public void addMood(Mood mood){
        moodArrayList.add(mood);
    }

}
