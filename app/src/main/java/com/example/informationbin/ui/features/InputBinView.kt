package com.example.informationbin.ui.features

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.informationbin.ui.navigation.InformationScreens
import com.example.informationbin.ui.theme.Gray
import com.example.informationbin.ui.theme.Green

@Composable
fun InputBinView(navHostController: NavHostController) {
    Column {
        Text(
            text = "Введите BIN",
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(top = 32.dp, start = 16.dp),
        )

        val bin = remember { mutableStateOf("") }

        TextField(
            value = bin.value,
            onValueChange = { bin.value = it },
            textStyle = MaterialTheme.typography.h4,
            label = {
                Text(
                    text = "Введите первые цифры карты",
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Gray
            )
        )

        Button(
            enabled = bin.value.length >= 6,
            onClick = {
                navHostController.navigate(InformationScreens.DetailBin.passBin(bin.value))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Посмотреть информацию")
        }
    }
}