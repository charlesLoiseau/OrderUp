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

/**
 * Created by Joanna Chahyana on 9/5/2018.
 */

public class AdapterStaffTables extends ArrayAdapter<Tables> {
    private String[] table;

    public AdapterStaffTables(@NonNull Context context, ArrayList<Tables> listStaffTables) {
        super(context, R.layout.custom_staff_table, listStaffTables);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_staff_table, parent, false);

        Tables tempTable = getItem(position);

        TextView textName = (TextView) customView.findViewById(R.id.textStaffTableNumber);

        textName.setText( tempTable.table);

        return customView;
    }
}