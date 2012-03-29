package com.ravuya.AnimatedLayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

public class AnimatedLayoutActivity extends Activity {
	private Button hiddenButton;
	private Animation fadeIn;
	private Animation fadeOut;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.hiddenButton = (Button)this.findViewById(R.id.shownButton);
        
        this.fadeIn = new AlphaAnimation(0.0f, 1.0f);
        this.fadeIn.setDuration(500);
        this.fadeOut = new AlphaAnimation(1.0f, 0.0f);
        this.fadeOut.setDuration(500);
    }
    
    public void startAnimation(View view) {
    	int newVisibility = hiddenButton.getVisibility() == View.GONE ? View.VISIBLE : View.GONE;
    	Animation toPlay = (newVisibility == View.VISIBLE) ? this.fadeIn : this.fadeOut;
    	hiddenButton.startAnimation(toPlay);
		hiddenButton.setVisibility(newVisibility);
    }
}