/**
 * Provides the classes necessary to create an applet and the classes an applet uses
 * to communicate with its applet context.
 * someting here
 * The applet framework involves two entities:
 * the applet and the applet context. An applet is an embeddable window (see the
 * {@link java.awt.Panel} class) with a few extra methods that the applet context
 * can use to initialize, start, and stop the applet.
 *
 * @since 1.0
 * @see java.awt
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.renderscript.Type;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The type Lonely twitter activity.uses interaction and file mainpulation is performed
 * all files are in the from json file and stored inemulator's accessible from androuid;
 * <pre>
 *     pre.formatted test:<br>
 *         file explorer->data->data->ca.ualberta.cs.lonelytwitter-.file
 * </pre>
 * <code>begin<br>
 *     some ppseduo code here<br>
 * end.</code>
 * this file is identif in &nbsp
 * <ul>
 *     <li>item1</li>
 *     <li>item 2</li>
 * </ul>
 * <ol>
 *     <li>item1</li>
 *     <li>item 2</li>
 * </ol>
 *
 * </code>
 *
 * @author pang
 * @version 1.4
 * @since 1.0
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * thus file that all the tweet are save there
	 * @see #loadFromFile
	 * @see #saveInFile
	 */
    private enum TweetListOrdering{DATA_ASC,DATA_DESC,TEXT_ASC,TEXT_DESC};
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	/**
	 * this fun for stsrt
	 * oncreat
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text);
				text=trimExtraSpaces(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});
		//clear button

		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				//String text = bodyText.getText().toString();
				tweetList.clear();

				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});

	}
	/**
	 * this is for start
	 * start
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * this fun is for load file
	 * loadfile
	 * @return
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();
			// Taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			// 2017-01-26 17:53:59
			tweetList = gson.fromJson(in, new TypeToken<ArrayList<NormalTweet>>(){}.getType());
			tweetList.size();
			TypeToken<String> string=new TypeToken<String>(){};


			fis.close();
		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	/**
	 * this function is for sort
	 * @param ordering
	 */
	private void sortTweetListItem(TweetListOrdering ordering ){

	}
	/**
	 * this fun for save
	 * save twtter in file this is what we write can see by javadoc
	 * @param text
	 * @param date
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();

			gson.toJson(tweetList, out);

			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	/**
	 * remove alll speace in the given string
	 * @param inputString input string
	 * @return string without sapece
	 */
	private String trimExtraSpaces(String inputString){
		inputString=inputString.replaceAll("\\s+"," ");
		return inputString;
	}
}