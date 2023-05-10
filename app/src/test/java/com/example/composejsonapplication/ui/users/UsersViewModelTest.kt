package com.example.composejsonapplication.ui.users

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.composejsonapplication.data.model.users.*
import com.example.composejsonapplication.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UsersViewModelTest {
    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository : Repository


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)

    }



    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testGetUser_EmptyResult() = runTest {
        val users = UsersModel()

        // Return the mock ProductsModel object from the repository
     Mockito.`when`(repository.getUsers()).thenReturn(users)

        val viewModel = UsersViewModel(repository)
        // Call the function that uses the repository to get the users
        viewModel.getUsers()

        testDispatcher.scheduler.advanceUntilIdle()


        // Check that the users state flow  contains the expected result
        val usersView = viewModel.users.value
        Assert.assertEquals(0, usersView.size)


    }



    @Test
    fun `getUsers`() = runTest {

        val users = listOf(
            UsersItemModel(
                id= 1,
                name= "Leanne Graham",
                username= "Bret",
                email= "Sincere@april.biz",
                address = AddressModel(
                    street = "Kulas Light",
                    suite ="Apt. 556",
                    city= "Gwenborough",
                    zipcode= "92998-3874",
                    geo= GeoModel(
                        lat= "-37.3159",
                        lng= "81.1496")
                ),
                phone ="1-770-736-8031 x56442",
                website= "hildegard.org",
                company=CompanyModel(
                    name= "Romaguera-Crona",
                    catchPhrase= "Multi-layered client-server neural-net",
                    bs="harness real-time e-markets"
                )),
            UsersItemModel(
                id= 2,
                name= "Ervin Howell",
                username= "Antonette",
                email= "Shanna@melissa.tv",
                address = AddressModel(
                    street = "Victor Plains",
                    suite ="Suite 879",
                    city= "Wisokyburgh",
                    zipcode= "90566-7771",
                    geo= GeoModel(
                        lat= "-43.9509",
                        lng= "-34.4618")),
                phone ="010-692-6593 x09125",
                website= "anastasia.net",
                company= CompanyModel(
                    name= "Deckow-Crist",
                    catchPhrase= "Proactive didactic contingency",
                    bs="synergize scalable supply-chains"
                )
            )
        )
        val users_test = UsersModel()
        users_test.addAll(users)

        Mockito.`when`(repository.getUsers()).thenReturn(users_test)

        // Return the mock usersModel object from the repository
        val viewModel=UsersViewModel(repository)
        viewModel.getUsers()
        // Call the function that uses the repository to get the users

        testDispatcher.scheduler.advanceUntilIdle()


        // Check that the users state flow contains the expected result
        val usersView = viewModel.users.value
        Assert.assertEquals(2, usersView.size)
    }

}