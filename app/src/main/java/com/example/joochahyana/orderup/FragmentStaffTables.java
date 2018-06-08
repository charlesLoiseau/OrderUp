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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_staff_tables, container, false);

        Spinner spinner = (Spinner)rootView.findViewById(R.id.spinnerStaffTable);

        List<DatabaseItems> dbItems = DatabaseItems.listAll(DatabaseItems.class);
        List<String> list = new ArrayList<String>();

        list.add("order 1");
        list.add("order 2");
        list.add("order 3");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(dataAdapter);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listViewStaffTables);
        if (adapter != null) {
            listView.setAdapter(adapter);
        }
    }
}
