package com.example.lab5_msec.ui.home

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.lab5_msec.InventoryTopAppBar
import com.example.lab5_msec.R
import com.example.lab5_msec.ui.navigation.NavigationDestination
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.lab5_msec.ui.item.VM

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.app_name
}

/**
 * Entry route for Home screen
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToItemDetails: (Uri) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    var imageUri: Uri? by rememberSaveable { mutableStateOf(null) }
    if (imageUri != null){
        VM.UpdateUIForNewPicture(imageUri!!)
        navigateToItemDetails(imageUri!!)
        imageUri = null
    }

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { selectedUri ->
        if (selectedUri != null) {
            imageUri = selectedUri

        }
    }


    Column (
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        InventoryTopAppBar(
            title = stringResource(HomeDestination.titleRes),
            canNavigateBack = false,
            scrollBehavior = scrollBehavior
        )

        Button(
            onClick = {
                launcher.launch(
                    PickVisualMediaRequest(ActivityResultContracts
                        .PickVisualMedia.ImageOnly)
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.small,
            enabled = true
        ) {
            Text(stringResource(R.string.get_img))
        }
    }
}





