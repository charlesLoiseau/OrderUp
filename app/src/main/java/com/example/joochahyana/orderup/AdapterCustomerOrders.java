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
import java.util.Calendar;

public class AdapterCustomerOrders extends ArrayAdapter<Foods> {

    private String[] name;
    private String[] description;
    private String[] price;
    private byte[] photo;
    private Foods foodItem;

    public AdapterCustomerOrders(@NonNull Context context, ArrayList<Foods> listCustomerAppetizers) {
        super(context, R.layout.custom_customer_order, listCustomerAppetizers);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_customer_order, parent, false);

        foodItem= getItem(position);

        TextView textName = (TextView) customView.findViewById(R.id.textCustomerOrderName);
        TextView textDescription = (TextView) customView.findViewById(R.id.textCustomerOrderDescription);
        TextView textPrice = (TextView) customView.findViewById(R.id.textCustomerOrderPrice);
        ImageView imagePhoto = (ImageView) customView.findViewById(R.id.imageCustomerOrder);

        textName.setText( foodItem.name);
        textDescription.setText( foodItem.description);
        textPrice.setText( foodItem.price.toString());
        setImageViewWithByteArray(imagePhoto,foodItem.photo);



        return customView;
    }


    public void setImageViewWithByteArray(ImageView view, byte[] data){
        Bitmap bitmap  = BitmapFactory.decodeByteArray(data,0,data.length);
        view.setImageBitmap(bitmap);
    }

}

