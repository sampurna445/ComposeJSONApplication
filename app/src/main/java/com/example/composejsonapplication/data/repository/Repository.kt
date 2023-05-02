package com.example.composejsonapplication.data.repository

import com.example.composejsonapplication.data.model.albums.AlbumsModel
import com.example.composejsonapplication.data.model.comments.CommentsModel
import com.example.composejsonapplication.data.model.photos.PhotosModel
import com.example.composejsonapplication.data.model.posts.PostsModel
import com.example.composejsonapplication.data.model.todos.TodosModel
import com.example.composejsonapplication.data.model.users.UsersModel

interface Repository {
    suspend fun getAlbums(): AlbumsModel
    suspend fun getComments(): CommentsModel
    suspend fun getPhotos(): PhotosModel
    suspend fun getPosts(): PostsModel
    suspend fun getTodos(): TodosModel
    suspend fun getUsers(): UsersModel
}