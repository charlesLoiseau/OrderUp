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

public class AdapterCustomerBeverage extends ArrayAdapter<Foods> {
    private String[] name;
    private String[] description;
    private String[] price;
    private Integer[] photo;


    public AdapterCustomerBeverage(@NonNull Context context, ArrayList<Foods> ListCustomerBeverages) {
        super(context, R.layout.custom_customer_menu, ListCustomerBeverages);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_customer_menu, parent, false);

        final Foods foodItem = getItem(position);

        TextView textName = (TextView) customView.findViewById(R.id.textCustomerMenuName);
        TextView textDescription = (TextView) customView.findViewById(R.id.textCustomerMenuDescription);
        TextView textPrice = (TextView) customView.findViewById(R.id.textCustomerMenuPrice);
        ImageView imagePhoto = (ImageView) customView.findViewById(R.id.imageCustomerMenu);

        textName.setText(foodItem.name);
        textDescription.setText(foodItem.description);
        textPrice.setText( foodItem.price.toString());
        setImageViewWithByteArray(imagePhoto,foodItem.photo);
        customView.findViewById(R.id.orderButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReceipt currentReceipt = null;
                DatabaseItems item = DatabaseItems.findById(DatabaseItems.class, foodItem.id);

                dbOrderSave(item);



            }
        });

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

        DatabaseOrderState dbOrderState_0 = DatabaseOrderState.find(DatabaseOrderState.class,"name = ? ", "Before ordering").get(0);
        DatabaseOrderState dbOrderState_1 = DatabaseOrderState.find(DatabaseOrderState.class,"name = ? ", "Ordering").get(0);
        DatabaseOrderState dbOrderState_2 = DatabaseOrderState.find(DatabaseOrderState.class,"name = ? ", "After ordering").get(0);
        // table =1 is just test example

        Long finder = item.getId();
        boolean flag = false;
        List<DatabaseOrder> dbOrders = DatabaseItems.listAll(DatabaseOrder.class);
        for (int i = 0; i < dbOrders.size(); i++) {
            if (dbOrders.get(i).item.getId()==finder) {
                if (dbOrders.get(i).state.name.equals(dbOrderState_0.name) ) {
                    dbOrders.get(i).state = dbOrderState_1;
                    dbOrders.get(i).fnumber = 0;
                }
                else if(dbOrders.get(i).state.name.equals(dbOrderState_2.name))
                    continue;
                dbOrders.get(i).fnumber++;
                dbOrders.get(i).save();
                flag = true;
            }
        }

        if (flag!=true) {

            DatabaseOrder dbOrder = new DatabaseOrder(0, 1, item, dbOrderState_1, false, new java.sql.Date(0));
            dbOrder.save();
        }



    }

}