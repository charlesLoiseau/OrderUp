package com.example.joochahyana.orderup;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;


public class AdapterStaffBills extends ArrayAdapter<Bills>{
    private String[] tableNumber;
    private Double price;
    private Context context;


    public AdapterStaffBills(@NonNull Context context, ArrayList<Bills> listStaffBills) {
        super(context, R.layout.custom_staff_bill, listStaffBills);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View staffView = layoutInflater.inflate(R.layout.custom_staff_bill, parent, false);

         Bills bills = getItem(position);

        TextView textBillTableNumber = (TextView) staffView.findViewById(R.id.textStaffBillTableNumber);
        TextView textBillPrice = (TextView) staffView.findViewById(R.id.textStaffBillPrice);

        textBillTableNumber.setText(bills.tNumber.toString());
        textBillPrice.setText(String.valueOf(bills.price));


        return staffView;
    }

    }
