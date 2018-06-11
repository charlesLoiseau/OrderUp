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
import java.util.List;

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
        View customView = layoutInflater.inflate(R.layout.custom_customer_menu, parent, false);

        final Foods foodItem= getItem(position);

        TextView textName = (TextView) customView.findViewById(R.id.textCustomerMenuName);
        TextView textDescription = (TextView) customView.findViewById(R.id.textCustomerMenuDescription);
        TextView textPrice = (TextView) customView.findViewById(R.id.textCustomerMenuPrice);
        ImageView imagePhoto = (ImageView) customView.findViewById(R.id.imageCustomerMenu);

        textName.setText( foodItem.name);
        textDescription.setText( foodItem.description);
        textPrice.setText( foodItem.price.toString());
        setImageViewWithByteArray(imagePhoto,foodItem.photo);

        // working place
        //Push the ReceiptItem


        customView.findViewById(R.id.orderButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseItems item = DatabaseItems.findById(DatabaseItems.class, foodItem.id);
               dbOrderSave(item);



            }
        });


        //

        return customView;
    }
    // if you have a time, make a class please.
    public void setImageViewWithByteArray(ImageView view, byte[] data){
        Bitmap bitmap  = BitmapFactory.decodeByteArray(data,0,data.length);
        view.setImageBitmap(bitmap);
    }
    private void dbOrderSave(DatabaseItems item){
        // In Front : move on order tap
        // In back : order state -> before ordering -> ordering

        DatabaseOrderState dbOrderState_Before_ordering = DatabaseOrderState.find(DatabaseOrderState.class,"name = ? ", "Before ordering").get(0);
        DatabaseOrderState dbOrderState_Ordering = DatabaseOrderState.find(DatabaseOrderState.class,"name = ? ", "Ordering").get(0);
        DatabaseOrderState dbOrderState_After_ordering = DatabaseOrderState.find(DatabaseOrderState.class,"name = ? ", "After ordering").get(0);
        // table =1 is just test example

        Long finder = item.getId();
        boolean flag = false;
        List<DatabaseOrder> ListdbOrders = DatabaseItems.listAll(DatabaseOrder.class);
        for (int i = 0; i < ListdbOrders.size(); i++) {
            if (ListdbOrders.get(i).item.getId()==finder) {
                flag = true;
                if (ListdbOrders.get(i).state.name.equals(dbOrderState_Before_ordering.name)) {
                    ListdbOrders.get(i).state = dbOrderState_Ordering;
                    ListdbOrders.get(i).fnumber = 0;
                    ListdbOrders.get(i).save();
                } else if (ListdbOrders.get(i).state.name.equals(dbOrderState_After_ordering.name) && false == ListdbOrders.get(i).done) {
                    DatabaseOrder dbOrder = new DatabaseOrder(0, 1, item, dbOrderState_Ordering, false, new java.sql.Date(0));
                    dbOrder.save();
                    ListdbOrders.get(i).save();
                } else if (ListdbOrders.get(i).state.name.equals(dbOrderState_After_ordering.name) && ListdbOrders.get(i).done) {
                    ListdbOrders.get(i).state = dbOrderState_Ordering;
                    ListdbOrders.get(i).fnumber = 0;
                    ListdbOrders.get(i).save();
                } else if (ListdbOrders.get(i).state.name.equals(dbOrderState_Ordering.name) && false == ListdbOrders.get(i).done) {
                    ListdbOrders.get(i).fnumber++;
                    ListdbOrders.get(i).save();
                } else {
                    DatabaseOrder dbOrder = new DatabaseOrder(0, 1, item, dbOrderState_Ordering, false, new java.sql.Date(0));
                    dbOrder.save();
                }
            }
        }
        if (flag == false ) {

            DatabaseOrder dbOrder = new DatabaseOrder(0, 1, item, dbOrderState_Ordering, false, new java.sql.Date(0));
            dbOrder.save();
        }



    }
}