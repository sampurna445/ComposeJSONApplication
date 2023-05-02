package com.example.composejsonapplication.ui.Navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composejsonapplication.ui.theme.AppbarColor

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    targetScreen: NavigationItem,
    navController: NavHostController
){
    if(targetScreen.title=="Login")
    {
        TopAppBar(
            title = {
                Text(targetScreen.title)
            },
            backgroundColor =  AppbarColor,
            contentColor = MaterialTheme.colors.onPrimary
        )
    }
    else if(targetScreen.maintab) {
        TopAppBar(
            title = {
                Text(targetScreen.title)
            },
            backgroundColor =  AppbarColor,
            contentColor = MaterialTheme.colors.onPrimary,
            navigationIcon = {
                IconButton(
                    onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Toggle drawer"
                    )

                }
            }
        )
    }
    else
    {
        TopAppBar(
            title = {
                Text(targetScreen.title)
            },
            backgroundColor =  AppbarColor,
            contentColor =MaterialTheme.colors.onPrimary,
            navigationIcon = {
                IconButton(
                    onClick = {
                        navController.navigateUp()
                    }
                ) {

                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Toggle drawer"
                    )
                }


            }
        )
    }



   /* TopAppBar(
        title = {
            Text(text = targetScreen.title, fontSize = 18.sp)
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            IconButton(onClick = {

                scope.launch { scaffoldState.drawerState.open() }
            }
            ) {

                Icon(Icons.Filled.Menu, "")
            }
        }
    )*/

}