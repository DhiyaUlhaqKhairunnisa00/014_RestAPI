package com.example.connectapi.ui.kontak.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.connectapi.ui.kontak.viewmodel.InsertUiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputSiswa(
    insertUiEvent: InsertUiEvent,
    modifier: Modifier = Modifier,
    onValueChange: (InsertUiEvent) -> Unit = {},
    enabled: Boolean = true,
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

    }
}