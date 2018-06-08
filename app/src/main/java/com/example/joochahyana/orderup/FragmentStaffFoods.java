package com.example.joochahyana.orderup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FragmentStaffFoods extends Fragment{
    FloatingActionButton addButton ,delButton;
    int i=0;
    AdapterStaffFoods adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Foods> arrayListStaffFoods = new ArrayList<Foods>();
        adapter = new AdapterStaffFoods(getActivity(), arrayListStaffFoods);


         /*
        foodNumber = arrayListSffFoods.size();
        for(int i=0; i<foodNumber; i++){
            adapter.add(arrayListStaffFoods.get(i));

        }*/

         // jo
        List<DatabaseItems> dbItems = DatabaseItems.listAll(DatabaseItems.class);

        for(int i=0; i<dbItems.size(); i++){
            if (dbItems.get(i).display == true) {
                Foods tempFood = new Foods(dbItems.get(i).name, dbItems.get(i).getId(), dbItems.get(i).description, dbItems.get(i).price, dbItems.get(i).itemImage.imageStream);
                adapter.add(tempFood);
            }
        }

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_staff_foods, container, false);
        addButton = (FloatingActionButton)rootView.findViewById(R.id.buttonAdd);

        addButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public  void onClick(View view){
                Intent intent = new Intent(getActivity(),foodstaffActivity.class);
                startActivity(intent);

            }

        });



        /*
        delButton = (Button)rootView.findViewById(R.id.buttonDel);

        delButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public  void onClick(View view){


                DatabaseItems.deleteAll(DatabaseItems.class);
                DatabaseMenu.deleteAll(DatabaseMenu.class);
                DatabaseMenuItem.deleteAll(DatabaseMenuItem.class);
                DatabaseItemsImage.deleteAll(DatabaseItems.class);

            }

        });
        */

        return rootView;
    }

    @Override

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listViewStaffFoods);
        listView.setAdapter(adapter);
    }
}
