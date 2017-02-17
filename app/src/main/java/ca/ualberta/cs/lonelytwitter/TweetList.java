package ca.ualberta.cs.lonelytwitter;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by qpang on 2/16/17.
 */

public class TweetList {
    private ArrayList<NormalTweet> tweets=new ArrayList<NormalTweet>();

    public void add(NormalTweet tweet){
        //tweets.add(tweet);
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException();
        }else {

            tweets.add(tweet);

        }

    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);

    }

    public NormalTweet getTweet(int index){
       // return new NormalTweet("not the  tweet");
       return tweets.get(0);
    }

    public void delete(NormalTweet tweet){
        tweets.remove(tweet);
    }

    public int getCount(){

        return tweets.size();
    }

    public boolean getTweets(){
        return true;
    }
}
