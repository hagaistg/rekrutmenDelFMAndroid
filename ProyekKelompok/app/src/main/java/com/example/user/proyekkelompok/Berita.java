package com.example.user.proyekkelompok;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.proyekkelompok.FirebaseBerita.CreateBerita;
import com.example.user.proyekkelompok.FirebaseBerita.ReadBerita;
import com.example.user.proyekkelompok.FirebaseSyarat.CreateSyarat;
import com.example.user.proyekkelompok.FirebaseSyarat.ReadSyarat;
import com.example.user.proyekkelompok.FirebaseSyarat.Syarat;

public class Berita extends AppCompatActivity {

    private Button btCreateDB;
    private Button btViewDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud2);

        btCreateDB = (Button) findViewById(R.id.bt_createdata);
        btViewDB = (Button) findViewById(R.id.bt_viewdata);

        btCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(CreateBerita.getActIntent(Berita.this));
            }
        });

        btViewDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ReadBerita.getActIntent(Berita.this));
            }
        });
    }
}
