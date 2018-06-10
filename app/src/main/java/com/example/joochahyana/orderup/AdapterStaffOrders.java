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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Date;

public class AdapterStaffOrders extends ArrayAdapter<Orders> {

    private Date time;
    private Integer table;
    private Boolean done;
    private String state;
    private TextView pricetext;
    private TextView tablenumber;
    private  TextView foodnumber;
    private TextView foodname;
    private TextView fooddicp;
    private Button donebtn;
    private ImageView foodImage;
    private Context context;
    public AdapterStaffOrders(@NonNull Context context, ArrayList<Orders> listStaffFoods) {
        super(context, R.layout.custom_customer_menu, listStaffFoods);
        this.context = context;
    }


    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View staffView = layoutInflater.inflate(R.layout.custom_staff_order, parent, false);

        final Orders orders = getItem(position);

        pricetext = staffView.findViewById(R.id.textStaffprice);
        tablenumber = staffView.findViewById(R.id.custom_staff_orderTable);
        foodnumber = staffView.findViewById(R.id.CustomStafffoodnumber);
        foodname = staffView.findViewById(R.id.custom_staff_foodname);
        fooddicp = staffView.findViewById(R.id.custom_staff_dicription);
        donebtn = staffView.findViewById(R.id.customstaffdone);
       foodImage = staffView.findViewById(R.id.imageStaffItem);


       pricetext.setText(orders.foodInfo.price.toString());
       tablenumber.setText(orders.tnumber.toString());
       foodnumber.setText(orders.fnumber.toString());
       fooddicp.setText(orders.foodInfo.description);
       donebtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context, TabbedActivityStaff.class);
               DatabaseOrderState dbOst=  DatabaseOrderState.find(DatabaseOrderState.class, "name = ?","Before ordering").get(0);
               DatabaseOrder dbOrder =SugarRecord.findById(DatabaseOrder.class,orders.id);
               dbOrder.state = dbOst;
               dbOrder.done = true;
               dbOrder.save();
               v.getContext().startActivity(intent);

           }
       });
       setImageViewWithByteArray(foodImage,orders.foodInfo.photo);


        return staffView;
    }

    public void setImageViewWithByteArray(ImageView view, byte[] data){
        Bitmap bitmap  = BitmapFactory.decodeByteArray(data,0,data.length);
        view.setImageBitmap(bitmap);
    }

}


