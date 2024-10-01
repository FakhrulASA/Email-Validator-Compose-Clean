package com.fakhrulasa.emailvalidator_composeclean.presentation.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fakhrulasa.emailvalidator_composeclean.R
import com.fakhrulasa.emailvalidator_composeclean.data.mapper.EmailValidatorResponseToEmailValidatorCompletionScreenUIMapper.emailValidationResponseToEmailValidationCompletionScreenUi
import com.fakhrulasa.emailvalidator_composeclean.presentation.viewmodel.EmailValidatorViewModel
import com.fakhrulasa.emailvalidator_composeclean.presentation.widget.BottomSheet
import com.fakhrulasa.emailvalidator_composeclean.presentation.widget.DetailReportWindow
import com.fakhrulasa.emailvalidator_composeclean.presentation.widget.OutlinedTextFieldCustom
import org.koin.androidx.compose.koinViewModel

@Composable
fun EmailValidatorInputScreen(viewModel: EmailValidatorViewModel = koinViewModel()) {
    var email by remember {
        mutableStateOf("")
    }

    var requestData by remember {
        mutableStateOf(false)
    }
    val emailLiveData by viewModel.emailValidatorResponse.observeAsState()
    val isLoading by viewModel.loading.observeAsState()
    val isError by viewModel.emailValidatorResponseError.observeAsState()

    if (emailLiveData != null) {
      BottomSheet(content = {DetailReportWindow(emailLiveData!!.emailValidationResponseToEmailValidationCompletionScreenUi())}) {
         //bottomsheet closed
      }
    }
    if (requestData) {
        LaunchedEffect(true) {
            viewModel.validateEmail(email)
            requestData = false
        }
    }

    if (!isError.isNullOrEmpty()) {
        Toast.makeText(LocalContext.current, isError, Toast.LENGTH_LONG).show()
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.White
            )
            .padding(24.dp)
    ) {
        Text(
            text = stringResource(R.string.please_input_the_email_you_want_to_validate),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W500,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextFieldCustom(stringResource(R.string.enter_your_email)) {
            email = it
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                requestData = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
        ) {
            if (isLoading == true) {
                CircularProgressIndicator(
                    color = Color.Black
                )
            } else {
                Text(
                    text = stringResource(R.string.validate_email), style = TextStyle(
                        color = Color.Black, fontSize = 18.sp, fontWeight = FontWeight.W700
                    )
                )
            }

        }
    }
}