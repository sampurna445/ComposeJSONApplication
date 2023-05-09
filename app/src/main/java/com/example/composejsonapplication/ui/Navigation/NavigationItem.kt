package com.example.composejsonapplication.ui.Navigation

import com.example.composejsonapplication.R
enum class NavigationItem(var route: String,var icon : Int,var title:String, var maintab:Boolean){
     LoginScreen("login", R.drawable.icon_posts,"Login",  false),
     SignUpScreen("signUp", R.drawable.icon_posts, "SignUp", false),
     Posts("posts", R.drawable.icon_posts,"Posts", true),
     Comments("comments", R.drawable.icon_comments,"Comments",true),
     Albums("albums", R.drawable.icon_albums,"Albums", true),
     Photos("photos", R.drawable.icon_photos,"Photos", true),
     Todos("toDos", R.drawable.icon_todos,"Todos", true),
     Users("users", R.drawable.icon_users,"Users",  true),
     UsersDetails("usersDetails", R.drawable.icon_users,"UsersDetails",false),
     Logout("logout", R.drawable.icon_logout,"Logout", true)

}
