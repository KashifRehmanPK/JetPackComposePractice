package com.neonstudio.jetpackcomposepractice._6List_or_LazyColumn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.neonstudio.jetpackcomposepractice.ui.theme.JetPackComposePracticeTheme

@Preview(heightDp = 500)
@Composable
fun PreviewItem() {

    //Simple List View
//        Column (modifier = Modifier.verticalScroll(rememberScrollState())){
//            getDataList().map { item ->
//                Preview(img = item.img, title = item.title, subtitle = item.subtitle)
//            }
//        }

    //LazyColumn
    LazyColumn(content = {
            items(getDataList()) { item ->
                Preview(img = item.img, title = item.title, subtitle = item.subtitle)
            }
        })
}

@Composable
fun Preview(img: Int, title: String, subtitle: String) {
    JetPackComposePracticeTheme {

        Card(
            modifier = Modifier.padding(8.dp)

        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = "",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                        .weight(.2f)
                )

                ItemDiscription(title, subtitle,Modifier.weight(.8f))
            }

        }
    }
}

@Composable
fun ItemDiscription(title: String, subtitle: String, modifier: Modifier) {
    Column(modifier = Modifier) {
        Text(
            text = title,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            //style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = subtitle,
            fontSize = 12.sp,
            fontWeight = FontWeight.Thin,
            //    style = MaterialTheme.typography.bodySmall
        )
    }
}