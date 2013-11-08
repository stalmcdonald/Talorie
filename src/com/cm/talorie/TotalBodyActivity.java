package com.cm.talorie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TotalBodyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.target_body);
		
		//Leg Button
		Button legExercise = (Button) findViewById(R.id.legsBttn);
		legExercise.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View v) {
				// Goes to Leg Activity
				Intent intent = new Intent(TotalBodyActivity.this, LegActivity.class);
				startActivity(intent);
			}
		});
	}
}
