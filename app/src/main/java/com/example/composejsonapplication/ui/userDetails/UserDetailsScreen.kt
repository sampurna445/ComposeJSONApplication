package com.example.composejsonapplication.ui.userDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
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
    val usersDetailViewModel = hiltViewModel<UserDetailsViewModel>()
    usersDetailViewModel.getUserById(userId = userId.toString())

    val userDetails by usersDetailViewModel.userDetail.collectAsState()





    Column() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Name: ${userDetails.name}", fontWeight = FontWeight.Bold)
                Text(text = "Username: ${userDetails.username}")
                Text(text = "Email: ${userDetails.email}")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Address:", fontWeight = FontWeight.Bold)
                Text(text = "${userDetails.address?.street}, ${userDetails.address?.suite}")
                Text(text = "${userDetails.address?.city}, ${userDetails.address?.zipcode}")
                Text(text = "Lat: ${userDetails.address?.geo?.lat}, Lng: ${userDetails.address?.geo?.lng}")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Phone: ${userDetails.phone}")
                Text(text = "Website: ${userDetails.website}")
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Company:", fontWeight = FontWeight.Bold)
                Text(text = "${userDetails.company?.name}")
                Text(text = "${userDetails.company?.catchPhrase}")
                Text(text = "${userDetails.company?.bs}")
            }
        }



    }

}
