package com.geoke.error404;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Radio404Player extends Activity {
	
	// widget
    private View mStartButton;
	private View mStopButton;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // find view
        mStartButton = findViewById(R.id.start404);
        mStopButton = findViewById(R.id.stop404);
        
        // assign click listener
        mStartButton.setOnClickListener(startClickListener);
        mStopButton.setOnClickListener(stopClickListener);
    }
    
    private OnClickListener startClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {

		}
	};
	
	private OnClickListener stopClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
		}
	};
}