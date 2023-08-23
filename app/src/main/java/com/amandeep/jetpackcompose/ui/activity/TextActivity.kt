package com.amandeep.jetpackcompose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //textDemo(str = "Hii")
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                textDemo("Hii Krishan Mohan")
                textDemo("Hii Ankur Sharma")
                textDemo("Hii Team")
            }

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top

            ) {
                textDemo("Hii Krishan Mohan")
                textDemo("Hii Ankur Sharma")
                textDemo("Hii Team")
            }

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom

            ) {
                textDemo("Hii Krishan Mohan")
                textDemo("Hii Ankur Sharma")
                textDemo("Hii Team")
            }
        }
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



