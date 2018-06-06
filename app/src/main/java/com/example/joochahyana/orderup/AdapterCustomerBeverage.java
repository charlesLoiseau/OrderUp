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

        Foods foodItem = getItem(position);

        TextView textName = (TextView) customView.findViewById(R.id.textCustomerMenuName);
        TextView textDescription = (TextView) customView.findViewById(R.id.textCustomerMenuDescription);
        TextView textPrice = (TextView) customView.findViewById(R.id.textCustomerMenuPrice);
        ImageView imagePhoto = (ImageView) customView.findViewById(R.id.imageCustomerMenu);

        textName.setText(foodItem.name);
        textDescription.setText(foodItem.description);
        textPrice.setText(foodItem.price);
        imagePhoto.setImageResource(foodItem.photo);

        return customView;
    }
}