package com.cm.talorie;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class TallyCaloriesActivity extends Activity implements OnClickListener {
	EditText number;
	Button calorieInfo;
	Button browse;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tally);
	
	number = (EditText)findViewById(R.id.editText1);
	calorieInfo = (Button)findViewById(R.id.calorieBttn);
	//set onClick listener
	calorieInfo.setOnClickListener(this);

	browse = (Button) findViewById(R.id.browseBttn);
	        //IMPLICIT INTENT
	        browse.setOnClickListener(new OnClickListener() {

	         @Override
	     public void onClick(View interwebs) {
	         // Sends user to site to help them calculate their bmr
	        Uri uriUrl = Uri.parse("http://www.bmi-calculator.net/bmr-calculator/");

	        Intent browse_intent = new Intent(Intent.ACTION_VIEW, uriUrl);

	        startActivity(browse_intent);
	        
	    }
	});
}
	
	//TallyCaloriesActivity TAKES IN A NUMBER TO DISPLAY IT ON CalculatorActivity
	@Override
	public void onClick(View v) {
	// get info from edit text and send back
	String nums = number.getText().toString();
	//get info from intent that opens Tally class
	Intent i = getIntent ();
	//looking for i.putextras
	String msg = i.getStringExtra("numbers");
	
	//takes the results and closes the page and appends to CalculatorActivity in its button
	//BREAKFAST
	if(msg.contentEquals("breakfastTally")){
	i.putExtra("breakfastInfo", nums);
	setResult(RESULT_OK, i);
	finish();
	}
	//LUNCH
	if(msg.contentEquals("lunchTally")){
	i.putExtra("lunchInfo", nums);
	setResult(RESULT_OK, i);
	finish();
	}
	//DINNER
	if(msg.contentEquals("dinnerTally")){
		i.putExtra("dinnerInfo", nums);
		setResult(RESULT_OK, i);
		finish();
		}
	//SNACK1
	if(msg.contentEquals("snackTally1")){
		i.putExtra("snackInfo1", nums);
		setResult(RESULT_OK, i);
		finish();
		}
	//SNACK2
	if(msg.contentEquals("snackTally2")){
		i.putExtra("snackInfo2", nums);
		setResult(RESULT_OK, i);
		finish();
		}
	}//end OnClick
}//end