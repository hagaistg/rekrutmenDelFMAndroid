package com.example.user.proyekkelompok.FirebaseBerita;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.proyekkelompok.Berita;
import com.example.user.proyekkelompok.FirebaseSyarat.CreateSyarat;
import com.example.user.proyekkelompok.FirebaseSyarat.SyaratPen;
import com.example.user.proyekkelompok.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by User on 5/14/2019.
 */

public class CreateBerita  extends AppCompatActivity {

    // variable yang merefers ke Firebase Realtime Database
    private DatabaseReference database;

    // variable fields EditText dan Button
    private Button btSubmit;
    private EditText etJudul;
    private EditText etTopik;
    private EditText etTanggal;
    private EditText etdeskipsi;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_berita);

        // inisialisasi fields EditText dan Button
        etJudul = (EditText) findViewById(R.id.et_judul);
        etTopik = (EditText) findViewById(R.id.et_topik);
        etTanggal = (EditText) findViewById(R.id.et_tanggal);
        etdeskipsi = (EditText) findViewById(R.id.et_desc);
        btSubmit = (Button) findViewById(R.id.bt_submit);

        // mengambil referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference();

        final BeritaPen barang = (BeritaPen) getIntent().getSerializableExtra("data");

        if (barang != null) {
            etJudul.setText(barang.getJudul());
            etTopik.setText(barang.getTopik());
            etTanggal.setText(barang.getTanggal());
            etdeskipsi.setText(barang.getDeskripsi());

            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    barang.setJudul(etJudul.getText().toString());
                    barang.setTopik(etTopik.getText().toString());
                    barang.setTanggal(etTanggal.getText().toString());
                    barang.setDeskripsi(etdeskipsi.getText().toString());


                    updateBeritaPen(barang);
                }
            });
        } else {
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!isEmpty(etJudul.getText().toString()) && !isEmpty(etTopik.getText().toString()) && !isEmpty(etTanggal.getText().toString()) &&!isEmpty(etdeskipsi.getText().toString()))
                        submitBeritaPen(new BeritaPen(etJudul.getText().toString(),etTopik.getText().toString(),etTanggal.getText().toString(), etdeskipsi.getText().toString()));
                    else
                        Snackbar.make(findViewById(R.id.bt_submit), "Data Berita tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(
                            etJudul.getWindowToken(), 0);
                }
            });
        }
    }

    private boolean isEmpty(String s){
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }

    private void updateBeritaPen(BeritaPen barang) {
        /**
         * Baris kode yang digunakan untuk mengupdate data barang
         * yang sudah dimasukkan di Firebase Realtime Database
         */
        database.child("barang") //akses parent index, ibaratnya seperti nama tabel
                .child(barang.getKey()) //select barang berdasarkan key
                .setValue(barang) //set value barang yang baru
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        /**
                         * Baris kode yang akan dipanggil apabila proses update barang sukses
                         */
                        Toast.makeText(CreateBerita.this, "Data berhasil diupdatekan" , Toast.LENGTH_SHORT).show();
                        Snackbar.make(findViewById(R.id.bt_submit), "Data berhasil diupdatekan", Snackbar.LENGTH_LONG).setAction("Oke", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                finish();
                            }
                        }).show();
                    }
                });
    }

    private void submitBeritaPen(BeritaPen barang) {
        /**
         * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
         * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
         * ketika data berhasil ditambahkan
         */
        database.child("barang").push().setValue(barang).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etJudul.setText("");
                etTopik.setText("");
                etTanggal.setText("");
                etdeskipsi.setText("");
                Toast.makeText(CreateBerita.this, "Data berhasil ditambahkan" , Toast.LENGTH_SHORT).show();
                Snackbar.make(findViewById(R.id.bt_submit), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, CreateBerita.class);
    }
}

