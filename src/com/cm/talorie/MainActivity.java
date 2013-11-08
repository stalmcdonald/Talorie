/*
 * Author: Crystal McDonald
 * App: Talorie
 * Date: 11/2013
 * 
 * Home Screen (main)
 */
package com.cm.talorie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	//global variables
		String stopStart;
		MediaPlayer mediaPlay;
		Button SS;
		Context _context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
			//Water Bottle Button
			Button calorieCounter = (Button) findViewById(R.id.calcCalBttn);
			calorieCounter.setOnClickListener(new OnClickListener() {
			
				@Override
				public void onClick(View v) {
					// Goes to Calorie Calculator Page 
					Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
					startActivity(intent);
				}
			});
		
				//Camera Button
				Button picProgress = (Button) findViewById(R.id.picProgressBttn);
				picProgress.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// Goes to Picture Progress Page 
						Intent intent = new Intent(MainActivity.this, PicProgressActivity.class);
						startActivity(intent);
					}
				});
				
				//Weights Button
				Button totalBody = (Button) findViewById(R.id.excerciseBttn);
				totalBody.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// Goes to Total Body Fitness Trainer 
						Intent intent = new Intent(MainActivity.this, TotalBodyActivity.class);
						startActivity(intent);
					}
				});
				
				//Info Button
				Button info = (Button) findViewById(R.id.aboutBttn);
				info.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// Goes to Total Body Fitness Trainer 
						Intent intent = new Intent(MainActivity.this, AboutActivity.class);
						startActivity(intent);
					}
				});
				
				//set context
				_context = this;
				
				//add music/sound to media player
				mediaPlay = MediaPlayer.create(MainActivity.this, R.raw.talorieinfo);
				
				//Set button
				SS = (Button) findViewById(R.id.audioBttn);
				stopStart = "Play";
				
				//start button 1 listener
				SS.setOnClickListener(new OnClickListener(){
					@Override
					public void onClick(View v){
						//starting and stopping the audio
						if(stopStart.equals("Play")){
							mediaPlay.start();
							stopStart = "Pause";
							SS.setText(stopStart);
						}else {
							mediaPlay.pause();
							stopStart = "Play";//changes text back to play
							SS.setText(stopStart);					
						}
					}
					
				});
				
				
	}//end onCreate

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//Boolean to find action bar items
	//Switch case
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		super.onOptionsItemSelected(item);
		switch(item.getItemId()){
		//action bar button found by id
		//goes to about talorie page
		case R.id.abouttalorie:
			Intent aboutIntent = new Intent(this, TalorieInfo.class);
			aboutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(aboutIntent);
			break;

			//goes to Contact Information Page
		case R.id.contactus:
			Intent contactIntent = new Intent(this, ContactActivity.class);
			contactIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(contactIntent);
			break;
		}
		return true;
	}//end onOptionsItemSelected

	


}//end
