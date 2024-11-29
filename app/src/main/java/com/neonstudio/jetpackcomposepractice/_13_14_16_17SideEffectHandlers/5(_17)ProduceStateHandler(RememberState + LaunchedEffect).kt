package com.neonstudio.jetpackcomposepractice._13_14_16_17SideEffectHandlers


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.O
import androidx.compose.ui.tooling.preview.Preview
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme
import kotlinx.coroutines.delay

class ProduceStateHandler : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    RememberAndLanuchedEffect()
                    ProduceStateEffectHandler()
                }
            }
        }
    }
}


//1st Remember + LanuchedEffect
@Composable
fun RememberAndLanuchedEffect() {
    val state = remember { mutableStateOf(0) }


    LaunchedEffect (key1 = Unit) {
        for (i in 1..10) {
            delay(1000)
            state.value++
        }
    }
    Text(
    text = state.value.toString(),
    )
}

//2nd ProduceStateEffectHandler
@Composable
fun ProduceStateEffectHandler() {
    val state = produceState(initialValue = 0) {
        for (i in 1..10) {
            delay(1000) // Suspends for 1 second
            value += 1  // Update the state value
        }
    }

    Text(
        text = state.value.toString()
    )
}
