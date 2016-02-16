package com.example.muffinman.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class utama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        ImageView akunsaya = (ImageView)findViewById(R.id.akuntombol);

        akunsaya.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View view) {
                if(locals.read(utama.this,getString(R.string.email)).isEmpty()) {
                    intent = new Intent(getBaseContext(), login.class);
                }
                else {
                    intent = new Intent(getBaseContext(), com.example.muffinman.myapplication.akunsaya.class);
                }
                startActivity(intent);
            }
        });
    }
}
