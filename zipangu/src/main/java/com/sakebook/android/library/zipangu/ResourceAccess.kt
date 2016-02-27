package com.sakebook.android.library.zipangu

import android.content.Context
/**
 * Created by sakemotoshinya on 16/02/20.
 */

class ResourceAccess {

    companion object {
        fun getResource(context: Context, name: String): String {
            return context.assets.open(name).reader(charset=Charsets.UTF_8).use{it.readText()}
        }
    }

}