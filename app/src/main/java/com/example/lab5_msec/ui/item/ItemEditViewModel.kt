package com.example.lab5_msec.ui.item

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class ItemEditViewModel(
    uri: Uri,
    context:Context
): ViewModel() {
    var uiState = mutableStateOf(ItemDetailsUIState())
    var exRep = ExifRep(uri,context)

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

    fun UpdateUIForNewPicture(){
        uiState = mutableStateOf(ItemDetailsUIState())
        //ToDo выставлять здесь актуальные данные
        uiState.value.date = exRep.GetDate()
        uiState.value.latitude = exRep.GetLat()
        uiState.value.longitude = exRep.GetLong()
        uiState.value.device = exRep.GetDevice()
        uiState.value.model = exRep.GetModel()
    }
}