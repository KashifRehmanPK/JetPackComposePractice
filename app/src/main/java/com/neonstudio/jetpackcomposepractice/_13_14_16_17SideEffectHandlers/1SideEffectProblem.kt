package com.neonstudio.jetpackcomposepractice._13_14_16_17SideEffectHandlers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class StateEffectProblem : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                    HasSideEffect()
                    ListComposable()
                }
            }
        }
    }
}

//1st Example
var Counter = 1
@Composable
fun HasSideEffect() {
      Counter++
    Text(text = "Text count ${Counter}")
}


//2nd Example
@Composable
fun ListComposable() {
    val categoryState = remember { mutableStateOf(emptyList<String>()) }

    LaunchedEffect(key1 = Unit) {
        categoryState.value = fetchCategories()
    }

    LazyColumn {
        items(categoryState.value) { item ->
            Text(text = item)
        }
    }
}

fun fetchCategories(): List<String> {
    //assuming network call
    return listOf("One", "Two", "Three")
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {
        //HasSideEffect()
        //ListComposable()
    }
}