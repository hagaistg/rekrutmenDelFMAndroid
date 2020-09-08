package com.example.user.proyekkelompok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class AkunUser extends AppCompatActivity {

    ImageView imageView;
    private RecyclerView rvCategory;
    private ArrayList<Akun> list = new ArrayList<>();

    Akun profile = new Akun();
    DatabaseHelper handler = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akun_user);

        rvCategory = findViewById(R.id.listdaftar);
        rvCategory.setHasFixedSize(true);
        list.addAll(DaftarData.getListData(handler, profile));
        showRecyclerList();



    }
    public void showSelectedProduk(Akun produk) {

        Intent nextIntent = new Intent(AkunUser.this, HalamanUtamaAdmin.class);
        nextIntent.putExtra("name", produk.getEmail());

        startActivity(nextIntent);
    }



        //Toast.makeText(this, "Kamu memilih " + produk.getName(), Toast.LENGTH_SHORT).show();


    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListAkunAdapter listProdukAdapter = new ListAkunAdapter(this);
        listProdukAdapter.setListProduk(list);
        rvCategory.setAdapter(listProdukAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedProduk(list.get(position));
            }
        });
    }

}
