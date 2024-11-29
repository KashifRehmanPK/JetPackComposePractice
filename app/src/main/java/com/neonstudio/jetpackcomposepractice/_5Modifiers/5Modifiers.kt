package com.neonstudio.jetpackcomposepractice._5Modifiers


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.neonstudio.jetpackcomposepractice.R
import com.neonstudio.jetpackcomposepractice._2State.TextFieldFunctionState
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class Modifiers : ComponentActivity() {
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
fun Modifiers111(modifier: Modifier) {

   Text(
       text ="Hello",
       color = Color.Black,
       modifier= modifier.clickable {  }
       .background(Color.Gray)
           .size(200.dp)
           .padding(36.dp)
           .border(4.dp, Color.Red)
           .clip(CircleShape)
           .background(Color.Yellow)
         //  .clickable {  }


   )

}



@Composable
fun CircularImage(modifier: Modifier) {

    Image(
        painter = painterResource(
            id = R.drawable.heart
        ),
            contentDescription = "",
            contentScale = ContentScale.Fit,

        modifier = Modifier.size(80.dp)
            .clip(CircleShape)
            .border(5.dp,Color.LightGray, CircleShape)
            //.shadow()
    )

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {
        //Modifiers111(Modifier)
        CircularImage(Modifier)
    }
}