package com.example.informationbin.ui.features

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.informationbin.data.emptities.HistoryElement
import com.example.informationbin.ui.features.component.TextInGreenCircle
import com.example.informationbin.ui.navigation.InformationScreens
import com.example.informationbin.ui.theme.Green
import com.example.informationbin.viewModel.BinViewModel

@Composable
fun HistoryView(navHostController: NavHostController) {
    val viewModel: BinViewModel = viewModel()

    val history = viewModel.history.observeAsState()
    LaunchedEffect(key1 = Unit, block = {
        viewModel.getHistory()
    })

    LazyColumn {
        items(history.value!!) { history ->
            CardForHistory(
                historyElement = history,
                deleteCard = { viewModel.deleteHistory(history) },
                onClick = {
                    navHostController.navigate(InformationScreens.DetailBin.passBin(history.bin!!))
                }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CardForHistory(
    historyElement: HistoryElement,
    onClick: () -> Unit,
    deleteCard: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 8.dp)
            .combinedClickable(
                onClick = { onClick() },
                onLongClick = { deleteCard() }
            ),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            Modifier
                .fillMaxHeight()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextInGreenCircle(text = historyElement.uid.toString())

            Column(Modifier.padding(start = 16.dp)) {
                Text(text = historyElement.bin!!, style = MaterialTheme.typography.h4)
                Text(text = historyElement.date!!)
            }
        }
    }
}