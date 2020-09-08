package com.example.user.proyekkelompok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.proyekkelompok.API.ApiService;
import com.example.user.proyekkelompok.Model.ModelData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 5/13/2019.
 */


public class DetailKaryawan extends AppCompatActivity {
    String ID_MAHASISWA;
    TextView et_id, et_nama, et_email, et_umur, et_tgllahir, et_alamat, et_notlp, et_jeniskelamin,
            et_pendidikan, et_pengalaman, et_posisi, et_motivasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ID_MAHASISWA = getIntent().getStringExtra(ModelData.id_karyawan);

        et_id = findViewById(R.id.edit_id);
        et_nama = findViewById(R.id.edit_nama);
        et_email = findViewById(R.id.edit_email);
        et_umur = findViewById(R.id.edit_umur);
        et_tgllahir = findViewById(R.id.edit_tgllahir);
        et_alamat = findViewById(R.id.edit_alamat);
        et_notlp = findViewById(R.id.edit_notlp);
        et_jeniskelamin = findViewById(R.id.edit_jeniskelamin);
        et_pendidikan = findViewById(R.id.edit_pendidikan);
        et_pengalaman = findViewById(R.id.edit_pengalaman);
        et_posisi = findViewById(R.id.edit_posisi);
        et_motivasi = findViewById(R.id.edit_motivasi);
        bindData();

        Button btnDel = (Button) findViewById(R.id.hapus);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hapusData(ID_MAHASISWA);
            }
        });

        Button btnUbah = (Button) findViewById(R.id.ubah);
        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String sId = String.valueOf(et_id.getText());
//                String sNama = String.valueOf(et_nama.getText());
//                String sEmail = String.valueOf(et_email.getText());
//                String sUmur = String.valueOf(et_umur.getText());
//                String stgllahir = String.valueOf(et_tgllahir.getText());
//                String salamat = String.valueOf(et_alamat.getText());
//                String snotlp = String.valueOf(et_notlp.getText());
//                String sjeniskelamin = String.valueOf(et_jeniskelamin.getText());
//                String spendidikan = String.valueOf(et_pendidikan.getText());
//                String spengalaman = String.valueOf(et_pengalaman.getText());
//                String sposisi = String.valueOf(et_posisi.getText());
//                String smotivasi = String.valueOf(et_motivasi.getText());
//                editData(sNama, sEmail,sUmur, stgllahir, salamat, snotlp, sjeniskelamin, spendidikan,spengalaman,sposisi,smotivasi);
                Toast.makeText(DetailKaryawan.this, "Silakan Kirim Pengumuman Lewat Gmail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void bindData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<List<ModelData>> call = service.getSingleData(ID_MAHASISWA);
        call.enqueue(new Callback<List<ModelData>>() {
            @Override
            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {

                if (response.isSuccessful()) {

                    for (int i = 0; i < response.body().size(); i++) {
                        et_id.setText(response.body().get(i).getIdKar());
                        et_nama.setText(response.body().get(i).getNamalengkap());
                        et_email.setText(response.body().get(i).getEmail_kar());
                        et_umur.setText(response.body().get(i).getUmur_kar());
                        et_tgllahir.setText(response.body().get(i).getTgllahir_kar());
                        et_alamat.setText(response.body().get(i).getAlamat_kar());
                        et_notlp.setText(response.body().get(i).getNotlp_kar());
                        et_jeniskelamin.setText(response.body().get(i).getJeniskelamin_kar());
                        et_pendidikan.setText(response.body().get(i).getPendidikan_kar());
                        et_pengalaman.setText(response.body().get(i).getPengalaman_kar());
                        et_posisi.setText(response.body().get(i).getPosisi_kar());
                        et_motivasi.setText(response.body().get(i).getMotivasi_kar());
                    }

                }

            }

            @Override
            public void onFailure(Call<List<ModelData>> call, Throwable t) {

            }
        });
    }
//    public void editData(String namalengkap, String email,String umur,String tgllahir,String alamat, String notlp, String jeniskelamin, String pendidikan, String pengalaman, String posisi, String motivasi) {
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(MainActivity.ROOT_URL)
//                .addConverterFactory(new StringConventer())
//                .build();
//
//        ApiService service = retrofit.create(ApiService.class);
//
//        Call<ResponseBody> call = service.editData(namalengkap, email, umur,tgllahir,alamat,notlp,jeniskelamin,pendidikan,pengalaman,posisi,motivasi);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//                BufferedReader reader = null;
//                String respon = "";
//
//                try {
//                    reader = new BufferedReader(new InputStreamReader(response.body().byteStream()));
//                    respon = reader.readLine();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                Toast.makeText(DetailKaryawan.this, respon, Toast.LENGTH_SHORT).show();
//                finish();
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });

    public void hapusData(String id_kar) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(new StringConventer())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<ResponseBody> call = service.hapusData(id_kar);
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

                Toast.makeText(DetailKaryawan.this, respon, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
    }




