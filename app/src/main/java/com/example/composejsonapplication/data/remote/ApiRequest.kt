package com.example.composejsonapplication.data.remote

import com.example.composejsonapplication.data.model.albums.AlbumsModel
import com.example.composejsonapplication.data.model.comments.CommentsModel
import com.example.composejsonapplication.data.model.photos.PhotosModel
import com.example.composejsonapplication.data.model.posts.PostsModel
import com.example.composejsonapplication.data.model.todos.TodosModel
import com.example.composejsonapplication.data.model.users.UsersModel
import retrofit2.http.GET

interface ApiRequest {
    @GET(ApiDetails.Albums_ENDPOINT)
    suspend fun getAlbums(): AlbumsModel

    @GET(ApiDetails.Comments_ENDPOINT)
    suspend fun getComments(): CommentsModel

    @GET(ApiDetails.Photos_ENDPOINT)
    suspend fun getPhotos(): PhotosModel

    @GET(ApiDetails.Posts_ENDPOINT)
    suspend fun getPosts(): PostsModel

    @GET(ApiDetails.Todos_ENDPOINT)
    suspend fun getTodos(): TodosModel

    @GET(ApiDetails.Users_ENDPOINT)
    suspend fun getUsers(): UsersModel
}