package com.example.composejsonapplication.ui.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejsonapplication.data.model.comments.CommentsItemModel
import com.example.composejsonapplication.data.model.photos.PhotosItemModel
import com.example.composejsonapplication.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    val repository: Repository
):ViewModel(){
    //Initialising Mutable State Flow to store the data

    private var _photos = MutableStateFlow<ArrayList<PhotosItemModel>>(arrayListOf())

    val photos: StateFlow<ArrayList<PhotosItemModel>> = _photos

    //Initialising the API call request to fetch the data
    init {
        getPhotos()
    }

    fun getPhotos() {
        viewModelScope.launch {
            // Call the repository to fetch the array of comments
            val response = repository.getPhotos()
            // Update the state with the comments array
            _photos.value= response
        }

    }
}