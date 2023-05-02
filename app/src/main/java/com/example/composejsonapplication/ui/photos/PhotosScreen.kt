package com.example.composejsonapplication.ui.photos

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
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
import coil.compose.rememberAsyncImagePainter
import com.example.composejsonapplication.data.model.comments.CommentsItemModel
import com.example.composejsonapplication.data.model.photos.PhotosItemModel
import com.example.composejsonapplication.ui.comments.ClickableCard
import com.example.composejsonapplication.ui.comments.CommentsItem
import com.example.composejsonapplication.ui.comments.CommentsViewModel

@Composable
fun PhotosScreen(navController: NavController){
    val photosViewModel: PhotosViewModel = hiltViewModel()
    val photosArray by photosViewModel.photos.collectAsState()


    Column(
        modifier = Modifier.padding(top = 10.dp)
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(top = 10.dp)

        ) {
            itemsIndexed(photosArray) { _, photosItem ->
                if (photosItem != null) {
                    PhotosItem(photosItem)
                }
            }

        }
    }
}

@Composable
fun PhotosItem(photosItem: PhotosItemModel) {
    var isClicked by remember { mutableStateOf(false) }

    Column {
        ClickableCard(
            onCardClick = { isClicked = true },
            photosItem
        )
    }
    //For the expanded card visibility
    AnimatedVisibility(isClicked) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .padding(16.dp)// Set the background color
        ){
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(8.dp)
                    .clickable {
                        isClicked = !isClicked

                    }

            ){
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.padding(16.dp)
                ){
                    Column(Modifier.padding(8.dp)) {
                        Image(painter = rememberAsyncImagePainter(photosItem.url),
                            contentDescription = "",
                            Modifier.size(150.dp))

                    }
                    Column(Modifier.padding(8.dp)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(horizontal = 4.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                "Photo Id:",
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.End,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                            photosItem.id?.toString().let {
                                if (it != null) {
                                    Text(
                                        it,
                                        color = Color.Blue,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier.padding(start = 4.dp)
                                    )
                                }
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .padding(vertical = 4.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    "Album Id:",
                                    color = Color.Blue,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier.padding(start = 4.dp)
                                )
                                photosItem.albumId.toString()?.let {
                                    Text(
                                        it,
                                        color = Color.Blue,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier.padding(start = 4.dp)
                                    )
                                }
                            }
                        }

                    }

                    }
                }

            }
        }
    }


@Composable
fun ClickableCard(onCardClick: () -> Unit, photosItem: PhotosItemModel) {
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
                .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically){
                photosItem.title?.let {
                    Text(text = it,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left)
                }
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 48.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top){
                Image(painter = rememberAsyncImagePainter(photosItem.thumbnailUrl),
                    contentDescription ="",
                Modifier.size(150.dp,150.dp))
            }


        }


    }

}



