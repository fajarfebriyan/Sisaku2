package com.example.muffinman.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class pembelian3konfirmasipembayaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembelian3konfirmasipembayaran);

        ImageView beranda = (ImageView)findViewById(R.id.berandatombol);

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pageberanda = new Intent(getBaseContext(), utama.class);
                startActivity(pageberanda);
            }
        });

        Button konfirmasi = (Button)findViewById(R.id.tombolkonfirmasi);

        konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagekonfirmasi = new Intent(getBaseContext(), konfirmasipembayaran2.class);
                startActivity(pagekonfirmasi);
            }
        });

    }
}
