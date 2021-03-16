package com.example.viewpagerqr;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeMain extends Fragment {
    public HomeMain() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView=inflater.inflate(R.layout.fragment_home_main, container, false);
        Button btnQRCam=fragmentView.findViewById(R.id.btnQRCam);
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