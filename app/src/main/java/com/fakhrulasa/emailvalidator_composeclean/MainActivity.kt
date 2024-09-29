package com.fakhrulasa.emailvalidator_composeclean

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fakhrulasa.emailvalidator_composeclean.presentation.screen.EmailValidatorInputScreen
import com.fakhrulasa.emailvalidator_composeclean.ui.theme.EmailValidatorComposeCleanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EmailValidatorComposeCleanTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EmailValidatorInputScreen()
                }
            }
        }
    }
}
