package com.example.joochahyana.orderup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class AdapterCustomerAppetizer extends ArrayAdapter<Foods> {
    private String[] name;
    private String[] description;
    private String[] price;
    private byte[] photo;

    public AdapterCustomerAppetizer(@NonNull Context context, ArrayList<Foods> listCustomerAppetizers) {
        super(context, R.layout.custom_customer_menu, listCustomerAppetizers);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_customer_appetizer, parent, false);

        Foods foodItem= getItem(position);

        TextView textName = (TextView) customView.findViewById(R.id.textCustomerAppetizerName);
        TextView textDescription = (TextView) customView.findViewById(R.id.textCustomerAppetizerDescription);
        TextView textPrice = (TextView) customView.findViewById(R.id.textCustomerAppetizerPrice);
        ImageView imagePhoto = (ImageView) customView.findViewById(R.id.imageCustomerAppetizer);

        textName.setText( foodItem.name);
        textDescription.setText( foodItem.description);
        textPrice.setText( foodItem.price.toString());
        setImageViewWithByteArray(imagePhoto,foodItem.photo);


        return customView;
    }
    // if you have a time, make a class please.
    public void setImageViewWithByteArray(ImageView view, byte[] data){
        Bitmap bitmap  = BitmapFactory.decodeByteArray(data,0,data.length);
        view.setImageBitmap(bitmap);
    }


}