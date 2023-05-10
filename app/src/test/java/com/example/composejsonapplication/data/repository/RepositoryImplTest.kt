package com.example.composejsonapplication.data.repository

import com.example.composejsonapplication.data.model.albums.AlbumsModel
import com.example.composejsonapplication.data.model.comments.CommentsModel
import com.example.composejsonapplication.data.model.photos.PhotosModel
import com.example.composejsonapplication.data.model.posts.PostsItemModel
import com.example.composejsonapplication.data.model.posts.PostsModel
import com.example.composejsonapplication.data.model.users.*
import com.example.composejsonapplication.data.remote.ApiRequest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class RepositoryImplTest {
    @Mock
    lateinit var apiReq : ApiRequest


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun repositoryTestGetUsers_EmptyList()= runTest {
        val users = UsersModel()


        //Mockito feature
        Mockito.`when`(apiReq.getUsers()).thenReturn(users)
        val repositoryTest= RepositoryImpl(apiReq)
        val result= repositoryTest.getUsers()
        Assert.assertEquals(0,result.size)
    }
    @Test
    fun repositoryTestGetAlbums_EmptyList() = runTest{
        val albums = AlbumsModel()

        Mockito.`when`(apiReq.getAlbums()).thenReturn(albums)
        val repositoryTest = RepositoryImpl(apiReq)
        val result = repositoryTest.getAlbums()
        Assert.assertEquals(0,result.size)
    }
    @Test
    fun repositoryTestGetPosts_EmptyList() = runTest {
        val  posts = PostsModel()

        Mockito.`when`(apiReq.getPosts()).thenReturn(posts)
        val repositoryTest = RepositoryImpl(apiReq)
        val result = repositoryTest.getPosts()
        Assert.assertEquals(0,result.size)
    }
    @Test
    fun repositoryTestGetComments_EmptyList() = runTest {
        val comments = CommentsModel()

        Mockito.`when`(apiReq.getComments()).thenReturn(comments)
        val repositoryTest = RepositoryImpl(apiReq)
        val result = repositoryTest.getComments()
        Assert.assertEquals(0,result.size)
    }

    @Test
    fun repositoryTestGetPhotos_EmptyList() = runTest{
        val photos  = PhotosModel()

        Mockito.`when`(apiReq.getPhotos()).thenReturn(photos)
        val repositoryTest = RepositoryImpl(apiReq)
        val result = repositoryTest.getPhotos()
        Assert.assertEquals(0,result.size)
    }

    @Test
    fun testGetUsers_expectedUsersList()= runTest {
        val users_test = UsersModel().apply {
           addAll(
                listOf(
                    UsersItemModel(
                        id = 1,
                        name = "Leanne Graham",
                        username = "Bret",
                        email = "Sincere@april.biz",
                        address = AddressModel(
                            street = "Kulas Light",
                            suite = "Apt. 556",
                            city = "Gwenborough",
                            zipcode = "92998-3874",
                            geo = GeoModel(
                                lat = "-37.3159",
                                lng = "81.1496"
                            )
                        ),
                        phone = "1-770-736-8031 x56442",
                        website = "hildegard.org",
                        company = CompanyModel(
                            name = "Romaguera-Crona",
                            catchPhrase = "Multi-layered client-server neural-net",
                            bs = "harness real-time e-markets"
                        )
                    ),
                    UsersItemModel(
                        id = 2,
                        name = "Ervin Howell",
                        username = "Antonette",
                        email = "Shanna@melissa.tv",
                        address = AddressModel(
                            street = "Victor Plains",
                            suite = "Suite 879",
                            city = "Wisokyburgh",
                            zipcode = "90566-7771",
                            geo = GeoModel(
                                lat = "-43.9509",
                                lng = "-34.4618"
                            )
                        ),
                        phone = "010-692-6593 x09125",
                        website = "anastasia.net",
                        company = CompanyModel(
                            name = "Deckow-Crist",
                            catchPhrase = "Proactive didactic contingency",
                            bs = "synergize scalable supply-chains"
                        )
                    )
                )
            )
        }

        Mockito.`when`(apiReq.getUsers()).thenReturn(users_test)

        val repositoryTest= RepositoryImpl(apiReq)
        val result= repositoryTest.getUsers()
        Assert.assertEquals(2, result.size)
    }

    @Test
    fun testGetPosts_expectedPostsList()= runTest {
        val posts_test= PostsModel().apply {
            addAll(
                listOf(
                    PostsItemModel(
                        "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto",
                        1,
                        "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                        1
                    ),
                    PostsItemModel(
                        "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla",
                        2,
                        "qui est esse",
                        1
                    ),
                    PostsItemModel(
                        "sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga",
                        3,
                        "ea molestias quasi exercitationem repellat qui ipsa sit aut",
                        1
                    ),
                )
            )
        }
        Mockito.`when`(apiReq.getPosts()).thenReturn(posts_test)

        val repositoryTest= RepositoryImpl(apiReq)
        val result= repositoryTest.getPosts()
        Assert.assertEquals(3, result.size)
    }


}