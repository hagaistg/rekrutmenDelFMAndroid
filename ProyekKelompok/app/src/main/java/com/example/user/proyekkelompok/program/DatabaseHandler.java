package com.example.user.proyekkelompok.program;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "horasma";

    public static final String TABLE_CONTACTS = "contacts";

    private static DatabaseHandler mInstance;
    private static SQLiteDatabase sqLiteDatabase;

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_HARGA = "harga";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_INTEREST = "interest";
    public static final String KEY_COURSE = "course";


    public static DatabaseHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseHandler(context);
        }
        return mInstance;
    }

    public DatabaseHandler(Context context) {
        super(context, "uts.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " VARCHAR(50),"
                + KEY_HARGA + " VARCHAR(30), "
                + KEY_EMAIL + " VARCHAR(30), "
                + KEY_GENDER + " VARCHAR(6), "
                + KEY_INTEREST + " VARCHAR(30), "
                + KEY_COURSE + " VARCHAR(50) "
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }

    public long insertQuery(ContentValues values, String TABLE) {

        long returnVal = 0;

        try {
            sqLiteDatabase = getDatabaseMode("write");

            returnVal = sqLiteDatabase.insert(TABLE, null, values);
        } catch (Exception e) {
            returnVal = 0;
            e.printStackTrace();
        }
        return returnVal;
    }

    public int updateQuery(String TABLE, ContentValues values, String whereClause, String[] whereArgs) {
        int returnVal = 0;

        try {
            sqLiteDatabase = getDatabaseMode("write");
            // Inserting Row
            returnVal = sqLiteDatabase.update(TABLE, values, whereClause, whereArgs);

        } catch (Exception e) {
            returnVal = 0;
            e.printStackTrace();
        }
        return returnVal;
    }

    public Cursor getDataByCustomQuery(String QUERY, String[] args) {

        Cursor cursor = null;
        try {

            sqLiteDatabase = getDatabaseMode("read");
            cursor = sqLiteDatabase.rawQuery(QUERY, args);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursor;
    }

    //Delete all data of table
    public void truncateTable(String TABLE) {
        try {
            sqLiteDatabase = getDatabaseMode("write");
            sqLiteDatabase.execSQL("DELETE FROM " + TABLE); //delete all rows in a table
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int deleteRecord(String table, String whereClause, String[] whereArgs) {

        int returnVal = 0;
        try {
            sqLiteDatabase = getDatabaseMode("write");
            returnVal = sqLiteDatabase.delete(table, whereClause, whereArgs);
        } catch (Exception e) {
            e.printStackTrace();
            returnVal = 0;
        }

        return returnVal;
    }


    public SQLiteDatabase getDatabaseMode(String mode) {
        if ((sqLiteDatabase == null) || (!sqLiteDatabase.isOpen())) {
            if (mode.equalsIgnoreCase("read"))
                sqLiteDatabase = this.getReadableDatabase();
            else
                sqLiteDatabase = this.getWritableDatabase();
        }

        return sqLiteDatabase;
    }

    @Override
    public void close() {
        super.close();
        if (sqLiteDatabase != null) {
            sqLiteDatabase.close();
            sqLiteDatabase = null;
        }
    }
}


