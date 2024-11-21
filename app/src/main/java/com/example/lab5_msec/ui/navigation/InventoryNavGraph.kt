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

package com.example.lab5_msec.ui.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab5_msec.ui.home.HomeDestination
import com.example.lab5_msec.ui.home.HomeScreen
import com.example.lab5_msec.ui.item.ItemDetailsDestination
import com.example.lab5_msec.ui.item.ItemDetailsScreen
//import com.example.lab5_msec.ui.item.ItemEditDestination
//import com.example.lab5_msec.ui.item.ItemEditScreen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun InventoryNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    var imageUri: Uri? by rememberSaveable { mutableStateOf(null) }

    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToItemDetails = {imageUri = it
                    navController.navigate(ItemDetailsDestination.route) }
            )
        }

        composable(route = ItemDetailsDestination.route)
        {
            ItemDetailsScreen(
                navigateToEditItem = { },//navController.navigate(ItemEditDestination.route) },
                navigateBack = { navController.popBackStack() },
                navigateToHome = { navController.navigate(HomeDestination.route) },
                uri = imageUri!!
            )
        }

        //composable(route = ItemEditDestination.route) {
        //    ItemEditScreen(
        //        navigateBack = { navController.popBackStack() },
        //        navigateToHome = {navController.navigate(HomeDestination.route)}
        //    )
        //}

    }
}
