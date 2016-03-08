package com.sakebook.android.sample.javasample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sakebook.android.library.zipangu.Area;
import com.sakebook.android.library.zipangu.Prefecture;
import com.sakebook.android.library.zipangu.Segment;
import com.sakebook.android.library.zipangu.Zipangu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Zipangu.beginning(this, new Prefecture(0, "カスタム県", "カスタムエリア", Segment.None));
        Log.d("java", Zipangu.code(1).getName());
        Log.d("java", Zipangu.code(100).getName()); // return default prefecture
        Log.d("java", Zipangu.name("北海道").toString());
        Log.d("java", Zipangu.name("東京都").toString());
        Log.d("java", Zipangu.name("青森").toString()); // return default prefecture
        Log.d("java", Zipangu.segment(Segment.North).toString());
        Log.d("java", Zipangu.area(Area.中部).toString());
        Log.d("java", Zipangu.all().toString());
    }
}
