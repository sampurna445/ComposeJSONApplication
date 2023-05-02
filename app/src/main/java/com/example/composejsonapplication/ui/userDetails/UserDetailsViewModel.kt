package com.example.composejsonapplication.ui.userDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejsonapplication.data.model.users.UsersItemModel
import com.example.composejsonapplication.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel@Inject constructor(
    val repository: Repository
): ViewModel(){
    private val _userDetail= MutableStateFlow(UsersItemModel())
    val userDetail: StateFlow<UsersItemModel> =_userDetail


    fun getUserById(userId:String){
        viewModelScope.launch {
            // call the repository to fetch the list of user details
            val result = repository.getUserById(userId)
            _userDetail.value = result
        }
    }
}