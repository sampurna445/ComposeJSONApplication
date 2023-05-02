package com.example.composejsonapplication.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composejsonapplication.ui.TodosScreen
import com.example.composejsonapplication.ui.albums.AlbumsScreen
import com.example.composejsonapplication.ui.comments.CommentsScreen
import com.example.composejsonapplication.ui.login.LoginScreen
import com.example.composejsonapplication.ui.photos.PhotosScreen
import com.example.composejsonapplication.ui.posts.PostsScreen
import com.example.composejsonapplication.ui.userDetails.UserDetailsScreen
import com.example.composejsonapplication.ui.users.UsersScreen

@Composable
fun NavGraph(navController: NavHostController,
             targetScreen: MutableState<NavigationItem>){
    NavHost(navController, startDestination = NavigationItem.Login.route ){

        addLoginScreen(navController,
            this,
            targetScreen
        )


        composable(NavigationItem.Posts.route){
            targetScreen.value = NavigationItem.Posts
            PostsScreen(navController = navController)
        }
        composable(NavigationItem.Photos.route){
            targetScreen.value = NavigationItem.Photos
            PhotosScreen(navController = navController)
           
        }
        composable(NavigationItem.Comments.route){
            targetScreen.value = NavigationItem.Comments
            CommentsScreen(navController = navController)
           
        }
        composable(NavigationItem.Albums.route){
            targetScreen.value = NavigationItem.Albums
            AlbumsScreen(navController = navController)
        }
        composable(NavigationItem.Users.route){
            targetScreen.value = NavigationItem.Users
            UsersScreen(navController = navController)
        }
        composable(NavigationItem.Todos.route){
            targetScreen.value = NavigationItem.Todos
           TodosScreen(navController = navController)
        }
        composable("${NavigationItem.UsersDetails.route}/{userId}") { backStackEntry ->
            targetScreen.value = NavigationItem.UsersDetails
            UserDetailsScreen(
                backStackEntry.arguments?.getString("userId")!!.toLong()
            )
        }
    }

}


private fun addLoginScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    targetScreen: MutableState<NavigationItem>
) {
    navGraphBuilder.composable(route = NavigationItem.Login.route) {
        targetScreen.value = NavigationItem.Login
        LoginScreen(
            navigateToPosts = {
                navController.navigate(NavigationItem.Posts.route)
            }
        )
    }
}
