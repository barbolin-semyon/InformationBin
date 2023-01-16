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
    SectionWithTitle(title = "Card Number") {

        TextWithTitle(title = "lenght", value = number.length.toString())
        TextWithTitle(title = "luhn", value = number.luhn.toStringYesOrNo())

    }
}