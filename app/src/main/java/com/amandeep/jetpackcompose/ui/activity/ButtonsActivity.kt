package com.amandeep.jetpackcompose.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        Button(onClick = {

        }) {
            Text(text = "Text",)
        }

        Button(onClick = {
            val intent = Intent(this, RecycleViewActivity::class.java)
            startActivity(intent)
        }, shape = CutCornerShape(2.dp)) {
            Text(text = "Recycle View")
        }

        TextButton(onClick = {
            Toast.makeText(context, "Click Text Add To Cart", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Add To Cart")
        }

        OutlinedButton(onClick = {
            Toast.makeText(context, "Click Outline Add To Cart", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Add To Cart")
        }

        IconButton(onClick = {
            Toast.makeText(context, "Click Icon Button Add To Cart", Toast.LENGTH_SHORT).show()
        }) {
            Icon(Icons.Default.Refresh, contentDescription = "Refresh")
        }

        textDemo(str = "hii")
    }


    @Composable

    private fun textDemo(str: String) {
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

}