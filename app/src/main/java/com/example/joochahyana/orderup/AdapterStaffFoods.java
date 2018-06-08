package com.example.joochahyana.orderup;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Joanna Chahyana on 9/5/2018.
 */

public class AdapterStaffFoods extends ArrayAdapter<Foods> {
    private String[] name;
    private String[] description;
    private String[] price;
    private byte[] photo;

    public AdapterStaffFoods(@NonNull Context context, ArrayList<Foods> listStaffFoods) {
        super(context, R.layout.custom_customer_menu, listStaffFoods);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View staffView = layoutInflater.inflate(R.layout.custom_staff_foods, parent, false);

        Foods foods = getItem(position);

        TextView textName = (TextView) staffView.findViewById(R.id.textStaffAppetizerName);
        TextView textDescription = (TextView) staffView.findViewById(R.id.textStaffAppetizerDescription);
        TextView textPrice = (TextView) staffView.findViewById(R.id.textStaffAppetizerPrice);
        ImageView imagePhoto = (ImageView) staffView.findViewById(R.id.imageStaffAppetizer);

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


