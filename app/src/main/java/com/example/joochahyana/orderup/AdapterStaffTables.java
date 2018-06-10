package com.example.joochahyana.orderup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
        params.height = getParamsHeight(parent,5,40);
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
    protected int getParamsHeight(@NonNull ViewGroup  parent,int numberElem,int freeup ){
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_staff_table, parent, false);
        View inListtView = layoutInflater.inflate(R.layout.custom_staff_table_food,parent,false);
        final ListView listView2 = (ListView) customView.findViewById(R.id.listViewStaffTableFoods);
        final View listEle = inListtView.findViewById(R.id.table_food_Layout);
        final View TableInfo = customView.findViewById(R.id.Layout_table);
        ViewGroup.LayoutParams params = listView2.getLayoutParams();
        listView2.setVisibility(View.GONE);
        listEle.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        TableInfo.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        return listEle.getMeasuredHeight()* numberElem + TableInfo.getMeasuredHeight()+freeup;//

    }
}