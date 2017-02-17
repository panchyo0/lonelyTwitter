package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by qpang on 2/16/17.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest(){
        super(LonelyTwitterActivity.class);

    }


    public void testAddTweet(){
        TweetList tweets=new TweetList();
        NormalTweet tweet=new NormalTweet("some tweet");
        tweets.add(tweet);
        //tweets.add(tweet);
        try {
            tweets.add(tweet);
            fail();//will return a fail message  if fail
        }catch (IllegalArgumentException e){
            Log.i("error","this tweet already exit in list");
        }

        //assertTrue(tweets.hasTweet(tweet));
        //fail();
    }

    public void testHasTweet(){
        TweetList tweets=new TweetList();
        NormalTweet tweet=new NormalTweet("some tweet");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testSetTweet(){
        TweetList tweets=new TweetList();
        NormalTweet tweet=new NormalTweet("some tweet");

        tweets.add(tweet);
        NormalTweet returnTweet=tweets.getTweet(0);
        assertEquals(returnTweet.getMessage(),tweet.getMessage());
        assertEquals(returnTweet.getDate(),tweet.getDate());
    }

    public void testDeleteTweet(){
        TweetList tweets=new TweetList();
        NormalTweet tweet=new NormalTweet("some tweet");

        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));

    }

    public void testGetCount(){
        TweetList tweets=new TweetList();
        NormalTweet tweet=new NormalTweet("some tweet");

        tweets.add(tweet);
        assertEquals(tweets.getCount(),1);
    }

    public void testgetTweet(){
        TweetList tweets=new TweetList();
        NormalTweet tweet=new NormalTweet("some tweet");

        tweets.add(tweet);
        assertTrue(tweets.getTweets());
    }


}
