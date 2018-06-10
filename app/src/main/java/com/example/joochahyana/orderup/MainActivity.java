package com.example.joochahyana.orderup;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;


public class MainActivity extends AppCompatActivity {

    /*
      if you want to reset db , just click resetDbbutton (it's invisible and nonclickable )

         to find the button

         start app with resetDbMode = true

         after reset db

         plz,plz set ResetDbMode false
     */
    private static final boolean ResetDbMode = true;// for reset Db by using app


    Button buttonCustomer, buttonStaff, buttonResetDb;
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
        buttonResetDb = (Button) findViewById(R.id.buttonResetDb);
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

        buttonResetDb.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                deleteAllDatainMySugarOrm();
            }

        });

        if (ResetDbMode){
            buttonResetDb.setClickable(true);
            buttonResetDb.setAlpha(1);

        }
        else{
            buttonResetDb.setClickable(false);
            buttonResetDb.setAlpha(0);

        }

        orderupdbInit();
    }

    private void launchActivityCustomer(){
        Intent intent = new Intent(this, TabbedActivityCustomer.class);
        startActivity(intent);
    }

    private void launchActivityStaff(){
        Intent intent = new Intent(this, TabbedActivityStaff.class);
        startActivity(intent);
    }

    private void deleteAllDatainMySugarOrm(){
        SugarContext.terminate();
        SchemaGenerator schemaGenerator = new SchemaGenerator(getApplicationContext());
        schemaGenerator.deleteTables(new SugarDb(getApplicationContext()).getDB());
        SugarContext.init(getApplicationContext());
        schemaGenerator.createDatabase(new SugarDb(getApplicationContext()).getDB());
        orderupdbInit();

    }

    private void orderupdbInit(){

        if (DatabaseItemType.find(DatabaseItemType.class, "name = ?","Appetizers").isEmpty()) {
            DatabaseItemType appetizers = new DatabaseItemType("Appetizers");
            appetizers.save();
        }
        if (DatabaseItemType.find(DatabaseItemType.class, "name = ?","Beverages").isEmpty()) {
            DatabaseItemType beverages = new DatabaseItemType("Beverages");
            beverages.save();
        }
        if (DatabaseItemType.find(DatabaseItemType.class, "name = ?","Dishes").isEmpty()) {
            DatabaseItemType dishes = new DatabaseItemType("Dishes");
            dishes.save();
        }
        if (DatabaseItemType.find(DatabaseItemType.class, "name = ?","Desserts").isEmpty()) {
            DatabaseItemType desserts = new DatabaseItemType("Desserts");
            desserts.save();
        }


        if (DatabaseOrderState.find(DatabaseOrderState.class, "name = ?","Before ordering").isEmpty()) {
            DatabaseOrderState Bf = new DatabaseOrderState("Before ordering");
            Bf.save();
        }
        if (DatabaseOrderState.find(DatabaseOrderState.class, "name = ?","Ordering").isEmpty()) {
            DatabaseOrderState Ordering = new DatabaseOrderState("Ordering");
            Ordering.save();
        }
        if (DatabaseOrderState.find(DatabaseOrderState.class, "name = ?","After ordering").isEmpty()) {
            DatabaseOrderState Ao = new DatabaseOrderState("After ordering");
            Ao.save();
        }
        if (DatabaseUserType.find(DatabaseUserType.class, "name = ?","Cook").isEmpty()) {
            DatabaseUserType cook = new DatabaseUserType("Cook");
            cook.save();
        }
        if (DatabaseUserType.find(DatabaseUserType.class, "name = ?","Waiter").isEmpty()) {
            DatabaseUserType waiter = new DatabaseUserType("Waiter");
            waiter.save();
        }
        if (DatabaseUserType.find(DatabaseUserType.class, "name = ?","Customer").isEmpty()) {
            DatabaseUserType customer = new DatabaseUserType("Customer");
            customer.save();
        }

    }


}
