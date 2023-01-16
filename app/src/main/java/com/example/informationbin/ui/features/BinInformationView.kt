package com.example.informationbin.ui.features

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.informationbin.data.emptities.BinDetail
import com.example.informationbin.ui.features.component.BankInformation
import com.example.informationbin.ui.features.component.CardNumberText
import com.example.informationbin.ui.features.component.CountryText
import com.example.informationbin.ui.features.component.TextWithTitle
import com.example.informationbin.ui.theme.Green
import com.example.informationbin.util.toStringYesOrNo
import com.example.informationbin.viewModel.BinViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun BinInformationView(navHostController: NavHostController, bin: String) {
    val viewModel: BinViewModel = viewModel()
    val information = viewModel.detailInformation.observeAsState()

    LaunchedEffect(key1 = Unit, block = {
        viewModel.getBinInformation(bin)
    })
    Column(Modifier.background(Green), horizontalAlignment = Alignment.End) {

        Text(
            text = "BIN: $bin",
            style = MaterialTheme.typography.h3,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )

        val process = viewModel.isLoading.observeAsState()

        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(topStart = 64.dp),
            elevation = 32.dp
        ) {
            if (process.value == true) {
                CircularProgressIndicator()
            } else {
                information.value?.let {
                    BinDetailView(binDetail = it)
                }
            }
        }
    }
}

@Composable
private fun BinDetailView(binDetail: BinDetail) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        CardNumberText(number = binDetail.numberBin)

        TextWithTitle(title = "Scheme", value = binDetail.scheme)
        TextWithTitle(title = "brand", value = binDetail.brand)
        TextWithTitle(title = "type", value = binDetail.type)
        TextWithTitle(title = "prepaid", value = binDetail.prepaid.toStringYesOrNo())

        val context = LocalContext.current

        BankInformation(
            bank = binDetail.bank,
            onClickWeb = {
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://${it}")))
            },

            onClickNumber = {
                context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel: $it")))
            }
        )
        CountryText(country = binDetail.country)
    }
}