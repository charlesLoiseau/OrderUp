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
    ArrayList<Foods> arrayListCustomerAppetizer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayListCustomerAppetizer = new ArrayList<Foods>();
        adapter = new AdapterCustomerAppetizer(getActivity(), arrayListCustomerAppetizer);

        Foods food1 = new Foods("Appetizer Name 1", "Description of appetizer 1", "$10.00", R.drawable.pic01,Foods.Appetizer);
        adapter.add(food1);
        Foods food2 = new Foods("Appetizer Name 2", "Description of appetizer 2", "$20.00", R.drawable.pic02,Foods.Appetizer);
        adapter.add(food2);
        Foods food3 = new Foods("Appetizer Name 3", "Description of appetizer 3", "$30.00", R.drawable.pic03,Foods.Appetizer);
        adapter.add(food3);
        Foods food4 = new Foods("Appetizer Name 4", "Description of appetizer 4", "$40.00", R.drawable.pic04,Foods.Appetizer);
        adapter.add(food4);
        Foods food5 = new Foods("Appetizer Name 5", "Description of appetizer 5", "$50.00", R.drawable.pic05,Foods.Appetizer);
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
