package com.example.informationbin.ui.features.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.informationbin.data.emptities.Country

@Composable
fun CountryText(
    country: Country,
    onClickCoordinates: (latitude: Int, longitude: Int) -> Unit = { it, it1 -> }
) {
    SectionWithTitle(title = "Country") {
        TextWithTitle(title = "name", value = country.name)
        TextWithTitle(title = "currency", value = country.currency)
        TextWithAction(
            action =  { onClickCoordinates(country.latitude, country.longitude) },
            text = "(latitude: ${country.latitude}, longitude: ${country.longitude})",
        )

    }
}