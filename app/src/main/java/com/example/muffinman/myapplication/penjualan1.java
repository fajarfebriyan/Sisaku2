package com.example.muffinman.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class penjualan1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjualan1);

        Button jual = (Button)findViewById(R.id.tomboljual);

        jual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagejual = new Intent(getBaseContext(), penjualan3.class);
                startActivity(pagejual);
            }
        });
        ImageView tambahfoto = (ImageView)findViewById(R.id.tambahfoto);

        tambahfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagetambahfoto = new Intent(getBaseContext(), penjualan2.class);
                startActivity(pagetambahfoto);
            }
        });

        ImageView beranda = (ImageView)findViewById(R.id.berandatombol);

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pageberanda = new Intent(getBaseContext() ,utama.class);
                startActivity(pageberanda);
            }
        });
    }
}
