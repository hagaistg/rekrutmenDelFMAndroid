package com.example.user.proyekkelompok;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Splashscreen extends AppCompatActivity {
    Animation frombottom;
    Animation fromtop;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        final ProgressBar simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);

        simpleProgressBar.setVisibility(View.VISIBLE);

        imageView =(ImageView) findViewById(R.id.imageView);

        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        fromtop = AnimationUtils.loadAnimation(this,R.anim.fromtop);
        imageView.setAnimation(fromtop);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(getApplicationContext(),LoginUser.class);
                startActivity(mainIntent);
                finish();
            }
        }, 3000);//delay 2 detik
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Proyek PAM");
        }
    }
}

