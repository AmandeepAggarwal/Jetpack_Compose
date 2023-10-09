package com.amandeep.jetpackcompose.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.amandeep.jetpackcompose.ui.activity.camera.CameraActivity

class ButtonsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                buttonDemo()
            }
        }
    }

    @Composable
    @Preview
    private fun buttonDemo() {
        val context = LocalContext.current
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "registration") {
            composable("registration") {
                RegistrationScreen(navController)
            }
            composable("login") {
                LoginScreen(navController)
            }
            composable("main") {
                MainScreen(navController)
            }
        }


       /* Button(onClick = {

        }) {
            Text(text = "Text")
        }*/

        Button(onClick = {
            val intent = Intent(this, RecycleViewActivity::class.java)
            startActivity(intent)
        }, shape = CutCornerShape(2.dp)) {
            Text(text = "Recycle View")
        }

        Button(onClick = {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }, shape = CutCornerShape(2.dp)) {
            Text(text = "Camera")
        }

        TextButton(onClick = {
            Toast.makeText(context, "Click Text Add To Cart", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }) {
            Text(text = "Register Form")
        }

       /* OutlinedButton(onClick = {
            Toast.makeText(context, "Click Outline Add To Cart", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Add To Cart")
        }

        IconButton(onClick = {
            Toast.makeText(context, "Click Icon Button Add To Cart", Toast.LENGTH_SHORT).show()
        }) {
            Icon(Icons.Default.Refresh, contentDescription = "Refresh")
        }

        textDemo(str = "hii")*/

        ChangeText()
    }

    @Composable
    fun RegistrationScreen(navController: NavHostController) {
        Text(text = "RegistrationScreen",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.clickable {
                navController.navigate("main")
            }
        )
    }

    @Composable
    fun LoginScreen(navController: NavHostController){
        Text(text = "LoginScreen",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.clickable {
                navController.navigate("registration")
            }
        )
    }

    @Composable
    fun MainScreen(navController: NavHostController){
        Text(
            text = "MainScreen",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.clickable {
                navController.navigate("login")
            })
    }

    @Composable
    fun textDemo(str: String) {
        Text(
            text = str,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .background(Color.Red)
                .border(5.dp, Color.Yellow)
                .padding(10.dp)

        )
    }

    @Composable
    fun ChangeText() {
        var text by remember { mutableStateOf("Click a button") }

        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color.Red)
                    .border(5.dp, Color.Yellow)
                    .padding(10.dp)

            )

            Button(onClick = { text = "Button 1 Clicked" }) {
                Text(text = "Button 1")
            }
            Button(onClick = { text = "Button 2 Clicked" }) {
                Text(text = "Button 2")
            }
            Button(onClick = { text = "Button 3 Clicked" }) {
                Text(text = "Button 3")
            }
        }
    }

}