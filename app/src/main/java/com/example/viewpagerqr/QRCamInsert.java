package com.example.viewpagerqr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONObject;

public class QRCamInsert extends AppCompatActivity {
    Button buttonScan, btnDBInsert;
    TextView tvCode, tvSname, tvSpost, tvSaddress, tvStel, tvSnote,
            tvRname, tvRpost, tvRaddress, tvRtel, tvRnote;
    private IntentIntegrator qrScan;
    JSONObject obj;
    IntentResult result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_r_cam_insert);

    }
}