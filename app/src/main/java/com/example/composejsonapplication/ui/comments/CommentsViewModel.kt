package com.example.composejsonapplication.ui.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejsonapplication.data.model.albums.AlbumsItemModel
import com.example.composejsonapplication.data.model.comments.CommentsItemModel
import com.example.composejsonapplication.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel@Inject constructor(
    val repository: Repository
):ViewModel(){
    //Initialising Mutable State Flow to store the data

    private var _comments = MutableStateFlow<ArrayList<CommentsItemModel>>(arrayListOf())

    val comments: StateFlow<ArrayList<CommentsItemModel>> = _comments

    //Initialising the API call request to fetch the data
    init {
        getComments()
    }

    fun getComments() {
        viewModelScope.launch {
            // Call the repository to fetch the array of comments
            val response = repository.getComments()
            // Update the state with the comments array
            _comments.value= response
        }

    }
}