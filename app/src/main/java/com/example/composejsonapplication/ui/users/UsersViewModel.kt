package com.example.composejsonapplication.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejsonapplication.data.model.posts.PostsItemModel
import com.example.composejsonapplication.data.model.users.UsersItemModel
import com.example.composejsonapplication.data.model.users.UsersModel
import com.example.composejsonapplication.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    val repository: Repository
) : ViewModel(){
    //Initialising Mutable State Flow to store the data

    private var _users = MutableStateFlow<ArrayList<UsersItemModel>>(arrayListOf())

    val users: StateFlow<ArrayList<UsersItemModel>> = _users

    //Initialising the API call request to fetch the data
    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            // Call the repository to fetch the array of comments
            val response = repository.getUsers()
            // Update the state with the comments array
            _users.value= response
        }

    }
}