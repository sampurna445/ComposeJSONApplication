package com.example.composejsonapplication.ui.posts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejsonapplication.data.model.photos.PhotosItemModel
import com.example.composejsonapplication.data.model.posts.PostsItemModel
import com.example.composejsonapplication.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    val repository: Repository
):ViewModel(){
    //Initialising Mutable State Flow to store the data

    private var _posts = MutableStateFlow<ArrayList<PostsItemModel>>(arrayListOf())

    val posts: StateFlow<ArrayList<PostsItemModel>> = _posts

    //Initialising the API call request to fetch the data
    init {
        getPosts()
    }

    fun getPosts() {
        viewModelScope.launch {
            // Call the repository to fetch the array of comments
            val response = repository.getPosts()
            // Update the state with the comments array
            _posts.value= response
        }

    }
}