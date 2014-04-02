package com.one.fxwallet;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {
	private Button login;
	private EditText loginuser, loginpass;
	private TextView registerNow;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		registerNow = (TextView) findViewById(R.id.registerNow);
		loginuser = (EditText) findViewById(R.id.loginuser);
		loginpass = (EditText) findViewById(R.id.loginpass);
		login = (Button) findViewById(R.id.login);
			
		//To add underline to the given string variable
		String registernow="Register now to access the app";
		SpannableString register_now = new SpannableString(registernow);
		register_now.setSpan(new UnderlineSpan(), 0,
		register_now.length(), 0);
	    registerNow.setText(register_now);

	    login.setOnClickListener(this);
	    
	    loginNow();    
	    	    
	    registerLink();
	}
	
	private void loginNow(){
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				if(loginuser.getText().toString().equals("")){
					Toast.makeText(getBaseContext(), "Invalid username", Toast.LENGTH_LONG).show();
					
				}else if(loginpass.getText().toString().equals("")){
						Toast.makeText(getBaseContext(), "Invalid password", Toast.LENGTH_LONG).show();	
						
				}else if(loginuser.getText().toString().equals("admin") && loginpass.getText().toString().equals("admin")){
					
					Intent i = new Intent(MainActivity.this, MenuActivity.class);
					startActivity(i);
					
					Toast.makeText(getBaseContext(), "Login Success", Toast.LENGTH_LONG).show();

				}else{
					Toast.makeText(getBaseContext(), "Check Username Or Password", Toast.LENGTH_LONG).show();
				}	
			}	
			
		});
	}
	
	private void registerLink(){
		registerNow.setClickable(true);
	    registerNow.setMovementMethod(LinkMovementMethod.getInstance());
	    registerNow.setOnTouchListener(new View.OnTouchListener() {
	        public boolean onTouch(View v, MotionEvent event) {
	            // TODO Auto-generated method stub
	        	setContentView(R.layout.signup);
	            Toast.makeText(getBaseContext(), "Register here!", Toast.LENGTH_LONG).show();
	            return false;
	        }
	    });
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
