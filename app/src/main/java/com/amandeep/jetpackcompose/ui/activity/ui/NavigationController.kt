package com.amandeep.jetpackcompose.ui.activity.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.amandeep.jetpackcompose.Routes
import com.amandeep.jetpackcompose.ui.activity.ui.ui.theme.JetPackComposeTheme
import com.amandeep.jetpackcompose.ui.ui.theme.LearnComposeTheme
import com.google.firebase.firestore.model.Values


class NavigationController : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {


            }

        }

    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        JetPackComposeTheme {

        }
    }
}
