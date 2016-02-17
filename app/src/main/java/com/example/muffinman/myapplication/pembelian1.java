package com.example.muffinman.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class pembelian1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembelian1);

        ImageView beranda = (ImageView)findViewById(R.id.berandatombol);

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pageberanda = new Intent(getBaseContext(), utama.class);
                startActivity(pageberanda);
            }
        });

        ImageView statuspemesanan = (ImageView)findViewById(R.id.statuspemesanan);

        statuspemesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagestatuspemesanan = new Intent(getBaseContext(), pembelian2statuspemesanan.class);
                startActivity(pagestatuspemesanan);
            }
        });

        ImageView konfirmasipembayaran = (ImageView)findViewById(R.id.konfirmasipembayaran);

        konfirmasipembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagekonfirmasipembayaran = new Intent(getBaseContext(), pembelian3konfirmasipembayaran.class);
                startActivity(pagekonfirmasipembayaran);
            }
        });

        ImageView konfirmasipenerimaan = (ImageView)findViewById(R.id.konfirmasipenerimaan);

        konfirmasipenerimaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagekonfirmasipenerimaan = new Intent(getBaseContext(), pembelian4konfirmasipenerimaan.class);
                startActivity(pagekonfirmasipenerimaan);
            }
        });

        ImageView daftartransaksi = (ImageView)findViewById(R.id.daftartransaksi);

        daftartransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagedaftartransaksi = new Intent(getBaseContext(), pembelian5daftartransaksi.class);
                startActivity(pagedaftartransaksi);
            }
        });
    }
}
