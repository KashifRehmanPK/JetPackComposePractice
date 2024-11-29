package com.neonstudio.jetpackcomposepractice.TayyabTask_Practice


import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Input
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.InsertLink
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.neonstudio.jetpackcomposepractice.R
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

class PracticeDesign : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                    // Using a Column within the Scaffold to hold the toolbar and card
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                        // Include inner padding for proper layout

                    ) {
                        CustomToolbar("Help And Support") {
                            println("Back button clicked")
                        }

                        Box(
                            modifier = Modifier
                                .align(Alignment.TopCenter) // Align CardView at the top center
                                .padding(top = 70.dp) // Adjust 'top' padding to control position over the toolbar
                                .zIndex(1f) // Higher zIndex to ensure CardView appears above toolbar
                        ) {

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding) // Include inner padding for proper layout

                            ) {
                                CardView()

                                Spacer(modifier = Modifier.height(0.dp))

                                Links()

                            }

                        }

                    }
                }
            }
        }
    }
}


@Composable
fun CustomToolbar(title: String, onBackClick: () -> Unit) {

    Image(
        painter = painterResource(id = R.drawable.background2), // Replace with your image resource
        contentDescription = "Toolbar Background",
        contentScale = ContentScale.FillWidth, // Ensures the image stretches to fill both axes



        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()


    )




    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(200.dp)
            .padding(top = 0.dp, start = 0.dp),
        contentAlignment = Alignment.TopCenter
    ) {


        Image(
            painter = painterResource(id = R.drawable.background), // Replace with your image resource
            contentDescription = "Toolbar Background",
            contentScale = ContentScale.Crop, // Ensures the image crops to fit the Box's aspect ratio
            modifier = Modifier.matchParentSize()
        )



        Text(
            text = title,
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 65.dp)
        )




        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 20.dp, top = 50.dp)
                .size(50.dp) // Set the size of the circle
                .background(
                    Color(0xFF3461FF),
                    shape = CircleShape
                )


        ) {
            // Back Button
            IconButton(
                onClick = { onBackClick() },
                modifier = Modifier
                    .align(Alignment.Center)

            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.Center)
                    )
            }
        }

    }


}


@Composable
fun CardView(modifier: Modifier = Modifier) {

    Card(
        modifier = Modifier
            .padding(26.dp)
            .fillMaxWidth(),

        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF03386F) // Set your desired tint color here
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Contact Us",
                fontSize = 20.sp,
                color = Color(0xFFFFFFFF),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = "Write message here",
                onValueChange = {
                    Log.d("Testing9292", it)
                },
                modifier = Modifier
                    .fillMaxWidth() // Make TextField fill the width
                    .border(
                        BorderStroke(2.dp, Color.Gray),
                        shape = RoundedCornerShape(12.dp)
                    ) // Add rounded border
                    .height(150.dp)
                    .background(Color(0xFF03386F)),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    // Set background color for focused and unfocused states
                    focusedIndicatorColor = Color.Transparent, // Transparent indicator when focused
                    unfocusedIndicatorColor = Color.Transparent, // Transparent indicator when not focused
                    focusedContainerColor = Color(0xFF03386F), // Background color when focused
                    unfocusedContainerColor = Color(0xFF03386F) // Background color when not focused
                )
            )


            Spacer(modifier = Modifier.height(15.dp))


            Button(

                onClick = { },
                shape = RoundedCornerShape(4.dp),

                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(.9f)


            ) {

                Text(
                    text = "Send Message",
                    color = Color(0xFFFFFFFF)
                )


            }
        }
    }

}

@Composable
fun Links(modifier: Modifier = Modifier) {

    Column {

        Text(
            text = "Contact on our social media platform",
            fontSize = 16.sp,
            color = Color(0xFFFFFFFF),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(start = 10.dp)
        )

        Row {
            IconButton(
                onClick = {},
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon33),
                    contentDescription = "Back",
                )
            }

            IconButton(
                onClick = {},
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon11),
                    contentDescription = "Back",
                )
            }

            IconButton(
                onClick = {},
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon22),
                    contentDescription = "Back",
                )
            }
        }

    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun GreetingPreview() {
    JetPackComposePracticeTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


            // Using a Column within the Scaffold to hold the toolbar and card
            Box(
                modifier = Modifier
                    .fillMaxSize()
                // Include inner padding for proper layout

            ) {
                CustomToolbar("Help And Support") {
                    println("Back button clicked")
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.TopCenter) // Align CardView at the top center
                        .padding(top = 70.dp) // Adjust 'top' padding to control position over the toolbar
                        .zIndex(1f) // Higher zIndex to ensure CardView appears above toolbar
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding) // Include inner padding for proper layout

                    ) {
                        CardView()

                        Spacer(modifier = Modifier.height(0.dp))

                        Links()

                    }

                }

            }
        }
    }
}