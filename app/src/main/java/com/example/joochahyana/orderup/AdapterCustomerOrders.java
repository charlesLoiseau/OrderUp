package com.example.joochahyana.orderup;

import android.content.Context;
import android.content.Intent;
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

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Calendar;

public class AdapterCustomerOrders extends ArrayAdapter<Orders> {

    private String[] name;
    private String[] description;
    private String[] price;
    private byte[] photo;
    private ImageView plusImage;
    private ImageView minusImage;
    private TextView Quanty;
    public AdapterCustomerOrders(@NonNull Context context, ArrayList<Orders> listCustomerAppetizers) {
        super(context, R.layout.custom_customer_order, listCustomerAppetizers);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_customer_order, parent, false);

        final Orders OrderItem= getItem(position);

        TextView textName = (TextView) customView.findViewById(R.id.textCustomerOrderName);
        TextView textDescription = (TextView) customView.findViewById(R.id.textCustomerOrderDescription);
        TextView textPrice = (TextView) customView.findViewById(R.id.textCustomerOrderPrice);
        ImageView imagePhoto = (ImageView) customView.findViewById(R.id.imageCustomerOrder);
        plusImage = (ImageView) customView.findViewById(R.id.imageCustomerOrderPlus);
        minusImage = (ImageView) customView.findViewById(R.id.imageCustomerOrderMinus);
        Quanty = (TextView) customView.findViewById(R.id.textCustomerOrderQuantity);
        plusImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderItem.fnumber++;
                Quanty.setText(OrderItem.fnumber);
            }
        });

        minusImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderItem.fnumber--;
                if(OrderItem.fnumber<0)
                    OrderItem.fnumber = 0;
                Quanty.setText(OrderItem.fnumber);
            }
        });
        textName.setText( OrderItem.foodInfo.name);
        textDescription.setText( OrderItem.foodInfo.description);
        textPrice.setText( OrderItem.foodInfo.price.toString());
        setImageViewWithByteArray(imagePhoto,OrderItem.foodInfo.photo);
        Quanty.setText(OrderItem.fnumber.toString());

        return customView;
    }





    public void setImageViewWithByteArray(ImageView view, byte[] data){
        Bitmap bitmap  = BitmapFactory.decodeByteArray(data,0,data.length);
        view.setImageBitmap(bitmap);
    }

}

