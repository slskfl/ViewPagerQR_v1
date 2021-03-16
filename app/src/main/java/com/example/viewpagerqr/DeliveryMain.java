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
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DeliveryMain extends Fragment {

    public static ArrayList<String> myArrayList = new ArrayList<>();
    SQLiteDatabase sqlDB;
    Cursor cursor;

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
        Button btnQRCam=fragmentView.findViewById(R.id.btnQRCam);
        ListView dListView=fragmentView.findViewById(R.id.dListView);

        myArrayList = new ArrayList<>();
        final ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, myArrayList);
        dListView.setAdapter(myArrayAdapter);

        //리스트뷰 보여주기
        sqlDB=SQLiteDatabase.openDatabase("/data/data/com.example.qrscanner/databases/QRcodeDB",
                null, SQLiteDatabase.OPEN_READONLY);
        cursor = sqlDB.rawQuery("SELECT * FROM qrcodeTBL;", null);
        cursor.moveToFirst();
        myArrayAdapter.notifyDataSetChanged();

        do{
            String code = "코드 : "+cursor.getString(0);
            String address = "주소 : "+cursor.getString(8);
            String note = "비고 : "+cursor.getString(10);

            //Toast.makeText(DeliveryPage.this, ""+cursor.getPosition(), Toast.LENGTH_SHORT).show();
            myArrayList.add(code+"\n"+ address+"\n"+note+"\n");
            myArrayAdapter.notifyDataSetChanged();

        }while(cursor.moveToNext());
        cursor.close();
        sqlDB.close();
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