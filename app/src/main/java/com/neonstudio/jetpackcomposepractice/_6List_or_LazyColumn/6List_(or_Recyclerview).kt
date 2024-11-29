package com.neonstudio.jetpackcomposepractice._6List_or_LazyColumn


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class List : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

//                    TextFieldFunctionState(
//                        modifier = Modifier.padding(innerPadding)
//                    )

                    PreviewItem()
                }
            }
        }
    }
}

//
//@Composable
//fun List(modifier: Modifier = Modifier) {
//
//
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun GreetingPreview() {
//    JetPackComposePracticeTheme {
//
//        List()
//    }
//}