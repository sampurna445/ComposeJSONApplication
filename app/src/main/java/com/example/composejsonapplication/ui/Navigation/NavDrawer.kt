package com.example.composejsonapplication.ui.Navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composejsonapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun  NavDrawer(
    scope: CoroutineScope,
    scaffoldState : ScaffoldState,
    navController : NavController){

    val  items = listOf(

        NavigationItem.Posts,
        NavigationItem.Albums,
        NavigationItem.Comments,
        NavigationItem.Users,
        NavigationItem.Photos,
        NavigationItem.Todos,
        NavigationItem.Logout,
        NavigationItem.SignUpScreen,
        NavigationItem.LoginScreen
    )
    Column (modifier = Modifier
        .background(color = Color.White)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color.Magenta),
                verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.mockend_logo),
                contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(10.dp))
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(5.dp)
        )

        val navBackStackEntryState by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntryState?.destination?.route

        items.forEach{items ->
            NavDrawerItem(item = items,
                            selected = currentRoute == items.route,
                            onItemClick = {
                                if(items.route == "logout" ) {
                                    popUpToLogin(navController as NavHostController)

                                }
                                else {
                                    navController.navigate(items.route) {

                                        navController.graph.startDestinationRoute?.let { route ->
                                            popUpTo(route) {
                                                saveState = true
                                            }
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                            }
            )

        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Mockend App",
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun NavDrawerItem(
                item:NavigationItem,
                selected: Boolean,
                onItemClick:(NavigationItem) -> Unit
                )
{
    val background = if (selected) R.color.selected_item
                    else android.R.color.transparent

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(start = 10.dp)
            .background(colorResource(id = background))
            .clickable { onItemClick(item) }
    ){
        Image(painter = painterResource(id = item.icon),
              contentDescription = item.title,
                colorFilter = ColorFilter.tint(Color.Black),
                contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(24.dp)
                .width(24.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = item.title,
            fontSize = 16.sp,
            color = Color.Black
        )
    }

}

private fun popUpToLogin(navController: NavHostController) {
    navController.popBackStack(NavigationItem.LoginScreen.route, inclusive = false)
}
