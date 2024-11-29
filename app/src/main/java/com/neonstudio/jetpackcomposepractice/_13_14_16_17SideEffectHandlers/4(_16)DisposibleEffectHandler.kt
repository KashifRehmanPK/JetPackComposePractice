package com.neonstudio.jetpackcomposepractice._13_14_16_17SideEffectHandlers


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class DisposibleEffectHandler : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    DisposibleEffectHandler(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun DisposibleEffectHandler(modifier: Modifier = Modifier) {

    var state = remember { mutableStateOf(false)}

    DisposableEffect(key1 = state.value) {
        Log.d("cheezycode","Disposible Effect Started")

        onDispose {
            Log.d("cheezycode","Cleaning up side Effects")
        }
    }

    Button(onClick = {state.value = !state.value}) {
        Text(text = "Change State")
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {

        DisposibleEffectHandler()
    }
}