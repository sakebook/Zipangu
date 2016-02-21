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

    @JvmStatic fun begining(context: Context) {
        val jsonStr = ResourceAccess.getResource(context)
        val jsonArray = JSONArray(jsonStr)
        for (i in 0..jsonArray.length() - 1) {
            val obj = jsonArray.getJSONObject(i)
            mutablePrefectures.add(Prefecture(obj.getInt("stateCode"), obj.getString("name")))
        }
        Log.d("Zipangu", "json length: " + jsonArray.length())
        Log.d("Zipangu", "list length: " + mutablePrefectures.size)
    }
    @JvmStatic fun with(stateCode: Int): Prefecture {
        Log.d("Zipangu", "with: " + prefectures.size);
        return prefectures.filter { it.stateCode == stateCode }.first()
    }

}


//class Zipangu(context: Context) {
//
////    val prefectures: List<Prefecture> by Delegates.let { foo() }// by Delegates.notNull()
////    @Inject lateinit val prefectures: List<Prefecture>// by Delegates.let { foo() }// by Delegates.notNull()
//    val prefectures: List<Prefecture> by lazy { copy() }// by Delegates.let { foo() }// by Delegates.notNull()
//    var firstPrefectures: List<Prefecture> by Delegates.notNull()
//
//    init {
//
//        val jsonStr = ResourceAccess.getResource(context)
//        val jsonArray = JSONArray(jsonStr)
//        for (i in 0..jsonArray.length()) {
//            val obj = jsonArray.getJSONObject(i)
//            firstPrefectures.apply { Prefecture(obj.getInt("stateCode"), obj.getString("name")) }
//        }
//        Log.d("Zipangu", "json length: " + jsonArray.length())
//    }
//
//    fun copy(): List<Prefecture> {
//        return firstPrefectures
//    }
//
//    companion object {
//        @JvmStatic fun begining(context: Context): Zipangu = Zipangu(context)
//
//        @JvmStatic fun with(stateCode: Int) {
//        }
//
//        fun gg() {
//
//        }
//
//    }
//
//}