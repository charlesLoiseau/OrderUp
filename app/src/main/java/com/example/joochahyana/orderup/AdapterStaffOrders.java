package com.example.joochahyana.orderup;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class AdapterStaffOrders extends ArrayAdapter<Orders> {

    private Date time;
    private Integer table;
    private Boolean done;
    private String state;

    public AdapterStaffOrders(@NonNull Context context, ArrayList<Orders> listStaffFoods) {
        super(context, R.layout.custom_customer_menu, listStaffFoods);
    }


    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View staffView = layoutInflater.inflate(R.layout.custom_staff_order, parent, false);

        Orders orders = getItem(position);

        TextView textOrderFoodName = (TextView) staffView.findViewById(R.id.textStaffOrderName);
        TextView textOrderTableNumber = (TextView) staffView.findViewById(R.id.textStaffOrderTableNumber);


        textOrderFoodName.setText(orders.foodInfo.name);
        textOrderTableNumber.setText("Table:" + orders.table.toString());


        return staffView;
    }



}


