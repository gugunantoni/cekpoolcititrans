package com.example.cekpool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    private DBManager dbManager;
    private Spinner spinner;
    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // open database
        dbManager = new DBManager(this);
        dbManager.open();


        // parsing jsone file
        String json = null;
        try {
            InputStream is = getAssets().open("dataset.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i<jsonArray.length();i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String kota = obj.getString("kota");
                String kecamatan = obj.getString("kecamatan");
                String kelurahan = obj.getString("kelurahan");
                dbManager.insertJsonArray(kota, kecamatan, kelurahan);
            }
        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
        }





        // close database
        //dbHelper.close();



        // making spinner
        spinner = (Spinner) findViewById(R.id.kota_spinner);
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.kota_array,
                        android.R.layout.simple_spinner_item);
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(staticAdapter);
        String kota = spinner.getSelectedItem().toString();


        Button closeButton = (Button) findViewById(R.id.button);
        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent a = new Intent(MainActivity.this, LokasiActivity.class);
                a.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(a);
            }
        });


    }




}



    