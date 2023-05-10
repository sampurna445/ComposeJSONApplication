package com.example.composejsonapplication.ui.login

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composejsonapplication.R
import com.example.composejsonapplication.ui.Navigation.NavigationItem
import com.example.composejsonapplication.ui.theme.ComposeJSONApplicationTheme
import com.example.composejsonapplication.ui.theme.LoginButtons
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),


    )
{
   ComposeJSONApplicationTheme {
       //getting current context
       val currentContext = LocalContext.current

       val navigateToSignUp: () -> Unit = {
           navController.navigate(NavigationItem.SignUpScreen.route)
       }

       //Google signin
       val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
           .requestEmail()
           .requestProfile()
           .build()

       val googleSignInLauncher = rememberLauncherForActivityResult(
           ActivityResultContracts.StartActivityForResult()
       ) { result ->
           if (result.resultCode == Activity.RESULT_OK) {
               val intent = result.data
               val task = GoogleSignIn.getSignedInAccountFromIntent(intent)
               try {
                   // Handle successful sign-in
                   val account = task.getResult(ApiException::class.java)
                   navController.navigate(NavigationItem.Posts.route)
                   // ...
               } catch (e: ApiException) {
                   // Handle failed sign-in
                   // ...
               }
           }
       }

       val googleSignInClient = remember {
           GoogleSignIn.getClient(currentContext, googleSignInOptions)
       }

       val signInIntent = googleSignInClient.signInIntent


       /*//facebook initialize

       val callbackManager = remember { CallbackManager.Factory.create() }
       //val context = LocalContext.current

       val facebookCallback = remember {
           object : FacebookCallback<LoginResult> {

               override fun onCancel() {}
               override fun onError(error: FacebookException) {
                   TODO("Not yet implemented")
               }

               override fun onSuccess(result: LoginResult) {
                   //onLoginSuccess()
                   navController.navigate(NavigationItem.Posts.route)
               }


           }
       }

       LaunchedEffect(callbackManager) {
           LoginManager.getInstance().registerCallback(callbackManager, facebookCallback)
       }
*/


       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(16.dp),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       ) {
           Text(
               text = "Login Page",
               fontSize = 24.sp,
               fontWeight = FontWeight.Bold
           )
           Spacer(modifier = Modifier.height(16.dp))
           OutlinedTextField(
               value = viewModel.email.value,
               onValueChange = { newValue ->
                   viewModel.email.value = newValue
                   viewModel.validateEmail()
               },
               isError = viewModel.isEmailValid.value,
               label = { Text(text = "Username") },

               )
           Spacer(modifier = Modifier.height(16.dp))

           var passwordVisibility by remember { mutableStateOf(false) }

           OutlinedTextField(
               value = viewModel.password.value,
               onValueChange = { newValue ->
                   viewModel.password.value = newValue
                   viewModel.validatePassword()
               },
               isError = viewModel.isPasswordValid.value,
               label = { Text(text = "Password") },
               visualTransformation = if (passwordVisibility) VisualTransformation.None
               else PasswordVisualTransformation(),
               modifier = Modifier.fillMaxWidth(),
               keyboardOptions = KeyboardOptions.Default.copy(
                   keyboardType = KeyboardType.Password,
               )
           )
           Spacer(modifier = Modifier.height(16.dp))
           Spacer(modifier = Modifier.height(16.dp))
           Row(
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.Center
           ) {
               DefaultButton(
                   text = "Log In",
                   onClick = {
                       viewModel.login()

                       if (viewModel.isLoginSuccess.value) {

                           Toast.makeText(
                               currentContext,
                               "${viewModel.email.value} : Login Success",
                               Toast.LENGTH_SHORT
                           ).show()
                           navController.navigate(NavigationItem.Posts.route)
                       }
                   })
               Spacer(modifier = Modifier.width(16.dp))
               DefaultButton(
                   text = "Register",
                   onClick = navigateToSignUp
               )

           }
           Spacer(modifier = Modifier.width(16.dp))
           Spacer(modifier = Modifier.width(16.dp))
           Spacer(modifier = Modifier.width(16.dp))
           Row(
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.Center
           ) {
/*               IconButton(
                   onClick = {
                       LoginManager.getInstance().logInWithReadPermissions(
                           currentContext as Activity,
                           listOf("public_profile", "email")
                       )
                   },
                   modifier = Modifier.size(48.dp)
               ) {
                   Image(
                       painter = painterResource(id = R.drawable.ic_facebook),
                       contentDescription = "Sign in with Facebook"
                   )
               }*/
               Spacer(modifier = Modifier.width(16.dp))
               IconButton(
                   onClick = { googleSignInLauncher.launch(signInIntent) },
                   modifier = Modifier.size(48.dp)
               ) {
                   Image(
                       painter = painterResource(id = R.drawable.ic_google),
                       contentDescription = "Sign in with Google"
                   )
               }
           }
       }
   }
}

@Composable
fun DefaultButton(
    text: String,
    onClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(5.dp))
    Button(
        onClick =  onClick,
        Modifier.background(color = LoginButtons)
    ){
            Text(text = text)
    }
}
/*
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LoginScreen(
                navigateToPosts = {}
            )
        }

}
*/
