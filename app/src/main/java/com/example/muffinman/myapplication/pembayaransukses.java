package com.example.muffinman.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class pembayaransukses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaransukses);

        ImageView beranda = (ImageView)findViewById(R.id.logopembayaransukses);

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pageberanda = new Intent(getBaseContext(), utama.class);
                startActivity(pageberanda);
            }
        });
    }
}
