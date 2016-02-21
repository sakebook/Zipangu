package com.sakebook.android.library.zipangu

import android.content.Context
/**
 * Created by sakemotoshinya on 16/02/20.
 */

class ResourceAccess {

    companion object {
        fun getResource(context: Context): String {
            return context.assets.open("prefectures.json").reader(charset=Charsets.UTF_8).use{it.readText()}
        }
    }

}