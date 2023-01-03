package com.example.jetpackcompose

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat.startActivity
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                MainView()
            }
        }
    }

    @Composable
    fun MainView() {
        val context = LocalContext.current
        Column() {
            todoListButton(context)
            fragmentButton(context)
            fragmentButton2(context)
            composeWithXml(context)
            UserCard("Adnan Ahmed")
        }
    }

    @Composable
    private fun composeWithXml(context: Context) {
        Row {
         AndroidView(factory = {
             View.inflate(it,R.layout.image_layout,null)
         }, update = {
             val imageView = it.findViewById<ImageView>(R.id.iv)
             imageView.setOnClickListener {
                 Toast.makeText(context,"Clicked image",Toast.LENGTH_SHORT).show()
             }
         })
        }
    }

    @Composable
    private fun fragmentButton(context: Context) {
        Row() {
            Button(
                onClick = { /*TODO*/
                    val intent = Intent(context,FragmentsActivity::class.java)
                    intent.putExtra("type","compose")
                    startActivity(intent,
                        null
                    )
                }, modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Compose Fragment")
            }
        }
    }
}


@Composable
private fun fragmentButton2(context: Context) {
    Row() {
        Button(
            onClick = { /*TODO*/
                val intent = Intent(context,FragmentsActivity::class.java)
                intent.putExtra("type","xml")
                startActivity(context,intent,
                    null
                )
            }, modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Compose Fragment With Xml")
        }
    }
}


@Composable
private fun todoListButton(context: Context) {
    Row() {
        Button(
            onClick = { /*TODO*/
                startActivity(
                    context,
                    Intent(context, TodoList::class.java),
                    null
                )
            }, modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(text = "TodoList")
        }
    }
}

@Composable
fun UserCard(userName: String) {
    Row() {
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
                                startActivity(
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
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
    }
}