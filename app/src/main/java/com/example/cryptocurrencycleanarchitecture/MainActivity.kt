package com.example.cryptocurrencycleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrencycleanarchitecture.presentation.Screen
import com.example.cryptocurrencycleanarchitecture.presentation.conin_details.Conponents.CoinDetailScreen
import com.example.cryptocurrencycleanarchitecture.presentation.conin_list.CoinListScreen
import com.example.cryptocurrencycleanarchitecture.ui.theme.CryptocurrencyCleanArchitectureTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyCleanArchitectureTheme {
                Surface(color = MaterialTheme.colors.background){
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                    startDestination = Screen.CoinListScreen.route){
                        composable(route = Screen.CoinListScreen.route){
                           CoinListScreen(navController)
                        }
                        composable(route = Screen.CoinDetailScreen.route + "/{coinId}"){
                            CoinDetailScreen()
                        }
                    }
                }
            }

        }
        }
    }


