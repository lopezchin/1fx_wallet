package com.one.fxwallet;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends MainActivity implements OnClickListener {
	
	private TextView signingIn;
	private Button signup;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		
		signingIn = (TextView) findViewById(R.id.signingIn);
		signup = (Button) findViewById(R.id.signup);
		
		String alreadyRegister="Already a member? Signin now";
		SpannableString already_register = new SpannableString(alreadyRegister);
		already_register.setSpan(new UnderlineSpan(), 0,
		already_register.length(), 0);
		signingIn.setText(already_register);

		signup.setOnClickListener(this);
		
		SignupBtn();
		
		AlreadyRegister();
	}
	
	private void AlreadyRegister(){
		signingIn.setClickable(true);
		signingIn.setMovementMethod(LinkMovementMethod.getInstance());
		signingIn.setOnTouchListener(new View.OnTouchListener() {
		        public boolean onTouch(View v, MotionEvent event) {
		            // TODO Auto-generated method stub
		        	Intent i = new Intent(SignupActivity.this, MainActivity.class);
					startActivity(i);
					
		            Toast.makeText(getBaseContext(), "Login here!", Toast.LENGTH_LONG).show();
		            return false;
		        }
		    });
	}
	
	private void SignupBtn(){
		signup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(SignupActivity.this, MainActivity.class);
				startActivity(i);

				Toast.makeText(getBaseContext(), "Registered!",Toast.LENGTH_SHORT).show();			
			}
		});
	}
}
