package com.example.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController) {
    Surface() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                NavigationButton(navController)
            }
        }

    }
}

@Composable
fun NavigationButton(navController: NavHostController) {
    val value = "Adnan"
    val value2 = "Ahmed"
    Button(modifier = Modifier
        .padding(10.dp)
        .height(40.dp), onClick = {
        navController.navigate("office/$value/$value2")
    }) {
        Text(text = "Navigation")
    }
}
