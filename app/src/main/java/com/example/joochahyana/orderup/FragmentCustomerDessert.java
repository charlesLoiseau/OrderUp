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

public class FragmentCustomerDessert extends Fragment{

    AdapterCustomerDessert adapter;
    ArrayList<Foods> arrayListCustomerDessert;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayListCustomerDessert = new ArrayList<Foods>();
        adapter = new AdapterCustomerDessert(getActivity(), arrayListCustomerDessert);

        Foods food1 = new Foods("Dessert Name 1", "Description of dessert 1", "$10.00", R.drawable.pic01,Foods.Dessert);
        adapter.add(food1);
        Foods food2 = new Foods("Dessert Name 2", "Description of dessert 2", "$20.00", R.drawable.pic02,Foods.Dessert);
        adapter.add(food2);
        Foods food3 = new Foods("Dessert Name 3", "Description of dessert 3", "$30.00", R.drawable.pic03,Foods.Dessert);
        adapter.add(food3);
        Foods food4 = new Foods("Dessert Name 4", "Description of dessert 4", "$40.00", R.drawable.pic04,Foods.Dessert);
        adapter.add(food4);
        Foods food5 = new Foods("Dessert Name 5", "Description of dessert 5", "$50.00", R.drawable.pic05,Foods.Dessert);
        adapter.add(food5);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_customer_dessert, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listViewCustomerDessert);
        listView.setAdapter(adapter);
    }
}
