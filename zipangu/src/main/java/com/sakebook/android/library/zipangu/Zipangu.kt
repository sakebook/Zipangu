package com.sakebook.android.library.zipangu

import android.content.Context
import android.util.Log
import org.json.JSONArray

/**
 * Created by sakemotoshinya on 16/02/20.
 */

object Zipangu {

    private val TAG = "Zipangu"
    private var mutablePrefectures: MutableList<Prefecture> = arrayListOf()
    private val prefectures: List<Prefecture> by lazy { mutablePrefectures }
    private var dummyPrefecture: Prefecture = Prefecture(0, "県外", "県外", Segment.None)

    /**
     * Initialize with custom dummy prefecture.
     * @param context
     * @param defaultPrefecture default prefecture
     * */
    @JvmStatic fun beginning(context: Context, defaultPrefecture: Prefecture) {
        dummyPrefecture = defaultPrefecture
        beginning(context)
    }

    /**
     * Initialize.
     * @param context
     * */
    @JvmStatic fun beginning(context: Context) {
        if (mutablePrefectures.size != 0) {
            Log.i(TAG, "Already beginning")
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
                        Segment.North.name -> Segment.North
                        Segment.East.name -> Segment.East
                        Segment.West.name -> Segment.West
                        Segment.Okinawa.name -> Segment.Okinawa
                        else -> throw Throwable()
                    }
            ))
        }
    }

    /**
     * Get Prefecture with code
     * @param code
     * @return Prefecture
     * */
    @JvmStatic fun code(code: Int): Prefecture {
        return prefectures.filter { it.code == code }.firstOrNull()?: {
            Log.w(TAG, "code range is 1 to 47. current $code")
            dummyPrefecture
        }()
    }

    /**
     * Get Prefecture with name
     * @param name
     * @return Prefecture
     * */
    @JvmStatic fun name(name: String): Prefecture {
        return prefectures.filter { it.name == name }.firstOrNull()?: {
            Log.w(TAG, "$name is not exist.")
            dummyPrefecture
        }()
    }

    /**
     * Get Prefectures with Segment
     * @param segment
     * @return List<Prefecture>
     * */
    @JvmStatic fun segment(segment: Segment): List<Prefecture> {
        return prefectures.filter { it.segment == segment }
    }

    /**
     * Get Prefectures with Area
     * @param area
     * @return List<Prefecture>
     * */
    @JvmStatic fun area(area: Area): List<Prefecture> {
        return prefectures.filter { it.area == area.name }
    }

    /**
     * Get all Prefectures
     * @return List<Prefecture>
     * */
    @JvmStatic fun all(): List<Prefecture> {
        return prefectures
    }

}