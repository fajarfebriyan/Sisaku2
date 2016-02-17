package com.example.muffinman.myapplication;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class konfirmasipembayaran2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasipembayaran2);

        ImageView konfirmasifinal = (ImageView)findViewById (R.id.logokonfirmasipembayaran);

        konfirmasifinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pagepembayaransukses = new Intent(getBaseContext(), pembayaransukses.class);
                startActivity(pagepembayaransukses);
            }
        });


    }
}
