package com.example.joochahyana.orderup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joanna Chahyana on 9/5/2018.
 */

public class AdapterStaffTables extends ArrayAdapter<Tables> {
    private String[] table;
    private Context context;

    AdapterStaffTables_Foods adapter2;
    ArrayList<Tables_Foods> arrayListStaffTables_Foods;

    public AdapterStaffTables(@NonNull Context context, ArrayList<Tables> listStaffTables) {
        super(context, R.layout.custom_staff_table, listStaffTables);
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_staff_table, parent, false);

        Tables tempTable = getItem(position);

        TextView textName = (TextView) customView.findViewById(R.id.textStaffTableNumber);

        textName.setText( tempTable.table);

//        Spinner spinner = (Spinner)customView.findViewById(R.id.spinnerStaffTable);
//
//        List<DatabaseItems> dbItems = DatabaseItems.listAll(DatabaseItems.class);
//        String[] list = new String[]{
//                "order 1",
//                "order 2",
//                "order 3"};
//
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, list);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//        spinner.setAdapter(dataAdapter);

        arrayListStaffTables_Foods = new ArrayList<Tables_Foods>();
        adapter2 = new AdapterStaffTables_Foods(context, arrayListStaffTables_Foods);

        Tables_Foods test1 = new Tables_Foods("order1");
        adapter2.add(test1);
        Tables_Foods test2 = new Tables_Foods("order2");
        adapter2.add(test2);
        Tables_Foods test3 = new Tables_Foods("order3");
        adapter2.add(test3);
        Tables_Foods test4 = new Tables_Foods("order2");
        adapter2.add(test4);
        Tables_Foods test5 = new Tables_Foods("order3");
        adapter2.add(test5);

        final ListView listView2 = (ListView) customView.findViewById(R.id.listViewStaffTableFoods);
        ViewGroup.LayoutParams params = listView2.getLayoutParams();
        listView2.setVisibility(View.GONE);
        params.height = 80 * 5;
        listView2.setLayoutParams(params);

        if(adapter2 != null){
            listView2.setAdapter(adapter2);
        }

        TextView tableNumber = customView.findViewById(R.id.textStaffTableNumber);

        tableNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(listView2.getVisibility() == View.VISIBLE){
                    listView2.setVisibility(View.GONE);
                }else{
                    listView2.setVisibility(View.VISIBLE);
                }
            }
        });

        return customView;
    }
}