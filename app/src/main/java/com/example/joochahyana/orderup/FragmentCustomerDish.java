package com.example.joochahyana.orderup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joanna Chahyana on 8/5/2018.
 */

public class FragmentCustomerDish extends Fragment{

    AdapterCustomerDish adapter = null;
    ArrayList<Foods> arrayListCustomerDish;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayListCustomerDish = new ArrayList<Foods>();
        adapter = new AdapterCustomerDish(getActivity(), arrayListCustomerDish);


        List<DatabaseItems> dbItems = DatabaseItems.listAll(DatabaseItems.class);
        for (int i = 0; i < dbItems.size(); i++) {
            if (dbItems.get(i).itemType.name.equals("Dishes") && dbItems.get(i).display == true) {
                Foods tempFood = new Foods(dbItems.get(i).name, dbItems.get(i).getId(), dbItems.get(i).description, dbItems.get(i).price, dbItems.get(i).itemImage.imageStream);
                adapter.add(tempFood);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_customer_dish, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listViewCustomerDish);
        if (adapter != null) {
            listView.setAdapter(adapter);
        }
    }
}
