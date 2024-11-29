package com.neonstudio.jetpackcomposepractice._9_11QuotesApp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun QuoteList(data: Array<ModelClassItem>, onClick: (quote: ModelClassItem)-> Unit) {


    LazyColumn {
        items(data) { item ->
            QuotesListItems(quote = item,onClick)
        }
    }
}