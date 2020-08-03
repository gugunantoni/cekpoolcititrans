package com.example.cekpool;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class PoolActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool);

        setTitle("POOL :");

        TextView pool = (TextView) findViewById(R.id.pool_value);

        String pool_value = LokasiActivity.pool_value;
        pool.setText(pool_value);

    }
}
