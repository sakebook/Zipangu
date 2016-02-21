package com.sakebook.android.sample.zipangusample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sakebook.android.library.zipangu.Zipangu

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Zipangu.begining(this)




    }
}
