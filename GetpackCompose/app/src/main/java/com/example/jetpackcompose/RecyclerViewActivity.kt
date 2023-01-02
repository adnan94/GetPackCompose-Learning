package com.example.jetpackcompose

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class RecyclerViewActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    UserList()
                }
            }
        }
    }
}

val users = listOf("Adnan", "Zeeshan", "Noman", "Faizan", "Adnan", "Zeeshan", "Noman", "Faizan")

@Composable
fun UserCardItem(userName: String) {
    Surface(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current

        Row() {

            Card(
                elevation = 4.dp,
                modifier = Modifier.padding(10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
//                .border(width = 1.dp, color = Color.Gray)
                        .padding(12.dp)
                ) {

                    Image(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.aaa),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )

                    Column(verticalArrangement = Arrangement.Center) {

                        Text(text = userName,
                            color = colorResource(id = R.color.purple_500),
                            fontSize = 20.sp,
                            modifier = Modifier
                                .clickable {
                                    Toast
                                        .makeText(context, "Clicked", Toast.LENGTH_SHORT)
                                        .show()
                                }
                                .padding(8.dp)
                        )
                        Button(onClick = { /*TODO*/
                            ContextCompat.startActivity(
                                context,
                                Intent(context, RecyclerViewActivity::class.java),
                                null
                            )
                        }, modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
                            Text(text = "RecyclerView")
                        }
                    }
                }

            }


        }
    }
}

@Composable
fun UserList() {
    LazyColumn {
        items(users) { user ->
            UserCardItem(user)
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