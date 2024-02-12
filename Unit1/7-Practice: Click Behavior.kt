package com.example.practice_click_behavior

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice_click_behavior.ui.theme.Practice_Click_BehaviorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practice_Click_BehaviorTheme {
                // A surface container using the 'background' color from the theme
                LemonApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonApp() {
    LemonImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))

}

@Composable
fun LemonImage(modifier: Modifier = Modifier) {
    var clicks by remember { mutableStateOf(1) }
    var clicksToSqueeze = (2..4).random()

    val imageResource = when(clicks){
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree

    }

    val textResource = when(clicks){
        2 -> stringResource(R.string.keep_tapping_the_lemon_to_squeeze_it)
        3 -> stringResource(R.string.tap_the_lemonade_to_drink_it)
        4 -> stringResource(R.string.tap_the_empty_glass_to_start_again)
        else -> stringResource(R.string.tap_the_lemon_tree_to_select_a_lemon)

    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            if(clicks == 2){
                clicksToSqueeze--
                if(clicksToSqueeze == 0){
                    clicks++
                }
            } else if(clicks == 4){
                clicks = 1
            } else{
                clicks++
            }
        }, shape = RoundedCornerShape(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(144, 238, 144)))

        {
            Image(painter = painterResource(id = imageResource), contentDescription = clicks.toString(),
                modifier = Modifier
                    .width(128.dp)
                    .height(160.dp)
                    .padding(24.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(textResource, fontSize = 18.sp)
    }
}
