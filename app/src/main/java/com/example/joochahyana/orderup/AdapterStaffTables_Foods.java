package com.example.joochahyana.orderup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joanna Chahyana on 9/5/2018.
 */

public class AdapterStaffTables_Foods extends ArrayAdapter<Tables_Foods> {
    private String[] name;
    private Context context;

    public AdapterStaffTables_Foods(@NonNull Context context, ArrayList<Tables_Foods> listStaffTables_Foods) {
        super(context, R.layout.custom_staff_table_food, listStaffTables_Foods);
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_staff_table_food, parent, false);

        Tables_Foods tempName = getItem(position);

        TextView textName = (TextView) customView.findViewById(R.id.textStaffTableFoodName);

        textName.setText( tempName.name);

        return customView;
    }
}