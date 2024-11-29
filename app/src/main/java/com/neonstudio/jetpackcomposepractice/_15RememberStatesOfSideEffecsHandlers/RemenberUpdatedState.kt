package com.neonstudio.jetpackcomposepractice._15RememberStatesOfSideEffecsHandlers


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme
import kotlinx.coroutines.delay

class RemenberUpdatedState : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    App()
                    App2()
                }
            }
        }
    }
}


//1ST Example

@Composable
fun App() {

    var counter = remember { mutableStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        counter.value = 10
    }
    Counter(counter.value)
}


@Composable
fun Counter(value: Int) {
    val state = rememberUpdatedState(newValue = value)

    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.d("CHEEZYCODE", state.value.toString())
    }
    Text(text = value.toString())
}


//2nd Example

fun a() {
    Log.d("CHEEZYCODE", "I am A from App")
}

fun b() {
    Log.d("CHEEZYCODE", "I am В from App")
}

@Composable
fun App2() {
    var state  = remember { mutableStateOf(::a) }
    Button(onClick = { state.value = ::b }) {
        Text(text = "Click to change state")
    }
    LandingScreen(state.value)
}


@Composable
fun LandingScreen (onTimeout: () -> Unit) {
    val currentOnTimeout by rememberUpdatedState(onTimeout)
    LaunchedEffect( true) {
        delay( 5000)
        currentOnTimeout()
    }
}
