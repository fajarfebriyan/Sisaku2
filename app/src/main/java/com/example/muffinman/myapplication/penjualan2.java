package com.example.muffinman.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class penjualan2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjualan2);

        Button jual = (Button)findViewById(R.id.tomboljual);

        jual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagejual = new Intent(getBaseContext(), penjualan3.class);
                startActivity(pagejual);
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
