/*
 * Radio404Player
 * Version 1.0.1
 * https://github.com/ekevin/radio404player
 * Copyright (c) 2011 Kevin Etienne <etienne.kevin@gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.geoke.error404;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageButton;

public class Radio404Player extends Activity {
	
	// widget
    private ImageButton mStartButton;
	private ImageButton mStopButton;
	protected Intent mIntent;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);             
        setContentView(R.layout.main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.mytitle); 
        
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
        mStartButton = (ImageButton) findViewById(R.id.start404);
        mStopButton = (ImageButton) findViewById(R.id.stop404);
        
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