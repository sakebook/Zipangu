package com.sakebook.android.sample.javasample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sakebook.android.library.zipangu.Zipangu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Zipangu.begining(this);
        Zipangu.with(1);
    }
}
