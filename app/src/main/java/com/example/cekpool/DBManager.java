package com.example.cekpool;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


import static com.example.cekpool.DatabaseHelper.TABLE_LOKASI;

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insertJsonArray(String  kota, String kecamatan, String kelurahan) {
        ContentValues contentValuesMatkul = new ContentValues();
        contentValuesMatkul.put(DatabaseHelper.KOTA, kota);
        contentValuesMatkul.put(DatabaseHelper.KECAMATAN, kecamatan);
        contentValuesMatkul.put(DatabaseHelper.KELUARAHAN, kelurahan);
        database.insert(TABLE_LOKASI, null, contentValuesMatkul);
    }


    public Cursor getLokasi(String kota, SQLiteDatabase sqLiteDatabase) {
        String[] columns = new String[] { DatabaseHelper.KECAMATAN, DatabaseHelper.KELUARAHAN};
        String selection = DatabaseHelper.KOTA + " LIKE ?";
        String[] selection_args = {kota};
        Cursor cursor = sqLiteDatabase.query(TABLE_LOKASI, columns, selection, selection_args, null,null,null);

        return cursor;
    }


}
