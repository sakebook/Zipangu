package com.sakebook.android.library.zipangu

/**
 * Created by sakemotoshinya on 16/02/20.
 */
data class Prefecture(
        val stateCode: Int,
        val stateName: String,
        val kana: String,
        var areaName: String = "",
        var areaCode: Int = 0,
        var east: Boolean = true,
        var west: Boolean = true
)