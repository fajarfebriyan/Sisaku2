package com.example.muffinman.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class akunsaya extends AppCompatActivity implements View.OnClickListener {

    private ImageView akun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akunsaya);

        //init menubar bawah
        akun = (ImageView) findViewById(R.id.akuntombol);

        akun.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.akuntombol:
                break;

        }
    }
}
