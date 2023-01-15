package com.example.informationbin.ui.features.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.informationbin.ui.theme.Green

@Composable
fun TextInGreenCircle(text: String) {
    Card(
        shape = CircleShape,
        backgroundColor = Green,
        modifier = Modifier.size(48.dp),
    ) {
        Text(
            text = text,
            color = Color.White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3
        )
    }
}