package com.brighterbee.tech.cryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brighterbee.tech.cryptocurrency.presentation.coin_detail.CoinDetailScreen
import com.brighterbee.tech.cryptocurrency.presentation.coin_list.CoinListScreen
import com.brighterbee.tech.cryptocurrency.presentation.ui.theme.CryptocurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        setContent {
            CryptocurrencyTheme {
                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()

                    NavHost(
                        navController,
                        startDestination = Screen.CoinListScreen.route,
                    ){
                        composable(
                            Screen.CoinListScreen.route
                        ){
                            CoinListScreen(navController)
                        }

                        composable(
                            Screen.CoinDetailsScreen.route + "/{coinId}"
                        ){
                            CoinDetailScreen()
                        }
                    }

                }
            }
        }
    }
}
