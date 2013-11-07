/*
 * Crystal McDonald
 * Talorie
 * 
 * Launch Page 2-3 second
 */

package com.cm.talorie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LaunchScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.launch);
			//set up thread to run at same time
		Thread timeSet = new Thread(){
			//method to run launch for 2 seconds, kill itself and launch new activity
			public void run(){
				try{
					sleep(2000);//2 seconds
					Intent mainIntent = new Intent("com.cm.talorie.MAINACTIVITY");
					startActivity(mainIntent);
				}
				catch (InterruptedException e){
					e.printStackTrace();
				}
				finally{
					finish();
				}
			}
			
		};
		
		timeSet.start();
	}
}//end
