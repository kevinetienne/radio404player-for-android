package com.geoke.error404;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;

public class Radio404Player extends Activity {
	
	// widget
    private View mStartButton;
	private View mStopButton;
	protected Intent mIntent;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // change title bar
        View titleView = getWindow().findViewById(android.R.id.title);
        if (titleView != null) {
          ViewParent parent = titleView.getParent();
          if (parent != null && (parent instanceof View)) {
            View parentView = (View)parent;
            parentView.setBackgroundColor(Color.rgb(0x00, 0x00, 0x00));
          }
        }

        // find view
        mStartButton = findViewById(R.id.start404);
        mStopButton = findViewById(R.id.stop404);
        
        // assign click listener
        mStartButton.setOnClickListener(startClickListener);
        mStopButton.setOnClickListener(stopClickListener);
    }
    
    private OnClickListener startClickListener = new OnClickListener() {
		
		public void onClick(View v) {
			mIntent = new Intent(Radio404Player.this,Radio404Service.class);
			startService(mIntent);
		}
	};
	
	private OnClickListener stopClickListener = new OnClickListener() {
		
		public void onClick(View v) {
			mIntent = new Intent(Radio404Player.this,Radio404Service.class);
			stopService(mIntent);
		}
	};
}