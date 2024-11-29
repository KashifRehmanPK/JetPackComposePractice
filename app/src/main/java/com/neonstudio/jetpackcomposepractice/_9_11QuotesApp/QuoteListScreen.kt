package com.neonstudio.jetpackcomposepractice._9_11QuotesApp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.util.Arrays


@Composable
fun QuoteListScreen(data: Array<ModelClassItem>, onClick: (quote: ModelClassItem)-> Unit) {
    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp,8.dp)
                .fillMaxWidth(1f)
        )
        QuoteList(data = data, onClick)
    }
}