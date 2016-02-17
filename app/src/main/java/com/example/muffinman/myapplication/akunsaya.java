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

        ImageView beranda = (ImageView)findViewById(R.id.berandatombol);

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pageberanda = new Intent(getBaseContext() ,utama.class);
                startActivity(pageberanda);
            }
        });

        ImageView pembelian = (ImageView)findViewById(R.id.pembelian);

        pembelian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagepembelian = new Intent(getBaseContext() ,pembelian1.class);
                startActivity(pagepembelian);
            }
        });

        final ImageView penjualan = (ImageView)findViewById(R.id.penjualan);

        penjualan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagepenjualan = new Intent(getBaseContext() ,penjualan3.class);
                startActivity(pagepenjualan);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.akuntombol:
                break;

        }
    }
}
