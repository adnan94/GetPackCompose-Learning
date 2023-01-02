package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class TodoList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                val user = ""
                val usersList = remember { // its like live data change instantly
                    mutableStateListOf(user)
                }
                Box(modifier = Modifier.fillMaxSize()) {
                    UserList(usersList)
                    Button(modifier = Modifier.align(Alignment.BottomCenter), onClick = {
                        usersList.add("Aliza")
                    }) {
                        Text(text = "Add More")
                    }
                }
            }
        }
    }


    @Composable
    fun UserList(usersList: List<String>) {
        LazyColumn {
            items(usersList) { user ->
                if(user.isNotBlank())
                UserCard(user)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview2() {
        JetpackComposeTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                UserList()
            }

        }
    }
}