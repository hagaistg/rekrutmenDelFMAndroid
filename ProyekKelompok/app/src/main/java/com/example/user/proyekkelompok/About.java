package com.example.user.proyekkelompok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class About extends AppCompatActivity implements View.OnClickListener{
    LinearLayout pria;
    LinearLayout wanita;
    LinearLayout anak;
    LinearLayout pasangan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        pria = findViewById(R.id.pria);
        pria.setOnClickListener(this);
        wanita = findViewById(R.id.wanita);
        wanita.setOnClickListener(this);
        anak = findViewById(R.id.anak);
        anak.setOnClickListener(this);
        pasangan = findViewById(R.id.pasangan);
        pasangan.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pria:
                Intent moveIntent = new Intent(About.this, Sondang.class);
                startActivity(moveIntent);
                break;
            case R.id.wanita:
                Intent moveIntent2 = new Intent(About.this, Wenny.class);
                startActivity(moveIntent2);
                break;
            case R.id.anak:
                Intent moveIntent3 = new Intent(About.this, Amri.class);
                startActivity(moveIntent3);
                break;
            case R.id.pasangan:
                Intent moveIntent4 = new Intent(About.this, Hagai.class);
                startActivity(moveIntent4);
                break;
        }

    }

}