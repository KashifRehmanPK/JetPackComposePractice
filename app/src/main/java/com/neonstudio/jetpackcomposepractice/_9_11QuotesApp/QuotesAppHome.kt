package com.neonstudio.jetpackcomposepractice._9_11QuotesApp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuotesApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
          //  kotlinx.coroutines.delay(10000)
            DataManager.loadAssetsFromFiles(applicationContext)
        }

        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                    App(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun App(modifier: Modifier = Modifier) {

    if (DataManager.isDataLoaded.value) {

        if(DataManager.currentPage.value==Pages.LISTING){
            QuoteListScreen(data = DataManager.data) {

                DataManager.switchPages(it)
            }
        }else{
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }

       // QuoteListScreen(data = DataManager.data) { }

    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {

            Text(
                text = "Loading",
                //        style = MaterialTheme.typography.h6
            )
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {

        App()
    }
}

enum class Pages{
    LISTING,
    DETAIL
}