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

        Foods food1 = new Foods("Dish Name 1", "Description of dish 1", "$10.00", R.drawable.pic01,Foods.Dish);
        adapter.add(food1);
        Foods food2 = new Foods("Dish Name 2", "Description of dish 2", "$20.00", R.drawable.pic02,Foods.Dish);
        adapter.add(food2);
        Foods food3 = new Foods("Dish Name 3", "Description of dish 3", "$30.00", R.drawable.pic03,Foods.Dish);
        adapter.add(food3);
        Foods food4 = new Foods("Dish Name 4", "Description of dish 4", "$40.00", R.drawable.pic04,Foods.Dish);
        adapter.add(food4);
        Foods food5 = new Foods("Dish Name 5", "Description of dish 5", "$50.00", R.drawable.pic05,Foods.Dish);
        adapter.add(food5);
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
