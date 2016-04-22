package com.example.muffinman.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//todo fix keyboard jangan langsung muncul tiba2. harusnya pilih email, baru munculin keyboard.

public class daftarakun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarakun);

        Button daftar =(Button) findViewById(R.id.tomboldaftarakun);

       daftar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent pageakunsaya = new Intent(getBaseContext(), akunsaya.class);
               startActivity(pageakunsaya);
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
