package com.neonstudio.jetpackcomposepractice._13_14_16_17SideEffectHandlers


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme
import kotlinx.coroutines.delay

class DerivedStateOfHandler : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Derived()
                }
            }
        }
    }
}


@Composable
fun Derived() {
    val table0f = remember { mutableStateOf(5) }

    val index = produceState(initialValue = 1) {

        repeat(9) {
            delay(1000)
            value += 1
        }
    }


    val message = remember {
        derivedStateOf {
            "${table0f.value} * $ {index. value} = = ${table0f.value * index.value}"
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f)
    )

    {
        Text(text = message.value)
    }
}

@Preview
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {

        Derived()
    }
}