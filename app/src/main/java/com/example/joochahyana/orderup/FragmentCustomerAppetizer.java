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

public class FragmentCustomerAppetizer extends Fragment{

    AdapterCustomerAppetizer adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ArrayList<ListCustomerAppetizer> arrayListCustomerAppetizer = new ArrayList<ListCustomerAppetizer>();
        adapter = new AdapterCustomerAppetizer(getActivity(), arrayListCustomerAppetizer);


  /*
        foodNumber = arrayListCustomerAppetizer.size();
        for(int i=0; i<foodNumber; i++){
            adapter.add(arrayListCustomerAppetizer.get(i));

        }
     */
        ListCustomerAppetizer food1 = new ListCustomerAppetizer("Food Name 1", "Description of food 1", "$10.00", R.drawable.pic01);
        adapter.add(food1);
        ListCustomerAppetizer food2 = new ListCustomerAppetizer("Food Name 2", "Description of food 2", "$20.00", R.drawable.pic02);
        adapter.add(food2);
        ListCustomerAppetizer food3 = new ListCustomerAppetizer("Food Name 3", "Description of food 3", "$30.00", R.drawable.pic03);
        adapter.add(food3);
        ListCustomerAppetizer food4 = new ListCustomerAppetizer("Food Name 4", "Description of food 4", "$40.00", R.drawable.pic04);
        adapter.add(food4);
        ListCustomerAppetizer food5 = new ListCustomerAppetizer("Food Name 5", "Description of food 5", "$50.00", R.drawable.pic05);
        adapter.add(food5);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_customer_appetizer, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listViewCustomerAppetizer);
        listView.setAdapter(adapter);
    }
}
