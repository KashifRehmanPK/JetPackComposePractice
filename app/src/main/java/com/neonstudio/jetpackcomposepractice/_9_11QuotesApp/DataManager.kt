package com.neonstudio.jetpackcomposepractice._9_11QuotesApp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import java.util.Arrays

object DataManager {

    var data = emptyArray<ModelClassItem>()
    var currentQuote: ModelClassItem? = null
    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFiles(context: Context) {

        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<ModelClassItem>::class.java)
        isDataLoaded.value = true

    }

    fun switchPages(quote: ModelClassItem? ) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote= quote
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LISTING
        }
    }


}