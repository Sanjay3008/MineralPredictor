package com.example.servertst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends AppCompatActivity {

    Handler handler;
    ImageView imageView, i1, i2, i3, i4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();
        imageView = findViewById(R.id.mineral_logo);
        i1 = findViewById(R.id.chlorine);
        i2 = findViewById(R.id.zinc);
        i3 = findViewById(R.id.magnesium);
        i4 = findViewById(R.id.silicon);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 5500);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        imageView.startAnimation(animation);
        i1.startAnimation(animation);
        i2.startAnimation(animation);
        i3.startAnimation(animation);
        i4.startAnimation(animation);

    }
}
