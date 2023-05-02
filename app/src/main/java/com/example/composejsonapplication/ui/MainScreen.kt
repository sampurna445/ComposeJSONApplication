package com.example.composejsonapplication.ui

import android.annotation.SuppressLint
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.navigation.compose.rememberNavController
import com.example.composejsonapplication.ui.Navigation.AppBar
import com.example.composejsonapplication.ui.Navigation.NavDrawer
import com.example.composejsonapplication.ui.Navigation.NavigationItem

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val targetScreen = rememberSaveable { mutableStateOf(NavigationItem.Posts) }


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {


            AppBar(
                scope = scope,
                scaffoldState = scaffoldState,
                targetScreen = targetScreen.value,
                navController = navController
            )

        },
        drawerContent = {

            NavDrawer(
                scope = scope,
                scaffoldState = scaffoldState,
                navController = navController
            )
        }
    ) {
        com.example.composejsonapplication.ui.Navigation.NavGraph(
            navController = navController,
            targetScreen = targetScreen
        )
    }

}