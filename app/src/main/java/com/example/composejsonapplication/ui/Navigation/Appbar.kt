package com.example.composejsonapplication.ui.Navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    targetScreen:NavigationItem
){




    TopAppBar(
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
    )

}