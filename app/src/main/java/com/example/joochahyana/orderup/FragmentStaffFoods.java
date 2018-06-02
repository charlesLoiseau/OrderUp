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

public class FragmentStaffFoods extends Fragment{
    Button Addbutton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
 ;
    }
}
