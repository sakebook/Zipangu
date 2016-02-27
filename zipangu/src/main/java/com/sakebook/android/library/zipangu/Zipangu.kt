package com.sakebook.android.library.zipangu

import android.content.Context
import android.util.Log
import org.json.JSONArray

/**
 * Created by sakemotoshinya on 16/02/20.
 */

object Zipangu {

    var mutablePrefectures: MutableList<Prefecture> = arrayListOf()
    val prefectures: List<Prefecture> by lazy { mutablePrefectures }

    /**
     * Initialize.
     * */
    @JvmStatic fun beginning(context: Context) {
        if (mutablePrefectures.size != 0) {
            Log.d("Zipangu", "Already beginning")
            return
        }
        val jsonStr = ResourceAccess.getResource(context, "prefectures.json")
        val jsonArray = JSONArray(jsonStr)
        for (i in 0..jsonArray.length() - 1) {
            val obj = jsonArray.getJSONObject(i)
            mutablePrefectures.add(Prefecture(stateCode = obj.getInt("stateCode"), stateName = obj.getString("stateName"), kana = obj.getString("kana")))
        }
        Log.d("Zipangu", "json length: " + jsonArray.length())
        Log.d("Zipangu", "list length: " + mutablePrefectures.size)
    }

    /**
     * statecode return Prefecture
     * */
    @JvmStatic fun with(stateCode: Int): Prefecture {
        Log.d("Zipangu", "with: " + prefectures.size);
        return prefectures.filter { it.stateCode == stateCode }.first()
    }

    @JvmStatic fun with(stateName: String): Prefecture {
        Log.d("Zipangu", "with: " + prefectures.size);
        return prefectures.filter { it.stateName == stateName }.first()
    }

    @JvmStatic fun east(): List<Prefecture> {
        Log.d("Zipangu", "east: " + prefectures.size);
        return prefectures.filter { it.east == true }
    }

    @JvmStatic fun west(): List<Prefecture> {
        Log.d("Zipangu", "west: " + prefectures.size);
        return prefectures.filter { it.west == true }
    }


}