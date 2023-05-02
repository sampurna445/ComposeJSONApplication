package com.example.composejsonapplication.ui.users

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
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
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .fillMaxWidth()
                .clickable {
                    onUserClick(userItem.id.toString())
                },
            elevation = 8.dp,
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberImagePainter(data = "https://picsum.photos/id/${userItem.id}/200"),
                    contentDescription = null,
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = userItem.name ?: "",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = userItem.email ?: "",
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Icon(
                            Icons.Filled.LocationOn,
                            contentDescription = "Location",
                            tint = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = userItem.address?.city ?: "",
                            color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f),
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }


    }


}

/*Card(
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


}*/
