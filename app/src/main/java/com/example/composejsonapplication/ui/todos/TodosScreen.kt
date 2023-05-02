package com.example.composejsonapplication.ui

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
import com.example.composejsonapplication.data.model.todos.TodosItemModel
import com.example.composejsonapplication.ui.albums.AlbumItem
import com.example.composejsonapplication.ui.albums.AlbumsViewModel
import com.example.composejsonapplication.ui.albums.ClickableCard
import com.example.composejsonapplication.ui.todos.TodosViewModel

@Composable
fun TodosScreen(navController: NavController){
    val ToDosViewModel: TodosViewModel = hiltViewModel()
    val toDos by ToDosViewModel.toDos.collectAsState()

    Column(
        modifier = Modifier.padding(top = 10.dp)
    ) {

        LazyColumn(
            modifier = Modifier
                .padding(top = 10.dp)

        ) {
            itemsIndexed(toDos) { _, toDoItem ->
                if (toDoItem != null) {
                    ToDoItem(toDoItem)
                }
            }

        }
    }
}

@Composable
fun ClickableCard(onCardClick: () -> Unit, toDoItem: TodosItemModel) {
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
                toDoItem.title?.let {
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
fun ToDoItem(toDoItem: TodosItemModel) {
    var isClicked by remember { mutableStateOf(false) }

    Column {
        ClickableCard(
            onCardClick = { isClicked = true },
            toDoItem
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
                            "Title:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End,
                            modifier = Modifier.padding(start = 24.dp)
                        )
                        toDoItem.title?.let {
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
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            "Id:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                        toDoItem.id?.let {
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
                            .padding(horizontal = 4.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            "User Id:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                        toDoItem.userId?.let {
                            Text(
                                it.toString(),
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.padding(start = 6.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(
                            "Status:",
                            color = Color.Blue,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.End,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                        toDoItem.completed?.let {
                            var toDoStatus = ""
                            if(it)
                                toDoStatus = "Completed"
                            else
                                toDoStatus = "Pending"

                            Text(
                                toDoStatus,
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
