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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class LaunchedEffect : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Counter(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun Counter(modifier: Modifier = Modifier) {

    var count = remember { mutableStateOf(0) }
    var key = count.value % 3 == 0

    LaunchedEffect(key1 = key) {
        Log.d("m", "Counter count: ${count.value}")
    }


    Button(onClick = { count.value++ }) {
        Text("Increment count")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {

        Counter()
    }
}