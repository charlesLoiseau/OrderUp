package com.example.joochahyana.orderup;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button buttonCustomer, buttonStaff;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            ActivityCompat.finishAffinity(this);
            System.exit(0);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCustomer = (Button) findViewById(R.id.buttonLoginCustomer);
        buttonStaff = (Button) findViewById(R.id.buttonLoginStaff);

        buttonCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivityCustomer();
            }
        });

        buttonStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchActivityStaff();
            }
        });
    }

    private void launchActivityCustomer(){
        Intent intent = new Intent(this, TabbedActivityCustomer.class);
        startActivity(intent);
    }

    private void launchActivityStaff(){
        Intent intent = new Intent(this, TabbedActivityStaff.class);
        startActivity(intent);
    }
}
