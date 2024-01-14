package com.example.logoquizapp

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.lang.reflect.Type

object GsonUtils {

    private val gson by lazy { Gson() }

    fun <T> getObjectFromString(responseString: String, classType: Type): T? {
        return try {
            gson.fromJson(responseString, classType)
        } catch (e: JsonSyntaxException) {
            e.printStackTrace()
            null
        }
    }

}