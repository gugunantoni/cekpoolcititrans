package com.example.cekpool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class LokasiActivity extends Activity {
    Spinner kotaSpinner;
    Spinner kecamatanSpinner;
    Spinner kelurahanSpinner;
    String kota;
    String kecamatan;
    String kelurahan;

    public static String pool_value;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lokasi);

        // making spinner
        kotaSpinner = (Spinner) findViewById(R.id.kota_spinner);
        ArrayAdapter<CharSequence> kotaAdapter = ArrayAdapter
                .createFromResource(this, R.array.kota_array,
                        android.R.layout.simple_spinner_item);
        kotaAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kotaSpinner.setAdapter(kotaAdapter);

    // making spinner
        kecamatanSpinner = (Spinner) findViewById(R.id.kecamatan_spinner);
        ArrayAdapter<CharSequence> kecAdapter = ArrayAdapter
                .createFromResource(this, R.array.kecamatan_array,
                        android.R.layout.simple_spinner_item);
        kecAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kecamatanSpinner.setAdapter(kecAdapter);

        // making spinner
        kelurahanSpinner = (Spinner) findViewById(R.id.kelurahan_spinner);
        ArrayAdapter<CharSequence> kelAdapter = ArrayAdapter
                .createFromResource(this, R.array.kelurahan_array,
                        android.R.layout.simple_spinner_item);
        kelAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kelurahanSpinner.setAdapter(kelAdapter);


        Button closeButton = (Button) findViewById(R.id.cek);
        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                kota = kotaSpinner.getSelectedItem().toString();
                kecamatan = kecamatanSpinner.getSelectedItem().toString();
                kelurahan = kelurahanSpinner.getSelectedItem().toString();



                if (kota.equals("Jakarta Timur") && kecamatan.equals("Cakung (Jaktim)") && kelurahan.equals("Cakung Barat - (cakung)")) {
                    pool_value = "Kelapa Gading";
                }
                else if (kota.equals("Jakarta Timur") && kecamatan.equals("Ciracas (Jaktim)") && kelurahan.equals("Rambutan - (ciracas)")) {
                    pool_value ="Fatmawati";
                }
                else if (kota.equals("Jakarta Timur") && kecamatan.equals("Jatinegara (Jaktim)") && kelurahan.equals("Kampung Melayu - (jatinegara)")) {
                    pool_value ="SCBD";
                }
                else if (kota.equals("Jakarta Barat") && kecamatan.equals("Cengkareng (Jakbar)") && kelurahan.equals("Kapuk - (cengkareng)")) {
                    pool_value ="Bandara SHIA";
                }
                else if (kota.equals("Jakarta Barat") && kecamatan.equals("Grogol Pertamburan (Jakbar)") && kelurahan.equals("Grogol - (grogol pertambunan)")) {
                    pool_value ="Central Park";
                }
                else if (kota.equals("Jakarta Barat") && kecamatan.equals("Taman Sari (Jakbar)") && kelurahan.equals("Glodok - (taman sari)")) {
                    pool_value ="BSD";
                }
                else if (kota.equals("Pilih Kota") && kecamatan.equals("Pilih Kecamatan") && kelurahan.equals("Pilih Kelurahan")) {
                    pool_value ="Silahkan pilih : Kota, Kecamatan, Kelurahan terlebih dulu";
                }
                else {
                    pool_value = "Kota/kecamatan/kelurahan yang anda pilih tidak sesuai";
                }

                Intent a = new Intent(LokasiActivity.this, PoolActivity.class);
                a.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(a);

            }
        });



    }
}
