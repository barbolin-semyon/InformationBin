package com.example.informationbin.ui.features.component.infoBin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.informationbin.data.emptities.BinDetail
import com.example.informationbin.ui.features.component.SectionWithTitle
import com.example.informationbin.ui.features.component.TextWithTitle
import com.example.informationbin.util.toStringYesOrNo

@Composable
fun BaseInfo(binDetail: BinDetail) {
    SectionWithTitle("Information") {
        TextWithTitle(title = "Scheme", value = binDetail.scheme)
        TextWithTitle(title = "brand", value = binDetail.brand)
        TextWithTitle(title = "type", value = binDetail.type)
        TextWithTitle(title = "prepaid", value = binDetail.prepaid.toStringYesOrNo())
    }
}