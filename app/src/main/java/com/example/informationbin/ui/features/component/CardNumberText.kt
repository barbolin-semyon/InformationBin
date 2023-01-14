package com.example.informationbin.ui.features.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.informationbin.data.emptities.NumberBin
import com.example.informationbin.util.toStringYesOrNo

@Composable
fun CardNumberText(number: NumberBin) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Card Number", style = MaterialTheme.typography.h4)
        Row(
            modifier = Modifier
                .padding(top = 4.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextInColumn(title = "lenght", value = number.length.toString())
            TextInColumn(title = "luhn", value = number.luhn.toStringYesOrNo())
        }
    }
}