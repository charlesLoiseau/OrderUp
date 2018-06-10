package com.example.joochahyana.orderup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Joanna Chahyana on 9/5/2018.
 */

public class FragmentStaffOrders extends Fragment {
    AdapterStaffOrders adapter;
    ArrayList<Orders> arrayListStaffOrder;
    int DbOrderssize ;
    Button orderbuttton;
    Double getPrice;
    TextView totalAmount;
    EditText TableNum;
    DatabaseReceipt currentReceipt;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        makeAdapter();
        View rootView = inflater.inflate(R.layout.fragment_staff_orders, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ListView listView = (ListView) view.findViewById(R.id.listViewStaffOrders);
        if (adapter != null) {
            listView.setAdapter(adapter);
        }
    }

    protected  void makeAdapter(){
        arrayListStaffOrder = new ArrayList<Orders>();
        adapter = new AdapterStaffOrders(getActivity(), arrayListStaffOrder);
        List<DatabaseOrder> dbOrders = null;
        dbOrders = DatabaseOrder.listAll(DatabaseOrder.class);
        DbOrderssize = dbOrders.size();
        if (dbOrders != null) {
            for (int i = 0; i < DbOrderssize; i++) {
                if (dbOrders.get(i).state.name.equals("After ordering")&&!dbOrders.get(i).done) {
                    Foods tempFood = new Foods(dbOrders.get(i).item.name, dbOrders.get(i).item.getId(), dbOrders.get(i).item.description, dbOrders.get(i).item.price, dbOrders.get(i).item.itemImage.imageStream, dbOrders.get(i).item.stock);
                    Orders tempOrder = new Orders( new java.sql.Date(Calendar.getInstance().getTimeInMillis()), 0,dbOrders.get(i).done,tempFood,dbOrders.get(i).fnumber,dbOrders.get(i).getId());
                    adapter.add(tempOrder);
                }
            }
        }

    }
}
