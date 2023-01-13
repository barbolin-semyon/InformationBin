package com.example.informationbin.ui.navigation

import com.example.informationbin.R

sealed class Screens(val route: String, val icon: Int, val label: String) {
    object History : Screens("history", R.drawable.ic_history, label = "История")
    object Information : Screens("info", R.drawable.ic_info, label = "Информация")
}

sealed class InformationScreens(val route: String) {
    object InputBin : InformationScreens("input")
    object DetailBin : InformationScreens("detail/{bin}}") {
        fun passBin(bin: String) = "detail/$bin"
    }
}

val screensForBottomNav = listOf(Screens.History, Screens.Information)
