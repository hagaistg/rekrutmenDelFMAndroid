package com.example.user.proyekkelompok;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.proyekkelompok.API.ApiService;
import com.example.user.proyekkelompok.Gambar.UploadGambar;
import com.example.user.proyekkelompok.Model.ModelData;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddKaryawan extends AppCompatActivity {

    String ID_MAHASISWA;
    EditText et_id, et_nama, et_email,et_umur,et_tgllahir,et_alamat,et_notlp,et_jeniskelamin,
    et_pendidikan, et_pengalaman,et_posisi,et_motivasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_karyawan);

        ID_MAHASISWA = getIntent().getStringExtra(ModelData.id_karyawan);

//        et_id = (EditText) findViewById(R.id.edit_id);
        et_nama = (EditText) findViewById(R.id.edit_nama);
        et_email = (EditText) findViewById(R.id.edit_email);
        et_umur = (EditText) findViewById(R.id.edit_umur);
        et_tgllahir = (EditText) findViewById(R.id.edit_tgllahir);
        et_alamat = (EditText) findViewById(R.id.edit_alamat);
        et_notlp = (EditText) findViewById(R.id.edit_notlp);
        et_jeniskelamin = (EditText) findViewById(R.id.edit_jeniskelamin);
        et_pendidikan = (EditText) findViewById(R.id.edit_pendidikan);
        et_pengalaman = (EditText) findViewById(R.id.edit_pengalaman);
        et_posisi = (EditText) findViewById(R.id.edit_posisi);
        et_motivasi = (EditText) findViewById(R.id.edit_motivasi);


        final EditText edtNama = (EditText) findViewById(R.id.edit_nama);
        final EditText edtEmail = (EditText) findViewById(R.id.edit_email);
        final EditText edtUmur = (EditText) findViewById(R.id.edit_umur);
        final EditText edttgllahir = (EditText) findViewById(R.id.edit_tgllahir);

        final EditText edtalamat = (EditText) findViewById(R.id.edit_alamat);
        final EditText edtnotlp = (EditText) findViewById(R.id.edit_notlp);
        final EditText edtjeniskelamin = (EditText) findViewById(R.id.edit_jeniskelamin);
        final EditText edtpendidikan = (EditText) findViewById(R.id.edit_pendidikan);
        final EditText edtpengalaman = (EditText) findViewById(R.id.edit_pengalaman);
        final EditText edtposisi = (EditText) findViewById(R.id.edit_posisi);
        final EditText edtmotivasi = (EditText) findViewById(R.id.edit_motivasi);



        Button btnAdd = (Button) findViewById(R.id.simpan);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sNama = String.valueOf(edtNama.getText());
                String sEmail = String.valueOf(edtEmail.getText());
                String sUmur = String.valueOf(edtUmur.getText());
                String stgllahir = String.valueOf(edttgllahir.getText());
                String salamat = String.valueOf(edtalamat.getText());
                String snotlp = String.valueOf(edtnotlp.getText());
                String sjeniskelamin = String.valueOf(edtjeniskelamin.getText());
                String spendidikan = String.valueOf(edtpendidikan.getText());
                String spengalaman = String.valueOf(edtpengalaman.getText());
                String sposisi = String.valueOf(edtposisi.getText());
                String smotivasi = String.valueOf(edtmotivasi.getText());

                tambahData(sNama, sEmail,sUmur, stgllahir, salamat, snotlp, sjeniskelamin, spendidikan,spengalaman,sposisi,smotivasi);
                Intent goAddd = new Intent(AddKaryawan.this, UploadGambar.class);
                startActivity(goAddd);
            }
        });
    }


    public void tambahData(String namalengkap, String email,String umur,String tgllahir,String alamat, String notlp, String jeniskelamin, String pendidikan, String pengalaman, String posisi, String motivasi ) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(new StringConventer())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<ResponseBody> call = service.tambahData(namalengkap, email, umur,tgllahir,alamat,notlp,jeniskelamin,pendidikan,pengalaman,posisi,motivasi);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                BufferedReader reader = null;

                String respon = "";

                try {
                    reader = new BufferedReader(new InputStreamReader(response.body().byteStream()));
                    respon = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(AddKaryawan.this, respon, Toast.LENGTH_SHORT).show();
                finish();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(AddKaryawan.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
