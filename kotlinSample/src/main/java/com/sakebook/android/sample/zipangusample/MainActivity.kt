package com.sakebook.android.sample.zipangusample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sakebook.android.library.zipangu.Area
import com.sakebook.android.library.zipangu.Segment
import com.sakebook.android.library.zipangu.Zipangu

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Zipangu.beginning(this)
        Zipangu.beginning(this)
        Log.d("kotlin", Zipangu.code(1).name)
        Log.d("kotlin", Zipangu.code(100).name) // return default prefecture
        Log.d("kotlin", Zipangu.name("北海道").toString())
        Log.d("kotlin", Zipangu.name("青森").toString()) // return default prefecture
        Log.d("kotlin", Zipangu.name("東京都").toString())
        Log.d("kotlin", Zipangu.segment(Segment.East).toString())
        Log.d("kotlin", Zipangu.area(Area.中部).toString())
    }
}
