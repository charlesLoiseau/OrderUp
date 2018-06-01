package com.example.joochahyana.orderup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        ImageView image = (ImageView) findViewById(R.id.imageView);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(image);
        Glide.with(this).load(R.raw.giphy123).into(gifImage);

        thread_sleep sleep = new thread_sleep(this);


        sleep.start();



    }
    class thread_sleep extends Thread {
        Activity thisAct;
        thread_sleep(Activity theAct){
            thisAct =theAct;
        }
        public void run(){
            try {
                sleep(1000);//8300
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent= new Intent(thisAct,MainActivity.class);
            startActivity(intent);
        }
    }

}
