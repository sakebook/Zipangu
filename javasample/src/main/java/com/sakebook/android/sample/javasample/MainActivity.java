package com.sakebook.android.sample.javasample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sakebook.android.library.zipangu.Zipangu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Zipangu.beginning(this);
        Zipangu.beginning(this);
        Log.d("java", Zipangu.with(1).getStateName());
        Log.d("java", Zipangu.with("青森県").getStateName());
    }
}
