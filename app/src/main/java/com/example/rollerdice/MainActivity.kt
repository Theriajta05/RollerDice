package com.example.rollerdice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.rollerdice.ui.theme.RollerDiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RollerDiceTheme {
                DiceRollerApp()
            }
        }
    }
}

@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var result2 by remember { mutableStateOf(1) } // Nuevo resultado para el segundo dado

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageResource: Painter = painterResource(id = when (result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        })
        Image(
            painter = imageResource,
            contentDescription = result.toString()
        )
        Button(onClick = { result = (1..6).random() }) {
            Text(text = stringResource(id = R.string.roll))
        }

        // Segundo dado
        val imageResource2: Painter = painterResource(id = when (result2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        })
        Image(
            painter = imageResource2,
            contentDescription = result2.toString()
        )
        Button(onClick = { result2 = (1..6).random() }) { // Nuevo botón para el segundo dado
            Text(text = stringResource(id = R.string.roll))
        }
    }
}


@Preview
@Composable
fun DiceRollerAppPreview() {
    DiceRollerApp()
}

