package com.example.informationbin.ui.features.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.informationbin.data.emptities.Country

@Composable
fun CountryText(country: Country) {
    Text(text = "Country", style = MaterialTheme.typography.h4, fontWeight = FontWeight.Bold)
    TextWithTitle(title = "name", value = country.name)
    TextWithTitle(title = "currency", value = country.currency)
    Text(
        text = "(latitude: ${country.latitude}, longitude: ${country.longitude})",
        style = MaterialTheme.typography.caption
    )
}