package com.example.joochahyana.orderup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentStaffFoods extends Fragment{
    Button Addbutton;


    AdapterStaffFoods adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<Foods> arrayListStaffFoods = new ArrayList<Foods>();
        adapter = new AdapterStaffFoods(getActivity(), arrayListStaffFoods);


  /*
        foodNumber = arrayListStaffFoods.size();
        for(int i=0; i<foodNumber; i++){
            adapter.add(arrayListStaffFoods.get(i));

        }
     */
       Foods food1 = new Foods("Food Name 1", "Description of food 1", "$10.00", R.drawable.pic01,0);
        adapter.add(food1);
        Foods food2 = new Foods("Food Name 2", "Description of food 2", "$20.00", R.drawable.pic02,0);
        adapter.add(food2);
        Foods food3 = new Foods("Food Name 3", "Description of food 3", "$30.00", R.drawable.pic03,0);
        adapter.add(food3);
        Foods food4 = new Foods("Food Name 4", "Description of food 4", "$40.00", R.drawable.pic04,0);
        adapter.add(food4);
       Foods food5 = new Foods("Food Name 5", "Description of food 5", "$50.00", R.drawable.pic05,0);
        adapter.add(food5);

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_staff_foods, container, false);
        Addbutton = (Button)rootView.findViewById(R.id.buttonAdd);

        Addbutton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public  void onClick(View view){
                Intent intent = new Intent(getActivity(),foodstaffActivity.class);
                startActivity(intent);

            }

        });

        return rootView;
    }

    @Override

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.listViewStaffFoods);
        listView.setAdapter(adapter);
    }
}
