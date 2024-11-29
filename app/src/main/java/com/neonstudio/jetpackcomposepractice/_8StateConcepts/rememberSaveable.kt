package com.neonstudio.jetpackcomposepractice._8StateConcepts


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class StateDetail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    ButtonClicked(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun ButtonClicked(modifier: Modifier = Modifier) {

    var count = rememberSaveable { mutableStateOf(0)}

    Column (verticalArrangement = Arrangement.Center){
        Text(text = "Your have sent ${count.value} Notification", fontSize = 24.sp)
        Button(onClick = {
            count.value++
            Log.d("ButtonClicked","Button Clicked")
        }) {
            Text(text = "Sent Notification", fontSize = 18.sp)
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {

        ButtonClicked()
    }
}