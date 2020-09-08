package com.example.user.proyekkelompok.program;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.user.proyekkelompok.Program;
import com.example.user.proyekkelompok.R;

import java.util.ArrayList;
import java.util.List;

public class ProdukList extends AppCompatActivity {
    List<Model> modalList;
    RecyclerView mRecyclerView;
    ProgressBar progressBar;
    DatabaseHandler dbHandler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk_list);

        initUIControls();
        new GetDataAsync().execute();
    }

    private void initUIControls() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        mRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    class GetDataAsync extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {

            viewAllRecords();
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.INVISIBLE);
            if (null != modalList && modalList.size() > 0) {
                mRecyclerView.setHasFixedSize(true);
                mRecyclerView.setAdapter(new MyRecyclerAdapter(ProdukList.this, modalList));
                mRecyclerView.setLayoutManager(new LinearLayoutManager(ProdukList.this));
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            } else {
                Toast.makeText(ProdukList.this, "Tidak Ada Data Ditemukan", Toast.LENGTH_SHORT).show();
            }
        }
    }
    //View all records from DB
    public void viewAllRecords() {
        try {
            modalList = new ArrayList<>();
            modalList.clear();
            dbHandler = DatabaseHandler.getInstance(this);
            String sql = "SELECT * FROM " + DatabaseHandler.TABLE_CONTACTS;
            Cursor cursor = dbHandler.getDataByCustomQuery(sql, null);
            if (null != cursor && cursor.getCount() > 0) {
                cursor.moveToFirst();
                for (int i = 0; i < cursor.getCount(); i++) {
                    String rowId = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_ID));
                    String name = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_NAME));
                    String harga = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_HARGA));
                    String email = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_EMAIL));
                    String gender = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_GENDER));
                    String interest = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_INTEREST));
                    String course = cursor.getString(cursor.getColumnIndex(DatabaseHandler.KEY_COURSE));

                    modalList.add(new Model(rowId, name, harga, email, gender, interest, course));
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id) {

            case R.id.tambah:
                 Intent intent3 = new Intent(ProdukList.this, Program.class);
                startActivity(intent3);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    public void shareon(View v){
        switch (v.getId()){
            case R.id.share:
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
        }
    }
}
