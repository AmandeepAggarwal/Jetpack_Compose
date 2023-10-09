package com.amandeep.jetpackcompose.ui.activity

import BankForm
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.amandeep.jetpackcompose.ui.ui.theme.LearnComposeTheme

class FormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                Surface {
                    BankForm()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BankFormPreview() {
    LearnComposeTheme {
        BankForm()
    }
}