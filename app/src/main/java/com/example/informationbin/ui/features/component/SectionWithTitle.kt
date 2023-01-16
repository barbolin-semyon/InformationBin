package com.example.informationbin.ui.features.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.informationbin.ui.theme.Green

@Composable
fun SectionWithTitle(
    title: String,
    modifier: Modifier = Modifier.padding(
        start = 16.dp,
        top = 32.dp
    ),
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        Text(text = title, style = MaterialTheme
            .typography.h4)
        content()
    }
}