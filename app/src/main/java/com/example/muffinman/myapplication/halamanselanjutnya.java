package com.example.muffinman.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class halamanselanjutnya extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halamanselanjutnya);

        Button keapaya = (Button) findViewById(R.id.button1);

        keapaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page3 = new Intent(getBaseContext() ,apaya.class);
                startActivity(page3);
            }
        });


    }
}
