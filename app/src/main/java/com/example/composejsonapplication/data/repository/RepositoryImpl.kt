package com.example.composejsonapplication.data.repository

import com.example.composejsonapplication.data.model.albums.AlbumsModel
import com.example.composejsonapplication.data.model.comments.CommentsModel
import com.example.composejsonapplication.data.model.photos.PhotosModel
import com.example.composejsonapplication.data.model.posts.PostsModel
import com.example.composejsonapplication.data.model.todos.TodosModel
import com.example.composejsonapplication.data.model.users.UsersModel
import com.example.composejsonapplication.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiRequest: ApiRequest
) : Repository{
    override suspend fun getAlbums(): AlbumsModel = apiRequest.getAlbums()

    override suspend fun getComments(): CommentsModel = apiRequest.getComments()

    override suspend fun getPhotos(): PhotosModel  = apiRequest.getPhotos()

    override suspend fun getPosts(): PostsModel = apiRequest.getPosts()

    override suspend fun getTodos(): TodosModel = apiRequest.getTodos()

    override suspend fun getUsers(): UsersModel = apiRequest.getUsers()
    override suspend fun getUserById(userId: String)=apiRequest.getUserById(userId)
}