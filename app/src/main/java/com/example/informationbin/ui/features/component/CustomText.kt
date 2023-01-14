package com.example.informationbin.ui.features.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.informationbin.data.emptities.NumberBin
import com.example.informationbin.ui.theme.Green

@Composable
fun TextInColumn(title: String, value: String) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(text = title)
        Text(text = value)
    }
}

@Composable
fun TextWithTitle(title: String, value: String) {
    Text(text = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("$title:")
        }
        append(value)
    })
}

@Composable
fun TextWithAction(text: String, action: () -> Unit) {
    Text(
        text = text,
        color = Green,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier.clickable { action() }
    )
}