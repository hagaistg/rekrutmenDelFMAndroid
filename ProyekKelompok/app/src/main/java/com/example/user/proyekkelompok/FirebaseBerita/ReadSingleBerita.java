package com.example.user.proyekkelompok.FirebaseBerita;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.proyekkelompok.FirebaseSyarat.ReadSingleSyarat;
import com.example.user.proyekkelompok.FirebaseSyarat.SyaratPen;
import com.example.user.proyekkelompok.R;

public class ReadSingleBerita extends AppCompatActivity {

    private Button btSubmit;
    private EditText etJudul;
    private EditText etTopik;
    private EditText etTanggal;
    private EditText etdeskripsi;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_berita);
        etJudul = (EditText) findViewById(R.id.et_judul);
        etTopik = (EditText) findViewById(R.id.et_topik);
        etTanggal = (EditText) findViewById(R.id.et_tanggal);
        etdeskripsi = (EditText) findViewById(R.id.et_desc);

        btSubmit = (Button) findViewById(R.id.bt_submit);

        etJudul.setEnabled(false);
        etTopik.setEnabled(false);
        etTanggal.setEnabled(false);
        etdeskripsi.setEnabled(false);

        btSubmit.setVisibility(View.GONE);

        BeritaPen barang = (BeritaPen) getIntent().getSerializableExtra("data");
        if(barang!=null){
            etJudul.setText(barang.getJudul());
            etTopik.setText(barang.getTopik());
            etTanggal.setText(barang.getTanggal());
            etdeskripsi.setText(barang.getDeskripsi());

        }
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, ReadSingleBerita.class);
    }
}