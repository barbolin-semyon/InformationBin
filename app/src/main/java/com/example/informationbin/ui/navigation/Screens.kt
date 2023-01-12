package com.example.informationbin.ui.navigation

import com.example.informationbin.R

sealed class Screens(val route: String, val icon: Int) {
    object History : Screens("history", R.drawable.ic_history)
    object Information : Screens("info", R.drawable.ic_info)
}

sealed class InformationScreens(val route: String) {
    object InputBin : InformationScreens("input")
    object DetailBin : InformationScreens("detail/{bin}}") {
        fun passBin(bin: String) = "detail/$bin"
    }
}
