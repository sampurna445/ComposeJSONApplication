package com.example.composejsonapplication.ui.albums

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composejsonapplication.data.model.albums.AlbumsItemModel

@Composable
fun AlbumsScreen(navController: NavController) {

    val albumsViewModel: AlbumsViewModel = hiltViewModel()
    val albums by albumsViewModel.albums.collectAsState()

    Column(
        modifier = Modifier.padding(top = 10.dp)
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(top = 10.dp)

        ) {
            itemsIndexed(albums) { _, albumItem ->
                if (albumItem != null) {
                    AlbumItem(albumItem)
                }
            }

            }
        }
    }


@Composable
fun ClickableCard(onCardClick: () -> Unit, albumsItem: AlbumsItemModel) {
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
                .clickable(onClick = onCardClick)
        ){
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically){
                albumsItem.title?.let {
                    Text(text = it,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left)
                }
            }

        }


    }

}

@Composable
fun AlbumItem(albumsItem: AlbumsItemModel) {

    var isClicked by remember { mutableStateOf(false) }

    Column {
        ClickableCard(
            onCardClick = { isClicked = true },
            albumsItem
        )
    }
    //For the expanded card visibility
    AnimatedVisibility(isClicked) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(16.dp)// Set the background color
        ){
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(8.dp)
                    .clickable {
                        isClicked = !isClicked

                    }

            ){
                Column(verticalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.padding(16.dp)
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            "Album Name:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End,
                            modifier = Modifier.padding(start = 24.dp)
                        )
                        albumsItem.title?.let {
                            Text(
                                it,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            "Id:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End,
                            modifier = Modifier.padding(start = 24.dp)
                        )
                        albumsItem.id?.let {
                            Text(
                                it.toString(),
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 24.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            "User Id:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End,
                            modifier = Modifier.padding(start = 24.dp)
                        )
                        albumsItem.userId?.let {
                            Text(
                                it.toString(),
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
            }
        }

    }


}