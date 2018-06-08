package com.example.joochahyana.orderup;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;






public class foodstaffActivity extends AppCompatActivity {



    // Camera Option
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_IMAGE_LOAD = 2;

    String mCurrentPhotoPath;
    Uri photoURI, albumURI = null;
    Boolean album = false;
    ImageView caputreImage;
    byte[] captureImagebyte = null;
    // for save data
    String foodName = null;
    String foodDescrption = null;
    double foodPrice = 0.0;
    int foodTypeNameID;
    String foodTypeName = null;
    Integer foodStock = 0;

    // input text
    EditText editTextFoodName;
    EditText editTextFoodDes;
    EditText editTextPrice;
    EditText editTextStock;
    RadioGroup foodType;
    DatabaseItems item = null;

    //button
    Button enrollButton, takingPicture, loadingPicture;

    public void onFoodTypeSelect(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.appetizerButton:
                if (checked)
                    foodTypeName = "Appetizers";
                    break;
            case R.id.dishButton:
                if (checked)
                    foodTypeName = "Dishes";
                    break;
            case R.id.beverageButton:
                if (checked)
                    foodTypeName = "Beverages";
                    break;
            case R.id.dessertButton:
                if (checked)
                    foodTypeName = "Desserts";
                    break;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodstaff);

        caputreImage  =(ImageView) findViewById(R.id.imagePicutreTest);
        takingPicture = (Button)findViewById(R.id.buttonTakingPicutre);
        loadingPicture =(Button)findViewById(R.id.buttonLoadingPicutre);
        enrollButton = (Button)findViewById(R.id.buttonEnroll);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Long itemID = extras.getLong("id");
            item = DatabaseItems.findById(DatabaseItems.class, itemID);
            ((EditText)findViewById(R.id.editTextFoodName)).setText(item.name);
            ((EditText)findViewById(R.id.editTextFoodDes)).setText(item.description);
            ((EditText)findViewById(R.id.editTextFoodPrice)).setText(item.price.toString());
            ((EditText)findViewById(R.id.editTextFoodStock)).setText(item.stock.toString());
            ((ImageView)findViewById(R.id.imagePicutreTest)).setImageBitmap(BitmapFactory.decodeByteArray(item.itemImage.imageStream, 0, item.itemImage.imageStream.length));
            foodTypeName = item.itemType.name;
            switch (item.itemType.name) {
                case "Appetizers": ((RadioButton)findViewById(R.id.appetizerButton)).setChecked(true);
                    break;
                case "Dishes": ((RadioButton)findViewById(R.id.dishButton)).setChecked(true);
                    break;
                case "Desserts": ((RadioButton)findViewById(R.id.dessertButton)).setChecked(true);
                    break;
                case "Beverages": ((RadioButton)findViewById(R.id.beverageButton)).setChecked(true);
                    break;
            }

        }

        //taking button
        takingPicture.setOnClickListener(new Button.OnClickListener(){
            @Override //
            public  void onClick(View view) {
                int permissionChedk = ContextCompat.checkSelfPermission(foodstaffActivity.this,Manifest.permission.CAMERA);
                if (permissionChedk==PackageManager.PERMISSION_DENIED)
                {
                    ActivityCompat.requestPermissions(foodstaffActivity.this,new String[]{
                            Manifest.permission.CAMERA},0);
                }
                else {
                    try {

                        dispatchTakePictureIntent();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        //loading button
        loadingPicture.setOnClickListener(new Button.OnClickListener(){
            @Override
            public  void onClick(View view) {
                doTakeAlbumAction();
            }
        });



        //enroll button
        enrollButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public  void onClick(View view){

                editTextFoodName = (EditText)findViewById(R.id.editTextFoodName);
                editTextFoodDes = (EditText)findViewById(R.id.editTextFoodDes);
                editTextPrice = (EditText)findViewById(R.id.editTextFoodPrice);
                editTextStock = (EditText)findViewById(R.id.editTextFoodStock);
                captureImagebyte = image_view2byte(caputreImage);


                if (StringUtils.isEmpty(editTextFoodDes.getText()) || StringUtils.isEmpty(editTextFoodName.getText()) || StringUtils.isEmpty(editTextPrice.getText()) || StringUtils.isEmpty(editTextStock.getText()) || captureImagebyte == null) {
                    Context context = getApplicationContext();
                    CharSequence text = "Incomplet informations";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else
                {
                    foodName = editTextFoodName.getText().toString();
                    foodDescrption = editTextFoodDes.getText().toString();
                    foodPrice = Double.parseDouble(nullpointer_to_0string(editTextPrice.getText().toString()));
                    foodType = (RadioGroup)findViewById(R.id.radioGroup);
                    foodStock = Integer.parseInt(nullpointer_to_0string(editTextStock.getText().toString()));
                    DatabaseItemType dbFoodType = DatabaseItemType.find(DatabaseItemType.class, "name = ?", foodTypeName).get(0);
                    if (item != null)
                        item.itemImage.delete();
                    DatabaseItemsImage dbFoodImage = new DatabaseItemsImage(captureImagebyte);
                    dbFoodImage.save();

                    if (item == null) {
                        DatabaseItems dbFood = new DatabaseItems(dbFoodType, foodName, foodPrice, foodDescrption, foodStock, dbFoodImage, true);
                        dbFood.save();
                        //DatabaseMenu dbMenu = new DatabaseMenu(foodName, foodPrice);                                                 // Should I get more foodName for menu as input?
                        //dbMenu.save();
                        //DatabaseMenuItem dbMenuItem = new DatabaseMenuItem(dbFood, dbMenu);
                        //dbMenuItem.save();
                    } else {
                        item.name = foodName;
                        item.description = foodDescrption;
                        item.price = foodPrice;
                        item.itemType = dbFoodType;
                        item.stock = foodStock;
                        //item.itemImage.delete();
                        item.itemImage = dbFoodImage;
                        item.save();
                    }

                    startTapedActivity();
                }

            }
        });




    }
    protected String nullpointer_to_0string(String a){
        if (a==null)
            return "0";
        else
            return a;
    }
    public  void startTapedActivity(){
        // erase all plz

        Intent intent = new Intent(this, TabbedActivityStaff.class);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,@NonNull String[] permision,@NonNull int[] grantresult){
        if (requestCode==0)
            if (grantresult[0]==0){
                Toast.makeText(this,"camara permision ",Toast.LENGTH_LONG).show();

            }
            else {
                Toast.makeText(this,"camara permision denyed ",Toast.LENGTH_LONG).show();
            }
    }

    private void dispatchTakePictureIntent() throws IOException {


        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }



    }

    private  File createImageFile() throws  IOException{
        String imageFileName = "temp_" + String.valueOf(System.currentTimeMillis()+".jpg");
        File storageDir = new File(Environment.getExternalStorageDirectory(),imageFileName);
        mCurrentPhotoPath = storageDir.getAbsolutePath();
        return storageDir;
    }

    private void doTakeAlbumAction(){

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, REQUEST_IMAGE_LOAD);

    }



    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){



        if(resultCode != RESULT_OK){
            Toast.makeText(getApplicationContext(), "NOT OK RESULT", Toast.LENGTH_SHORT).show();
        }
        else{
            switch (requestCode){
                case REQUEST_IMAGE_LOAD:
                    album =true;
                    photoURI = data.getData();
                    if (photoURI==null)
                        Toast.makeText(getApplicationContext(),"null", Toast.LENGTH_SHORT).show();
                    else {
                        Toast.makeText(getApplicationContext(), photoURI.toString(), Toast.LENGTH_SHORT).show();


                        Bitmap bitmap = null;

                        try {
                            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoURI);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        caputreImage.setImageBitmap(bitmap);
                    }
                    break;
                case REQUEST_IMAGE_CAPTURE:
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    caputreImage.setImageBitmap(imageBitmap);

                    break;

            }

        }
    }

protected byte[] image_view2byte(ImageView imageView){
        try {
            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG,100,baos);
            return baos.toByteArray();
        } catch(Exception ex) {
            return null;
        }

}

}
