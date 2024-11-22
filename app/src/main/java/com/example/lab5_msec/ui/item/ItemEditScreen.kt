/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.lab5_msec.ui.item

import android.app.Activity
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab5_msec.InventoryTopAppBar
import com.example.lab5_msec.R
import com.example.lab5_msec.ui.navigation.NavigationDestination
import com.example.lab5_msec.ui.theme.InventoryTheme
import com.example.lab5_msec.ui.home.VM

object ItemEditDestination : NavigationDestination {
    override val route = "item_edit"
    override val titleRes = R.string.edit_data
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditScreen(
    navigateBack: () -> Unit,
    navigateToHome: () -> Unit,
    uri: Uri
) {
    val uiState by VM.uiState
    val context = LocalContext.current as Activity

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        InventoryTopAppBar(
            title = stringResource(ItemEditDestination.titleRes),
            canNavigateBack = true,
            navigateUp = navigateBack
        )

        OutlinedTextField(
            value = uiState.date,
            onValueChange = { VM.onDateChange(it) },
            label = { Text(stringResource(R.string.date)) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = uiState.latitude,
            onValueChange = { VM.onLatChange(it) },
            label = { Text(stringResource(R.string.latitude)) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = uiState.longitude,
            onValueChange = { VM.onLongChange(it) },
            label = { Text(stringResource(R.string.longitude)) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = uiState.device,
            onValueChange = { VM.onDeviceChange(it) },
            label = { Text(stringResource(R.string.device)) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = uiState.model,
            onValueChange = { VM.onModelChange(it) },
            label = { Text(stringResource(R.string.model)) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Button(
            onClick = navigateToHome,
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.small
        ) {
            Text(stringResource(R.string.to_main))
        }

        Button(
            onClick = { navigateBack() }, //ToDo кнопка сохранения файла
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.small
        ) {
            Text(stringResource(R.string.edit_data))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemEditScreenPreview() {
    InventoryTheme {
        //ItemEditScreen(navigateBack = { /*Do nothing*/ }, navigateToHome = { /*Do nothing*/ })
    }
}
