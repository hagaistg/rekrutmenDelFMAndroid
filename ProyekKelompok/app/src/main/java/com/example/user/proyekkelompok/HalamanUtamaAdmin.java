package com.example.user.proyekkelompok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.user.proyekkelompok.FirebaseSyarat.Syarat;
import com.example.user.proyekkelompok.program.ProdukList;

public class HalamanUtamaAdmin extends AppCompatActivity {
    LinearLayout b1;
    LinearLayout b2;
    LinearLayout b3;
    LinearLayout b4;
    LinearLayout b5;
    LinearLayout b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama_admin);
        b1 = findViewById(R.id.profil);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ia = new Intent(HalamanUtamaAdmin.this,Profil.class);
                startActivity(ia);
            }
        });
        b2 = findViewById(R.id.berita);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ia = new Intent(HalamanUtamaAdmin.this, Berita.class);
                startActivity(ia);
            }
        });
        b3 = findViewById(R.id.syarat);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ia = new Intent(HalamanUtamaAdmin.this, Syarat.class);
                startActivity(ia);
            }
        });
        b4 = findViewById(R.id.form);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ia = new Intent(HalamanUtamaAdmin.this, DaftarKaryawan.class);
                startActivity(ia);
            }
        });
        b5 = findViewById(R.id.program);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ia = new Intent(HalamanUtamaAdmin.this, ProdukList.class);
                startActivity(ia);
            }
        });
        b6 = findViewById(R.id.akun);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ia = new Intent(HalamanUtamaAdmin.this, AkunUser.class);
                startActivity(ia);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id) {

            case R.id.tambah:
                Intent intent3 = new Intent(HalamanUtamaAdmin.this, Splashscreen.class);
                startActivity(intent3);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
