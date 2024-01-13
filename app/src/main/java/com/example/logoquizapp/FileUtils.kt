package com.example.logoquizapp

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.IOException

object FileUtils {

    fun getAssetJsonData(@ApplicationContext context: Context, fileName: String): String? {
        return try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

}