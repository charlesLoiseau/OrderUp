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

public class FragmentCustomerBeverage extends Fragment{

    AdapterCustomerBeverage adapter;
    ArrayList<Foods> arrayListCustomerBeverage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayListCustomerBeverage = new ArrayList<Foods>();
        adapter = new AdapterCustomerBeverage(getActivity(), arrayListCustomerBeverage);

        Foods food1 = new Foods("Beverage Name 1", "Description of beverage 1", "$10.00", R.drawable.pic01,Foods.Beverage);
        adapter.add(food1);
        Foods food2 = new Foods("Beverage Name 2", "Description of beverage 2", "$20.00", R.drawable.pic02,Foods.Beverage);
        adapter.add(food2);
        Foods food3 = new Foods("Beverage Name 3", "Description of beverage 3", "$30.00", R.drawable.pic03,Foods.Beverage);
        adapter.add(food3);
        Foods food4 = new Foods("Beverage Name 4", "Description of beverage 4", "$40.00", R.drawable.pic04,Foods.Beverage);
        adapter.add(food4);
        Foods food5 = new Foods("Beverage Name 5", "Description of beverage 5", "$50.00", R.drawable.pic05,Foods.Beverage);
        adapter.add(food5);
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
        listView.setAdapter(adapter);
    }
}
