package com.neonstudio.jetpackcomposepractice._2State

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class State : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    TextFieldFunctionState(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun TextFieldFunctionState(modifier: Modifier = Modifier) {

    val state = remember { mutableStateOf("")}

    TextField(
        // value = "Txt Value",
        value = state.value,
        onValueChange = {
            //Log.d("Testing9292",it)
            state.value = it
        },
        label = { Text(text = "Enter Message") },
        //placeholder = {}
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {

        TextFieldFunctionState()
    }
}