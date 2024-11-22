package com.example.lab5_msec.ui.item

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class ItemEditViewModel(): ViewModel() {
    var uiState = mutableStateOf(ItemDetailsUIState())

    fun onDateChange(newValue: String) {
        uiState.value = uiState.value.copy(date = newValue)
    }

    fun onLatChange(newValue: String) {
        uiState.value = uiState.value.copy(latitude = newValue)
    }

    fun onLongChange(newValue: String) {
        uiState.value = uiState.value.copy(longitude = newValue)
    }

    fun onDeviceChange(newValue: String) {
        uiState.value = uiState.value.copy(device = newValue)
    }

    fun onModelChange(newValue: String) {
        uiState.value = uiState.value.copy(model = newValue)
    }

    fun UpdateUIForNewPicture(uri: Uri){
        uiState = mutableStateOf(ItemDetailsUIState())
        //ToDo выставлять здесь актуальные данные
    }
}