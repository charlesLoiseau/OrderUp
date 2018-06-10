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
 * Created by Joanna Chahyana on 9/5/2018.
 */

public class FragmentStaffBills extends Fragment {

    AdapterStaffBills adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeAdapter();
    }

    private void makeAdapter() {
        ArrayList<Bills> arrayListStaffBills = new ArrayList<Bills>();
        adapter = new AdapterStaffBills(getActivity(), arrayListStaffBills);

        List<DatabaseReceipt> dbReceipt = DatabaseReceipt.listAll(DatabaseReceipt.class);




        for(int i=0; i<dbReceipt.size(); i++){
            if(dbReceipt.get(i).paid==false) {
                Bills tempBills = new Bills(dbReceipt.get(i).tnumber, dbReceipt.get(i).price);
                tempBills.setId(dbReceipt.get(i).getId());
                adapter.add(tempBills);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        makeAdapter();
        View rootView = inflater.inflate(R.layout.fragment_staff_bills, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ListView listView = (ListView) view.findViewById(R.id.listViewStaffBills);
        listView.setAdapter(adapter);

    }
}
