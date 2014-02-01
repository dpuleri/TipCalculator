package com.dpuleri.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	

	private double tipPercentage; // Tip amount
	private double subtotal; // Tip amount
	private double tipAmount; // final tip
	private double totalBill; //total bill
     
	EditText subtotalET; //text amounts
	EditText tipPercentageET;
	TextView tipAmountTXT;
	TextView totalBillTXT;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

					
		
		if(savedInstanceState == null){
			
			// Just started
			
			subtotal = 0.0;
			tipPercentage = 0.15; 
			tipAmount = 0.0; 
			
		} else {
			
			// App is being restored
			
			subtotal = 0.0;
			tipPercentage = 0.15; 
			tipAmount = 0.0; 
		}
					
		//Getting the values from the fields
		subtotalET = (EditText) findViewById(R.id.subtotal);
		tipPercentageET = (EditText) findViewById(R.id.tipPercentage);
		tipAmountTXT = (TextView) findViewById(R.id.tipAmount);
		totalBillTXT = (TextView) findViewById(R.id.totalBill);
				
		//Setting listeners for subtotal and tip percentage
		subtotalET.addTextChangedListener(subtotalChanged);
		tipPercentageET.addTextChangedListener(tipPercentageChanged);
		
	}
	
	
	private TextWatcher subtotalChanged = new TextWatcher() {

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub.
			try {
				subtotal = Double.parseDouble(s.toString());
			}
			catch (NumberFormatException e) {
				subtotal = 0.0;
			}
			
			updateTip();
			
		}
		
	};
	
	private TextWatcher tipPercentageChanged = new TextWatcher() {

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			try {
				tipPercentage = Double.parseDouble(s.toString()) / 100;
			}
			catch (NumberFormatException e) {
				tipPercentage = 0.15;
			}
			updateTip();
			
		}
		
	};


	
	public void updateTip() {		
		tipAmount = subtotal * tipPercentage;
		tipAmountTXT.setText(String.format("%.2f", tipAmount));
		
		totalBill = subtotal + tipAmount;
		totalBillTXT.setText(String.format("%.2f", totalBill));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}