package com.example.joochahyana.orderup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joanna Chahyana on 9/5/2018.
 */

public class FragmentStaffTables extends Fragment {

    AdapterStaffTables adapter;
    ArrayList<Tables> arrayListStaffTables;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayListStaffTables = new ArrayList<Tables>();
        adapter = new AdapterStaffTables(getActivity(), arrayListStaffTables);


        Tables table = new Tables("Table 1");
        adapter.add(table);

        Tables table2 = new Tables("Table 2");
        adapter.add(table2);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_staff_tables, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listViewStaffTables);
//        listView.getLayoutParams().height = 500;


        if (adapter != null) {
            listView.setAdapter(adapter);
        }

    }
}
