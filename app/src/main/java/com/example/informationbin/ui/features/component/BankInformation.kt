package com.example.informationbin.ui.features.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextDecoration
import com.example.informationbin.data.emptities.Bank
import com.example.informationbin.ui.theme.Green

@Composable
fun BankInformation(
    bank: Bank,
    onClickWeb: (url: String) -> Unit,
    onClickNumber: (number: String) -> Unit
) {
    Text(text = "Bank", style = MaterialTheme.typography.h4)

    Text(text = bank.name)
    Text(text = bank.city)
    TextWithAction(text = bank.url) {
        onClickWeb(bank.url)
    }
    TextWithAction(text = bank.phone) {
        onClickNumber(bank.phone)
    }
}