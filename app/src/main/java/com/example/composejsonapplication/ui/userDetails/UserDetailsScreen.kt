package com.example.composejsonapplication.ui.userDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.composejsonapplication.data.model.users.UsersItemModel
import com.example.composejsonapplication.ui.users.UsersViewModel

@Composable
fun UserDetailsScreen(
    userId: Long
) {
    val usersDetailModel = hiltViewModel<UsersViewModel>()
    val users by usersDetailModel.users.collectAsState()





    val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            UserDetailsContent(users)
        }
    }
}

@Composable
fun UserDetailsContent(usersDetails: ArrayList<UsersItemModel>) {

/*
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            color = Color(0xFF6F7FF7),
            text = usersDetails.,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = mealDetails.strMealThumb,
            contentDescription = "My Image",
            modifier = Modifier
                .size(175.dp)
                .align(Alignment.CenterVertically)
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .weight(.75f)
                .padding(start = 20.dp, top = 10.dp, bottom = 10.dp)
                .background(
                    color = Color(0xFF6F7FF7),
                    shape = RoundedCornerShape(16.dp)
                ),
            verticalArrangement = Arrangement.Center
        ) {
            mealDetails.strArea?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(.75f)
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
                .background(
                    color = Color(0xFF6F7FF7),
                    shape = RoundedCornerShape(16.dp)
                ),
            verticalArrangement = Arrangement.Center
        ) {
            mealDetails.strCategory?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }


    Row(
        modifier = Modifier
            .background(Color.White)
            .padding(start = 15.dp, bottom = 20.dp, top = 5.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = "Ingredients",
            style = MaterialTheme.typography.h6,
            color = Color(0xFF6F7FF7),
            fontWeight = FontWeight.Bold
        )
    }

    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        IngredientsList(mealIngredients = populateIngredients(mealDetails))
    }

    Row(
        modifier = Modifier
            .background(Color.White)
            .padding(start = 15.dp, bottom = 5.dp, top = 15.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Instructions",
            style = MaterialTheme.typography.h6,
            color = Color(0xFF6F7FF7),
            fontWeight = FontWeight.Bold
        )
    }

    Row(
        modifier = Modifier
            .background(Color.White)
            .padding(bottom = 20.dp, start = 15.dp, end = 15.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        mealDetails.strInstructions?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.caption
            )
        }
    }


*/

}
