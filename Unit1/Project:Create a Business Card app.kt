package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(210,231,212,255)
                ) {
                    ComposeArticle("João Victor R.", "Android Developer")
                }
            }
        }
    }
}

@Composable
fun ComposeArticle(title: String, text2: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.android_logo)

    Column(
        modifier = modifier
            .padding(bottom = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .background(Color(7, 48, 66, 255))
                .height(95.dp)

            )

        Text(
            text = title,
            fontSize = 35.sp,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 6.dp)

        )
        Text(
            text = text2,
            fontSize = 18.sp,
            color = Color(0xFF3ddc84)

        )

    }

    Column(
        modifier = modifier
            .padding(bottom = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom

    ) {
        Row(
            modifier = modifier
                .padding(end = 12.dp)

        ){
            Icon(
                Icons.Rounded.Phone, contentDescription = "Localized description", tint = Color(0xFF3ddc84),
                modifier = modifier
                    .padding(bottom = 15.dp,end = 16.dp)

            )

            Text(text = "+55 (12) 99782-0374")

        }

        Row(

        ){
            Icon(
                Icons.Rounded.Email, contentDescription = "Localized description", tint = Color(0xFF3ddc84),
                modifier = modifier
                    .padding(bottom = 15.dp,end = 16.dp)

            )

            Text(text = "joaorodriguesprado17")

        }

        Row(
            modifier = modifier
                .padding(end = 40.dp)

        ){
            Icon(
                Icons.Rounded.Place, contentDescription = "Localized description", tint = Color(0xFF3ddc84),
                modifier = modifier
                    .padding(bottom = 15.dp,end = 16.dp)

            )

            Text(text = "São Paulo, Brasil")

        }


    }

}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    BusinessCardAppTheme {
//        Greeting("Android")
//    }
//}
