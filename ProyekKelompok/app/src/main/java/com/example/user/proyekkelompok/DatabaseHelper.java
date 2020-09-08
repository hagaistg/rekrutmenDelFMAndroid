package com.example.user.proyekkelompok;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by User on 5/14/2019.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context)
    {
        super(context, "Login.db", null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(email text primary key, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    //inserting in database
    public boolean insert(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long ins = db.insert("user",null, contentValues);

        if(ins == -1) return false;
        else return true;
    }

    public Boolean chkemail (String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{email});

        if(cursor.getCount()>0) return false;
        else return true;
    }

    //checking the email and password
    public Boolean emailpassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=? and password=?", new String[]{email, password});
        if(cursor.getCount()>0) return true;
        else return false;
    }
    public ArrayList<Akun> getAllDataProfile() {
        ArrayList<Akun> profilList = new ArrayList<>();

        String selectQuery = "SELECT * FROM user";

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Akun profileModel = new Akun();

                profileModel.setEmail(cursor.getString(0));


                //profileModel.setJangkauan(cursor.getString(6));

                profilList.add(profileModel);

            } while (cursor.moveToNext());
        }
        return profilList;
    }

}
