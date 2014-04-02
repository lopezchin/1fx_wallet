package com.one.fxwallet;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Dashboard extends Fragment {
	
	public Dashboard() {
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
			View rootView = inflater.inflate(
					R.layout.dashboard, container, false);
	
			return rootView;
	}
}
