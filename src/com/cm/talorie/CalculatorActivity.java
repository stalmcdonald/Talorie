/*
 * Crystal McDonald
 * Talorie
 * Calculating Calories and tracking Water Intake
 */

package com.cm.talorie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends Activity implements OnClickListener{

Button breakfastCal, lunchCal, calcCal, dinnerCal, snackCal1, snackCal2;
TextView calTotal;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.calculator);

breakfastCal = (Button) findViewById(R.id.breakfastbutton);
lunchCal = (Button) findViewById(R.id.lunchbutton);
dinnerCal = (Button) findViewById(R.id.dinnerbutton);
snackCal1 = (Button) findViewById(R.id.snackbutton1);
snackCal2 = (Button) findViewById(R.id.snackbutton2);
calcCal = (Button) findViewById(R.id.calcbutton);

calTotal = (TextView) findViewById(R.id.tallytv);

//setup onclick listener
breakfastCal.setOnClickListener(this);
lunchCal.setOnClickListener(this);
dinnerCal.setOnClickListener(this);
snackCal1.setOnClickListener(this);
snackCal2.setOnClickListener(this);
calcCal.setOnClickListener(this);

}

    //EXPLICIT INTENT
@Override
public void onClick(View v) {
// if meal buttons are pressed go to new activity
Intent i = new Intent(this, TallyCaloriesActivity.class);
switch (v.getId()){

//Calorie buttons
case R.id.breakfastbutton:
    //breakfast calories
i.putExtra("numbers", "breakfastTally");
startActivityForResult(i, 1);
break;

case R.id.lunchbutton:
    //lunch calories
i.putExtra("numbers", "lunchTally");
startActivityForResult(i, 1);
break;

case R.id.dinnerbutton:
    //dinner calories
i.putExtra("numbers", "dinnerTally");
startActivityForResult(i, 1);
break;

case R.id.snackbutton1:
    //first snack calories
i.putExtra("numbers", "snackTally1");
startActivityForResult(i, 1);
break;

case R.id.snackbutton2:
    //second snack calories
i.putExtra("numbers", "snackTally2");
startActivityForResult(i, 1);
break;


case R.id.calcbutton:
    //Add Calorie Sums
//converting integer to string
int a = Integer.valueOf(breakfastCal.getText().toString());
int b = Integer.valueOf(lunchCal.getText().toString());
int c = Integer.valueOf(dinnerCal.getText().toString());
int d = Integer.valueOf(snackCal1.getText().toString());
int e = Integer.valueOf(snackCal2.getText().toString());
// Object sum = Integer.valueOf(firstNum+secondNum.getText().toString());

//displays the total in a string replacing "Total"
calTotal.setText("Total: " + (a+b+c+d+e));
break;

default:
break;
}
}
    //RETRIEVES NUMBERS ENTERED FROM CALCULATIONS TO BE ADDED
//grab info being sent back
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data){
super.onActivityResult(requestCode, resultCode, data);

if(data.getExtras().containsKey("breakfastInfo")){
breakfastCal.setText(data.getStringExtra("breakfastInfo"));
}
if(data.getExtras().containsKey("lunchInfo")){
lunchCal.setText(data.getStringExtra("lunchInfo"));
}
if(data.getExtras().containsKey("dinnerInfo")){
dinnerCal.setText(data.getStringExtra("dinnerInfo"));
}
if(data.getExtras().containsKey("snackInfo1")){
snackCal1.setText(data.getStringExtra("snackInfo1"));
}
if(data.getExtras().containsKey("snackInfo2")){
snackCal2.setText(data.getStringExtra("snackInfo2"));
}
}


}//end
