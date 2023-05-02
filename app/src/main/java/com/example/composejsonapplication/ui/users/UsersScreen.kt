package com.example.composejsonapplication.ui.users

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composejsonapplication.data.model.users.UsersItemModel
import com.example.composejsonapplication.ui.Navigation.NavigationItem
import com.example.composejsonapplication.ui.albums.AlbumItem
import com.example.composejsonapplication.ui.albums.AlbumsViewModel

@Composable
fun UsersScreen(navController: NavController){
    val usersViewModel: UsersViewModel = hiltViewModel()
    val users by usersViewModel.users.collectAsState()

    val navigateToUserDetails: (String) -> Unit = { userId ->
        navController.navigate("${NavigationItem.UsersDetails.route}/$userId")
    }

    Column(
        modifier = Modifier.padding(top = 10.dp)
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(top = 10.dp)

        ) {
            itemsIndexed(users) { _, userItem ->
                if (userItem != null) {
                    UserItem(userItem,navigateToUserDetails)
                }
            }

        }
    }
}

@Composable
fun UserItem(userItem: UsersItemModel,
             onUserClick: (String) -> Unit,) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Magenta) // Set the background color
    ){
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable(onClick = { onUserClick(userItem.id.toString()) })
        ){
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically){
                userItem.name?.let {
                    Text(text = it,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left)
                }
            }


        }


    }


}
