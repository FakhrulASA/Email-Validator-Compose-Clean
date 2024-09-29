package com.fakhrulasa.emailvalidator_composeclean.presentation.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fakhrulasa.emailvalidator_composeclean.R
import com.fakhrulasa.emailvalidator_composeclean.presentation.widget.OutlinedTextFieldCustom

class EmailValidatorInputActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmailValidatorInputScreen()
        }
    }
}

@Composable
fun EmailValidatorInputScreen() {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.please_input_the_email_you_want_to_validate))
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextFieldCustom(stringResource(R.string.enter_your_email)) {

        }
        Spacer(modifier = Modifier.height(42.dp))

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
        ) {
            val isLoading = false
            if (isLoading == true) {
                CircularProgressIndicator(
                    color = Color.Black
                )
            } else {
                Text(
                    text = "Login", style = TextStyle(
                        color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.W700
                    )
                )
            }


        }
    }
}