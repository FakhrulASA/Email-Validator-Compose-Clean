package com.fakhrulasa.emailvalidator_composeclean.presentation.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fakhrulasa.emailvalidator_composeclean.data.model.ui_model.EmailValidatorCompletionScreenUIModel

@Composable
fun DetailReportWindow(uiModel: EmailValidatorCompletionScreenUIModel) {
    Column(modifier = Modifier.wrapContentHeight().background(Color.DarkGray).padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        DetailReportUiItem("Email Valid Status: ", uiModel.isEmailValid.toString())
        DetailReportUiItem("Email Block Status: ", uiModel.blockStatus.toString())
        DetailReportUiItem("Email Disposable Status: ", uiModel.disposableStatus.toString())
        DetailReportUiItem("Email Domain: ", uiModel.domain)
        DetailReportUiItem("Email Status: ", uiModel.statusString.toString())
        DetailReportUiItem("Email Whitelist Status: ", uiModel.whiteListStatus.toString())
        DetailReportUiItem("Email IP: ", uiModel.ip.toString())
        DetailReportUiItem("Email IP Info: ", uiModel.ipInfo.toString())
    }
}

@Composable
fun DetailReportUiItem(key: String, value: String) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = key,
            style = TextStyle(fontWeight = FontWeight.W700, fontSize = 18.sp, color = Color.White)
        )
        Text(
            text = value,
            style = TextStyle(fontWeight = FontWeight.W600, fontSize = 18.sp, color = Color.Green)
        )
    }
}