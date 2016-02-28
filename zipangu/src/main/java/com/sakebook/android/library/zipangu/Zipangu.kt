package com.sakebook.android.library.zipangu

import android.content.Context
import android.util.Log
import org.json.JSONArray

/**
 * Created by sakemotoshinya on 16/02/20.
 */

object Zipangu {

    private var mutablePrefectures: MutableList<Prefecture> = arrayListOf()
    private val prefectures: List<Prefecture> by lazy { mutablePrefectures }

    /**
     * Initialize.
     * */
    @JvmStatic fun beginning(context: Context) {
        if (mutablePrefectures.size != 0) {
            Log.d("Zipangu", "Already beginning")
            return
        }
        val prefecturesJsonStr = ResourceAccess.getResource(context, "prefectures.json")
        val jsonArray = JSONArray(prefecturesJsonStr)

        for (i in 0..jsonArray.length() - 1) {
            val obj = jsonArray.getJSONObject(i)
            mutablePrefectures.add(Prefecture(
                    code = obj.getInt("code"),
                    name = obj.getString("name"),
                    area = obj.getString("area"),
                    segment = when (obj.optString("segment")) {
                        Segment.East.name -> Segment.East
                        Segment.West.name -> Segment.West
                        else -> throw Throwable()
                    }
            ))
        }
    }

    /**
     * statecode return Prefecture
     * */
    @JvmStatic fun with(code: Int): Prefecture {
        Log.d("Zipangu", "with: " + prefectures.size);
        return prefectures.filter { it.code == code }.first()
    }

    @JvmStatic fun with(name: String): Prefecture {
        Log.d("Zipangu", "with: " + prefectures.size);
        return prefectures.filter { it.name == name }.first()
    }

    @JvmStatic fun east(): List<Prefecture> {
        Log.d("Zipangu", "east: " + prefectures.size);
        return prefectures.filter { it.segment == Segment.East }
    }

    @JvmStatic fun west(): List<Prefecture> {
        Log.d("Zipangu", "west: " + prefectures.size);
        return prefectures.filter { it.segment == Segment.West }
    }

    @JvmStatic fun area(area: Area): List<Prefecture> {
        Log.d("Zipangu", "area: " + area.name);
        return prefectures.filter { it.area == area.name }
    }
}