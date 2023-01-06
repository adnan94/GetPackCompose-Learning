package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {

                        composable("home") {
                            Home(navController)
                        }

//                        composable("office?item={itemValue}", arguments =
//                        listOf(
//                            navArgument("itemValue"){
//                                type = NavType.StringType
//                                defaultValue = "Item not available"
//                                nullable = true
//                            })
//                        ) {
//                        val item = it.arguments?.getString("itemValue")
//                        Office(navController,item)
//                    }

//                        or

                        composable("office/{item}/{item2}") {
                            val item = it.arguments?.getString("item")
                            val item2 = it.arguments?.getString("item2")
                            Office(navController,"$item $item2")
                        }

                    }


                }
            }
        }
    }
}

