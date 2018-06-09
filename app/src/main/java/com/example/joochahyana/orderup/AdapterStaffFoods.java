package com.example.joochahyana.orderup;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Joanna Chahyana on 9/5/2018.
 */

public class AdapterStaffFoods extends ArrayAdapter<Foods> {
    private String[] name;
    private String[] description;
    private String[] price;
    private byte[] photo;
    private Context context;

    Button editButton;
    Button deleteButton;

    public AdapterStaffFoods(@NonNull Context context, ArrayList<Foods> listStaffFoods) {
        super(context, R.layout.custom_staff_foods, listStaffFoods);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View staffView = layoutInflater.inflate(R.layout.custom_staff_foods, parent, false);

        final Foods foods = getItem(position);

        final TextView textName = (TextView) staffView.findViewById(R.id.itemName);
        TextView textDescription = (TextView) staffView.findViewById(R.id.textStaffAppetizerDescription);
        TextView textPrice = (TextView) staffView.findViewById(R.id.textStaffAppetizerPrice);
        ImageView imagePhoto = (ImageView) staffView.findViewById(R.id.imageStaffAppetizer);

        editButton = (Button)staffView.findViewById(R.id.editButton);
        deleteButton = (Button)staffView.findViewById(R.id.deleteButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, foodstaffActivity.class);
                intent.putExtra("id", foods.id);
                view.getContext().startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TabbedActivityStaff.class);
                DatabaseItems item = DatabaseItems.findById(DatabaseItems.class, foods.id);
                item.display = false;
                item.save();
                view.getContext().startActivity(intent);
            }
        });

        textName.setText(foods.name);
        textDescription.setText(foods.description);
        textPrice.setText(foods.price.toString());
        setImageViewWithByteArray(imagePhoto,foods.photo);

        return staffView;
    }



    public void setImageViewWithByteArray(ImageView view, byte[] data){
        Bitmap bitmap  = BitmapFactory.decodeByteArray(data,0,data.length);
        view.setImageBitmap(bitmap);
    }



}


