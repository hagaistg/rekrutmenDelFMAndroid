package com.example.user.proyekkelompok.Gambar;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.user.proyekkelompok.R;

import java.util.ArrayList;

public class ListGambar extends AppCompatActivity {

    GridView gridView;
    ArrayList<GambarModel> list;
    GambarAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new GambarAdapter(this, R.layout.list_items, list);
        gridView.setAdapter(adapter);

        // get all data from sqlite
        Cursor cursor = UploadGambar.sqLiteHelper.getData("SELECT * FROM gass");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);

            String area = cursor.getString(2);
            byte[] image = cursor.getBlob(3);

            list.add(new GambarModel(id, name,  area, image));
        }
        adapter.notifyDataSetChanged();
    }
}
