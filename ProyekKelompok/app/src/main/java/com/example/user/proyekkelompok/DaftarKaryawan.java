package com.example.user.proyekkelompok;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.proyekkelompok.API.ApiService;
import com.example.user.proyekkelompok.Adapter.ListArrayAdapter;
import com.example.user.proyekkelompok.Gambar.ListGambar;
import com.example.user.proyekkelompok.Model.ModelData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DaftarKaryawan extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ArrayList<ModelData> datakaryawan = new ArrayList<ModelData>();
    ListView listview;
    ListArrayAdapter adapter;

    LinearLayout layout_loading;
    TextView text_load;
    ImageView icon_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_karyawan);

        layout_loading = (LinearLayout) findViewById(R.id.layout_loading);

        text_load = (TextView) findViewById(R.id.text_load);
        icon_load = (ImageView) findViewById(R.id.icon_load);

        listview = (ListView) findViewById(R.id.listMhsMhs);
        listview.setOnItemClickListener(DaftarKaryawan.this);
        listview.setDividerHeight(0);
//        setup();

        FloatingActionButton btnAdd = (FloatingActionButton) findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goAdd = new Intent(DaftarKaryawan.this, ListGambar.class);
                startActivity(goAdd);
            }
        });

    }

    public void setup() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MainActivity.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        Call<List<ModelData>> call = service.getSemuaKar();
        call.enqueue(new Callback<List<ModelData>>() {
            @Override
            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {

                // tambahkan
                datakaryawan.clear();

                if (response.isSuccessful()) {
                    int jumlah = response.body().size();

                    for (int i = 0; i < jumlah; i++) {

                        ModelData data = new ModelData(
                                response.body().get(i).getIdKar(),
                                response.body().get(i).getNamalengkap(),
                                response.body().get(i).getEmail_kar(),
                                response.body().get(i).getUmur_kar(),
                                response.body().get(i).getTgllahir_kar(),
                                response.body().get(i).getAlamat_kar(),
                                response.body().get(i).getNotlp_kar(),
                                response.body().get(i).getJeniskelamin_kar(),
                                response.body().get(i).getPendidikan_kar(),
                                response.body().get(i).getPengalaman_kar(),
                                response.body().get(i).getPosisi_kar(),
                                response.body().get(i).getMotivasi_kar());



                        datakaryawan.add(data);
                        Log.d("RESPON", "onResponse: " + response.body().get(i).getIdKar());

                    }
                    listview.setVisibility(View.VISIBLE);
                    adapter = new ListArrayAdapter(DaftarKaryawan.this, R.layout.row_karyawan, datakaryawan);
                    listview.setAdapter(adapter);

                    if (adapter.getCount() < 1 ) {
                        layout_loading.setVisibility(View.VISIBLE);
                        String error = "Daftar Karyawan Kosong";
                        text_load.setText(error);
                        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_data_kosong);
                        icon_load.setImageBitmap(icon);
                    } else {
                        layout_loading.setVisibility(View.GONE);
                    }
                } else {
                    String error = "Error Retrive Data from Server !!!";
                    text_load.setText(error);
                    Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network);
                    icon_load.setImageBitmap(icon);

                }

            }

            @Override
            public void onFailure(Call<List<ModelData>> call, Throwable t) {
                String error = "Error Retrive Data from Server wwaau!!!\n" + t.getMessage();
                text_load.setText(error);
                Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_network);
                icon_load.setImageBitmap(icon);
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView ids = (TextView) view.findViewById(R.id.listID1);
        Intent intent = new Intent(DaftarKaryawan.this, DetailKaryawan.class);
        intent.putExtra(ModelData.id_karyawan, ids.getText().toString());
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            adapter.clear();
            setup();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        datakaryawan.clear();
        adapter = new ListArrayAdapter(DaftarKaryawan.this, R.layout.row_karyawan, datakaryawan);
//        adapter.clear();
        listview.setAdapter(adapter);

        Toast.makeText(this, "wow spasi", Toast.LENGTH_SHORT).show();
        setup();
    }
}
