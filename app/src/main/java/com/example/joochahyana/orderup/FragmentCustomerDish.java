package com.example.joochahyana.orderup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Joanna Chahyana on 8/5/2018.
 */

public class FragmentCustomerDish extends Fragment{

    AdapterCustomerDish adapter;
    ArrayList<Foods> arrayListCustomerDish;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayListCustomerDish = new ArrayList<Foods>();
        adapter = new AdapterCustomerDish(getActivity(), arrayListCustomerDish);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_customer_dish, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listViewCustomerDessert);
        listView.setAdapter(adapter);
    }
}
