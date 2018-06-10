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


import com.orm.SugarRecord;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Joanna Chahyana on 8/5/2018.
 */

public class FragmentCustomerOrders extends Fragment {
    AdapterCustomerOrders adapter;
    ArrayList<Orders> arrayListCustomerOrder;
    int DbOrderssize ;
    Button orderbuttton;
    Double getPrice;
    TextView totalAmount;
    EditText TableNum;
    DatabaseReceipt currentReceipt;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPrice = new Double(0) ;
        makeAdapter();
        if(adapter!=null) {
            for (int i = 0; i < adapter.getCount(); i++) {
                getPrice += adapter.getItem(i).fnumber * adapter.getItem(i).foodInfo.price;
            }

        }

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        makeAdapter();
        View rootView = inflater.inflate(R.layout.fragment_customer_orders, container, false);
        totalAmount = (TextView) rootView.findViewById(R.id.textViewCustomerOrderTotalPrice);
        TableNum = (EditText) rootView.findViewById(R.id.textViewCustomerOrderTableNumber);
        totalAmount.setText(getPrice.toString());

            orderbuttton = rootView.findViewById(R.id.buttonCustomerOrder);

           orderbuttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TableNum.getText()!=null&&TableNum.getText().toString()!=null && Integer.parseInt(TableNum.getText().toString())>0)
                {
                    currentReceipt =  new DatabaseReceipt(
                            new java.sql.Date(Calendar.getInstance().getTimeInMillis()),
                            Integer.parseInt(TableNum.getText().toString()),getPrice,false);
                    currentReceipt.price = getPrice;
                    currentReceipt.save();

                    if(adapter!=null)
                    for(int i=0;i<adapter.getCount();i++){
                       DatabaseItems item =  SugarRecord.findById(DatabaseItems.class,adapter.getItem(i).foodInfo.id);


                        DatabaseReceiptItem receiptItem = new DatabaseReceiptItem(currentReceipt, null, item);

                        receiptItem.save();

                        DatabaseOrder order = SugarRecord.findById(DatabaseOrder.class,adapter.getItem(i).id );
                        order.tnumber = Integer.parseInt(TableNum.getText().toString());
                        DatabaseOrderState dbOrderState = DatabaseOrderState.find(DatabaseOrderState.class,"name = ? ", "After ordering").get(0);

                        order.state = dbOrderState;
                        order.save();


                    }

                }

            }});

        return rootView;
        }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ListView listView = (ListView) view.findViewById(R.id.listViewCustomerOrders);
        if (adapter != null) {
            listView.setAdapter(adapter);
        }
    }

    protected  void makeAdapter(){
        arrayListCustomerOrder = new ArrayList<Orders>();
        adapter = new AdapterCustomerOrders(getActivity(), arrayListCustomerOrder);
        List<DatabaseOrder> dbOrders = null;
        dbOrders = DatabaseOrder.listAll(DatabaseOrder.class);
        DbOrderssize = dbOrders.size();
        if (dbOrders != null) {
            for (int i = 0; i < DbOrderssize; i++) {
                if (dbOrders.get(i).state.name.equals("Ordering")) {
                    Foods tempFood = new Foods(dbOrders.get(i).item.name, dbOrders.get(i).item.getId(), dbOrders.get(i).item.description, dbOrders.get(i).item.price, dbOrders.get(i).item.itemImage.imageStream, dbOrders.get(i).item.stock);
                    Orders tempOrder = new Orders( new java.sql.Date(Calendar.getInstance().getTimeInMillis()), 0,dbOrders.get(i).done,tempFood,dbOrders.get(i).fnumber,dbOrders.get(i).getId());
                    adapter.add(tempOrder);
                }
            }
        }

    }

}
