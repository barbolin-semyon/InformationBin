package com.example.informationbin.ui.features

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.informationbin.data.emptities.BinDetail
import com.example.informationbin.ui.features.component.*
import com.example.informationbin.ui.features.component.infoBin.BaseInfo
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
                if (information.value == null) {
                    ErrorMessage()
                } else {
                    BinDetailView(binDetail = information.value!!)
                }
            }
        }
    }
}

@Composable
private fun BinDetailView(binDetail: BinDetail) {
    Column(
        modifier = Modifier.padding(start = 8.dp)
    ) {
        val context = LocalContext.current

        CardNumberText(number = binDetail.numberBin)
        BaseInfo(binDetail)

        BankInformation(
            bank = binDetail.bank,
            onClickWeb = {
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://${it}")))
            },
            onClickNumber = {
                context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel: $it")))
            }
        )

        CountryText(country = binDetail.country) { latitude, longitude ->
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:$latitude, $longitude")
                )
            )
        }
    }
}