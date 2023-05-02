package com.example.composejsonapplication.ui.todos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composejsonapplication.data.model.posts.PostsItemModel
import com.example.composejsonapplication.data.model.todos.TodosItemModel
import com.example.composejsonapplication.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodosViewModel @Inject constructor(
    val repository: Repository
) :ViewModel(){
    //Initialising Mutable State Flow to store the data

    private var _toDos = MutableStateFlow<ArrayList<TodosItemModel>>(arrayListOf())

    val toDos: StateFlow<ArrayList<TodosItemModel>> = _toDos

    //Initialising the API call request to fetch the data
    init {
        getTodos()
    }

    fun getTodos() {
        viewModelScope.launch {
            // Call the repository to fetch the array of comments
            val response = repository.getTodos()
            // Update the state with the comments array
            _toDos.value= response
        }

    }
}