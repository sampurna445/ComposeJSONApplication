package com.example.composejsonapplication.ui.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composejsonapplication.ui.Navigation.NavigationItem
import com.example.composejsonapplication.ui.theme.ComposeJSONApplicationTheme
import com.example.composejsonapplication.ui.theme.LoginButtons


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
