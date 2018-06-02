package com.example.joochahyana.orderup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class foodstaffActivity extends AppCompatActivity {



    Button enrollButton;
    String foodName;
    String foodDescrption;
    String foodPrice;
    int foodTypeName;

    EditText editTextFoodName;
    EditText editTextFoodDes;
    EditText editTextPrice;
    RadioGroup foodType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodstaff);

        enrollButton = (Button)findViewById(R.id.buttonEnroll);

        enrollButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public  void onClick(View view){
                editTextFoodName = (EditText)findViewById(R.id.editTextFoodName);
                editTextFoodDes = (EditText)findViewById(R.id.editTextFoodDes);
                editTextPrice = (EditText)findViewById(R.id.editTextFoodPrice);

              foodName = editTextFoodName.getText().toString();
              foodDescrption = editTextFoodDes.getText().toString();
              foodPrice = editTextPrice.getText().toString();
              foodType = (RadioGroup)findViewById(R.id.radioGroup);
              foodTypeName = foodType.getCheckedRadioButtonId();




                if(foodName.length() != 0 && foodDescrption.length() != 0 && foodPrice.length() != 0 && foodTypeName != -1){

                    RadioButton radioButton = (RadioButton)findViewById(foodTypeName);
                    Toast.makeText(getApplicationContext(), radioButton.getText(), Toast.LENGTH_LONG).show();


                }
                else{
                    // Nothing.
                }



            }

        });



    }



}
