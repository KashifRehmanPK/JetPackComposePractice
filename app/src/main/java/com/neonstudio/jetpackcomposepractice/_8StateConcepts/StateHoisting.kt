package com.neonstudio.jetpackcomposepractice._8StateConcepts


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class StateHoisting : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    var count = rememberSaveable { mutableStateOf(0)}

                    ButtonClicked2(
                        modifier = Modifier.padding(innerPadding),
                        count.value
                    ) { count.value++ }
                    Messagebar(Modifier,count.value)
                }
            }
        }
    }
}


@Composable
fun Messagebar(modifier: Modifier = Modifier, count: Int){

    Card(

        modifier = Modifier.padding(20.dp)

    )  {
        Row (
            Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,


            ){
            Image(
                imageVector = Icons.Outlined.CheckCircle,
                contentDescription = "",
                Modifier.padding(4.dp)
            )
            Text(text = "Message Sent so far $count", fontSize = 18.sp)
        }
    }
}

@Composable
fun ButtonClicked2(modifier: Modifier = Modifier, count: Int, increament: () -> Unit) {




    Column (
        verticalArrangement = Arrangement.Center,
       modifier = Modifier.padding(90.dp)
    ){

        Text(text = "Your have sent ${count} Notification", fontSize = 24.sp)
        Button(onClick = {
            increament()
        }) {
            Text(text = "Sent Notification", fontSize = 18.sp)
        }

    }

}




@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {

        //ButtonClicked2()
        // Messagebar()
    }
}