package com.example.informationbin.ui.features.component

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun DeleteAlertDialog(onClick: () -> Unit) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Вы действительно хотите удалить?") },
            buttons = {
                Button(onClick = { onClick() }) {
                    Text("Да")
                }

                Button(onClick = { openDialog.value = false }) {
                    Text("Нет")
                }
            }
        )
    }
}