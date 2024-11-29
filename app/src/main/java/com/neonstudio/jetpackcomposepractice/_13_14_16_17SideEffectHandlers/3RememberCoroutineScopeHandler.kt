package com.neonstudio.jetpackcomposepractice._13_14_16_17SideEffectHandlers

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.tooling.preview.Preview
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class RememberCoroutineScopeHandler : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                CoroutineScopeComposable()
            }
        }
    }
}





@Composable
fun CoroutineScopeComposable() {
    val counter = remember { mutableStateOf(0) }
    var scope = rememberCoroutineScope()
    var text = "Counter is running ${counter.value}"
    if (counter.value == 10) {
        text = "Counter stopped"
        Column {
            Text(text = text)
            Button(onClick = {
                scope.launch {
                    Log.d("CoroutineScopeComposable", "Started...")
                    try {
                        for (i in 1..10) {
                            counter.value++
                            delay(1000)
                        }
                    } catch (e: Exception) {
                        Log.d("CoroutineScopeComposable", "Exception- ${e.message.toString()}")
                    }
                }
            }) {
                Text(text = "Start")
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {

        CoroutineScopeComposable()
    }
}