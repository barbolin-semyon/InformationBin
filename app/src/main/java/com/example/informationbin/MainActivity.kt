package com.example.informationbin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.informationbin.ui.navigation.AppBottomNavigation
import com.example.informationbin.ui.navigation.NavGraph
import com.example.informationbin.ui.theme.InformationBinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            InformationBinTheme {
                Scaffold(bottomBar = { AppBottomNavigation(navHostController = navController) }) {
                    Box(Modifier.padding(it)) {
                        NavGraph(navController = navController)
                    }
                }
            }
        }
    }
}

