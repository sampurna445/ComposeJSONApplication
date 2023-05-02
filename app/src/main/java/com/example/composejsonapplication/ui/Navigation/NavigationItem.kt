package com.example.composejsonapplication.ui.Navigation

import com.example.composejsonapplication.R
/*
sealed class NavigationItem(var route: String,var icon : Int,var title:String){
    object Login:NavigationItem("login", R.drawable.icon_posts,"Login")
    object Posts:NavigationItem("posts", R.drawable.icon_posts,"Posts")
    object Comments:NavigationItem("comments", R.drawable.icon_comments,"Comments")
    object Albums:NavigationItem("albums", R.drawable.icon_albums,"Albums")
    object Photos:NavigationItem("photos", R.drawable.icon_photos,"Photos")
    object Todos:NavigationItem("toDos", R.drawable.icon_todos,"Todos")
    object Users:NavigationItem("users", R.drawable.icon_users,"Users")
    object Logout:NavigationItem("logout", R.drawable.icon_logout,"Logout")

}*/
enum class NavigationItem(var route: String,var icon : Int,var title:String, var maintab:Boolean){
     Login("login", R.drawable.icon_posts,"Login", maintab = false),
     Posts("posts", R.drawable.icon_posts,"Posts", maintab = true),
     Comments("comments", R.drawable.icon_comments,"Comments", maintab = true),
     Albums("albums", R.drawable.icon_albums,"Albums", maintab = true),
     Photos("photos", R.drawable.icon_photos,"Photos",maintab = true),
     Todos("toDos", R.drawable.icon_todos,"Todos", maintab = true),
     Users("users", R.drawable.icon_users,"Users", maintab = true),
     UsersDetails("usersDetails", R.drawable.icon_users,"UsersDetails",maintab = false),
     Logout("logout", R.drawable.icon_logout,"Logout", maintab = false)

}
