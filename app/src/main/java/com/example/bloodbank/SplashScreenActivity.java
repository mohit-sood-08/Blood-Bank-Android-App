package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SplashScreenActivity extends AppCompatActivity {
    ScaleAnimation scaleAnimation;
    TextView appname , credits;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        appname = (TextView) findViewById(R.id.textView);
        credits = (TextView) findViewById(R.id.textView10);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //  Animations
        defineAnimations();

        // Apply Animations
        logo = (ImageView) findViewById(R.id.imageView3);
        logo.startAnimation(scaleAnimation);

        int delayedSeconds = 5;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, RegisterationActivity.class);
                startActivity(i);
            }
        },delayedSeconds*1000);
    }

    void defineAnimations(){
        scaleAnimation = new ScaleAnimation(0f,1f,0f,1f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(3000);

        appname.animate().translationX(250);
        credits.animate().translationX(250);
        appname.animate().setDuration(3000);
        credits.animate().setDuration(3000);

    }

}

