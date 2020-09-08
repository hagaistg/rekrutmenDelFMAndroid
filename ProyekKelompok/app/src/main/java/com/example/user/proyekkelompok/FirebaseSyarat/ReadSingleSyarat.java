package com.example.user.proyekkelompok.FirebaseSyarat;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.proyekkelompok.R;

public class ReadSingleSyarat extends AppCompatActivity {

    private Button btSubmit;
    private EditText etNama;
    private EditText etdeskripsi;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_syarat);
        etNama = (EditText) findViewById(R.id.et_namabarang);
        etdeskripsi = (EditText) findViewById(R.id.et_merkbarang);

        btSubmit = (Button) findViewById(R.id.bt_submit);

        etNama.setEnabled(false);
        etdeskripsi.setEnabled(false);

        btSubmit.setVisibility(View.GONE);

        SyaratPen barang = (SyaratPen) getIntent().getSerializableExtra("datasyarat");
        if(barang!=null){
            etNama.setText(barang.getNama());
            etdeskripsi.setText(barang.getDeskripsi());

        }
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, ReadSingleSyarat.class);
    }
}
