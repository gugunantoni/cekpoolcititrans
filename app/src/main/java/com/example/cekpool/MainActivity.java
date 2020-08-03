package com.example.cekpool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    private DBManager dbManager;

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



    