package com.example.cekpool;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // name table
    public static final String TABLE_LOKASI = "LOKASI_POOL";

    // column table
    public static final String KOTA = "kota";
    public static final String KECAMATAN = "kecamatan";
    public static final String KELUARAHAN = "kelurahan";

    static final String DB_NAME = "cekPOOL.DB";

    static final int DB_VERSION = 1;

    // make query for table
    private static final String CREATE_TABLE_LOKASI = "create table " + TABLE_LOKASI + "(" +
            KOTA + " TEXT, " +
            KECAMATAN + " TEXT, " +
            KELUARAHAN + " TEXT " +
            ");";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LOKASI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOKASI);
        onCreate(db);
    }
}
