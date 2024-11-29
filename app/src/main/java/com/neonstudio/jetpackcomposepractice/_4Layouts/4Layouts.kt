package com.neonstudio.jetpackcomposepractice._4Layouts


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neonstudio.jetpackcomposepractice.R
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class Layouts : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Layouts(
                        modifier = Modifier.padding(innerPadding)
                    )

                    Column {
                        ListViewItem(R.drawable.heart, "Kashif", "Developer",Modifier)
                        ListViewItem(R.drawable.heart, "Tayyab", "Developer",Modifier)
                        ListViewItem(R.drawable.heart, "Awais", "Developer",Modifier)
                        ListViewItem(R.drawable.heart, "Someone", "Developer",Modifier)
                    }
                }
            }
        }
    }
}


//Basic---------------------------------------------------------------------
@Composable
fun Layouts(modifier: Modifier = Modifier) {


//    Column (
//
//        //VERTICAL Allignment-------------------------
//        //verticalArrangement = Arrangement.SpaceBetween,
//        verticalArrangement = Arrangement.SpaceEvenly,
//        //verticalArrangement = Arrangement.Center,
//
//        //Horizontal Allignment-------------------------
//        horizontalAlignment = Alignment.CenterHorizontally,
//
//
//        modifier = modifier.fillMaxSize()
//    ){
//        Text(text = "A", fontSize = 64.sp)
//        Text(text = "B", fontSize = 64.sp)
//    }

    //------------------------------------------------

//    Row (
//        horizontalArrangement = Arrangement.SpaceEvenly,
//        verticalAlignment = Alignment.CenterVertically
//    ){
//        Text(text = "A", fontSize = 64.sp)
//        Text(text = "B", fontSize = 64.sp)
//    }


    //-------------------------------------------------

   /* Box(
        //contentAlignment = Alignment.Center,
        contentAlignment = Alignment.BottomEnd,

        modifier = modifier.fillMaxSize()
    ){

        Image(painter = painterResource(id = R.drawable.heart), contentDescription = "")
        Image(painter = painterResource(id = R.drawable.arrow4), contentDescription = "")
    }*/


}



//Exercise---------------------------------------------------------------------
@Composable
fun ListViewItem(imgeId: Int, name: String, occupation: String, modifier: Modifier) {

    Row (modifier.padding(10.dp)){
        Image(
            painter = painterResource(id = imgeId),
            contentDescription = "",
            Modifier.size(50.dp)
        )
        Column {
            Text(
                text = name,
                fontWeight = FontWeight.Bold)
            Text(
                text = occupation,
                fontWeight = FontWeight.Thin,
                fontSize = 12.sp
            )

        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {

        //Basics-------
        Layouts()

        //Exercise-----
        Column {
            ListViewItem(R.drawable.heart, "Kashif", "Developer",Modifier)
            ListViewItem(R.drawable.heart, "Tayyab", "Developer",Modifier)
            ListViewItem(R.drawable.heart, "Awais", "Developer",Modifier)
            ListViewItem(R.drawable.heart, "Someone", "Developer",Modifier)
        }
    }
}