package com.example.joochahyana.orderup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joanna Chahyana on 8/5/2018.
 */

public class FragmentCustomerBeverage extends Fragment{

    AdapterCustomerBeverage adapter = null;
    ArrayList<Foods> arrayListCustomerBeverage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayListCustomerBeverage = new ArrayList<Foods>();
        adapter = new AdapterCustomerBeverage(getActivity(), arrayListCustomerBeverage);
        List<DatabaseItems> dbItems = DatabaseItems.listAll(DatabaseItems.class);
        for (int i = 0; i < dbItems.size(); i++) {
            if (dbItems.get(i).itemType.name.equals("Beverages") && dbItems.get(i).display == true) {
                Foods tempFood = new Foods(dbItems.get(i).name, dbItems.get(i).getId(), dbItems.get(i).description, dbItems.get(i).price, dbItems.get(i).itemImage.imageStream,dbItems.get(i).stock);
                adapter.add(tempFood);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_customer_beverage, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listViewCustomerBeverage);
        if (adapter != null) {
            listView.setAdapter(adapter);
        }
    }
}
