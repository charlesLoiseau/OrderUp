package com.example.joochahyana.orderup;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.orm.SugarDb;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

        final Bills bills = getItem(position);


        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View staffView = layoutInflater.inflate(R.layout.custom_staff_bill, parent, false);


        TextView textBillTableNumber = (TextView) staffView.findViewById(R.id.textStaffBillTableNumber);
        TextView textBillPrice = (TextView) staffView.findViewById(R.id.textStaffBillPrice);
        Button doneBtn = (Button) staffView.findViewById(R.id.buttonStaffBill);
        textBillTableNumber.setText(bills.tNumber.toString());
        textBillPrice.setText(String.valueOf(bills.price));

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TabbedActivityStaff.class);

                DatabaseReceipt Rcp= SugarRecord.findById(DatabaseReceipt.class, bills.getId());


                Rcp.paid =true;
                Rcp.save();

                v.getContext().startActivity(intent);
            }
        });


        return staffView;
    }

    }
