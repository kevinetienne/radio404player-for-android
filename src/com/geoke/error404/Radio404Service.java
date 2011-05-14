package com.geoke.error404;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class Radio404Service extends Service {
	
	// audio stream
	private final String f = "http://radio404.org:8000";
	// instance of the MediaPlayer
	MediaPlayer mp = new MediaPlayer();
	// indicator
	private Boolean isPlaying = false;
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		startPlayer();
		return START_NOT_STICKY;
	}
	
	private void startPlayer() {
	    try {
			mp.setDataSource(f);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			mp.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    mp.start();
		
	}
	
	private void stopPlayer() {
		mp.stop();
	}

	@Override
	public void onDestroy() {
		stopPlayer();
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
