package com.example.viewpagerqr;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DeliveryMain extends Fragment {

    public static ArrayList<String> myArrayList = new ArrayList<>();
    public ArrayAdapter<String>  myArrayAdapter=new ArrayAdapter<>(getActivity(),
        android.R.layout.simple_list_item_1, myArrayList);
    Button btnQRCam;
    public DeliveryMain() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView=inflater.inflate(R.layout.fragment_delivery_main, container, false);
        btnQRCam=fragmentView.findViewById(R.id.btnQRCam);
        ListView dListView=fragmentView.findViewById(R.id.dListView);

        dListView.setAdapter(myArrayAdapter);

        btnQRCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), QRCamInsert.class);
                startActivity(intent);
            }
        });
        return fragmentView;
    }

}