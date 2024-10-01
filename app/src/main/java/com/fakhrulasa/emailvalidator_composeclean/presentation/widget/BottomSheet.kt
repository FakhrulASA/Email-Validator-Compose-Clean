package com.fakhrulasa.emailvalidator_composeclean.presentation.widget

import androidx.compose.foundation.background
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(content: @Composable () -> Unit, onDismiss: () -> Unit) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val modalBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ModalBottomSheet(
        onDismissRequest = { onDismiss.invoke() },

        sheetState = modalBottomSheetState.apply {},
        dragHandle = {
            BottomSheetDefaults.DragHandle(
                color = Color.Green
            )
        }, modifier = Modifier.background(Color.White)
    ) {
        content()
    }
}