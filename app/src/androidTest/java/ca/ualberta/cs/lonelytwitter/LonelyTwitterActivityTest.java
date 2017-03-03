package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void setUp() throws Exception{
        solo=new Solo(getInstrumentation(),getActivity());
    }
    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testTweet(){
        solo.assertCurrentActivity("Wrong Activity",LonelyTwitterActivity.class);

        solo.clickOnButton("Clear");
        solo.enterText((EditText) solo.getView(R.id.body),"test tweet!");

        solo.clickOnButton("Save");

        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue(solo.waitForText("test tweet!"));

        solo.clickOnButton("Clear");

        assertFalse(solo.searchText("test tweet!"));

    }

    public void testClickTweetList(){

        LonelyTwitterActivity activity=(LonelyTwitterActivity)solo.getCurrentActivity();

        solo.assertCurrentActivity("Wrong Activity",LonelyTwitterActivity.class);

        solo.clickOnButton("Clear");
        solo.enterText((EditText) solo.getView(R.id.body),"test tweet!");

        solo.clickOnButton("Save");
        solo.waitForText("test tweet!");



        final ListView oldTweetsList=activity.getOldTweetsList();
        Tweet tweet=(Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals("test tweet!",tweet.getMessage());

        solo.clickInList(0);

        solo.assertCurrentActivity("Wrong Activity",EditTweetActivity.class);
        assertTrue(solo.waitForText("test tweet!"));

        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity",LonelyTwitterActivity.class);

    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}