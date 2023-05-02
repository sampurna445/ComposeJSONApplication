package com.example.composejsonapplication.ui.albums

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composejsonapplication.data.model.albums.AlbumsItemModel
import com.example.composejsonapplication.data.model.albums.AlbumsModel
import com.example.composejsonapplication.data.model.errorHandling.ResultOf
import com.example.composejsonapplication.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(
    val repository: Repository,
) : ViewModel() {

    //Initialising Mutable State Flow to store the data

    private var _albums = MutableStateFlow<ArrayList<AlbumsItemModel>>(arrayListOf())

    val albums: StateFlow<ArrayList<AlbumsItemModel>> = _albums

    //Initialising the API call request to fetch the data
    init {
        getAlbums()
    }

    fun getAlbums() {
        viewModelScope.launch {
            // Call the repository to fetch the array of albums
            val response = repository.getAlbums()
            // Update the state with the albums array
            _albums.value= response
        }

    }


}