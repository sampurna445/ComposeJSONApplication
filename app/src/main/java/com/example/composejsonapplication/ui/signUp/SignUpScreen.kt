package com.example.composejsonapplication.ui.signUp

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composejsonapplication.ui.Navigation.NavigationItem
import com.example.composejsonapplication.ui.theme.ComposeJSONApplicationTheme

@Composable
fun SignUpScreen(navController: NavController
) {
    val viewModel: SignUpViewModel = viewModel()
    ComposeJSONApplicationTheme {

        //get current context
        val context = LocalContext.current

        val navigateToLogin: () -> Unit = {
            navController.navigate(NavigationItem.LoginScreen.route)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Create an account",
                style = MaterialTheme.typography.h4
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = viewModel.userName.value,
                onValueChange = { newValue ->
                    viewModel.userName.value = newValue
                    viewModel.validateUserName()
                },
                isError = viewModel.isUserNameValid.value,
                label = { Text(text = "User Name") },
                modifier = Modifier.fillMaxWidth()

            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = viewModel.userNameErrMsg.value,
                fontSize = 14.sp,
                color = Color.Red
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = viewModel.email.value,
                onValueChange = { newValue ->
                    viewModel.email.value = newValue
                    viewModel.validateEmail()
                },
                isError = viewModel.isEmailValid.value,
                label = { Text(text = "Email address") },
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = viewModel.emailErrMsg.value,
                fontSize = 14.sp,
                color = Color.Red
            )
            Spacer(modifier = Modifier.height(8.dp))

            var passwordVisibility by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = viewModel.password.value,
                onValueChange = { newValue ->
                    viewModel.password.value = newValue
                    viewModel.validatePassword()
                },
                isError = viewModel.isPasswordValid.value,
                label = { Text(text = "Password") },
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val visibilityIcon =
                        if (passwordVisibility) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            imageVector = visibilityIcon,
                            contentDescription = "Toggle password visibility"
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = viewModel.passwordErrMsg.value,
                fontSize = 14.sp,
                color = Color.Red
            )
            Spacer(modifier = Modifier.height(8.dp))

            var confirmPasswordVisibility by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = viewModel.confirmPassword.value,
                onValueChange = { newValue ->
                    viewModel.confirmPassword.value = newValue
                    viewModel.validateConfirmPassword()
                },
                isError = viewModel.isConfirmPasswordValid.value,
                label = { Text(text = "Confirm password") },
                visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val visibilityIcon =
                        if (confirmPasswordVisibility) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                    IconButton(onClick = { confirmPasswordVisibility = !confirmPasswordVisibility }) {
                        Icon(
                            imageVector = visibilityIcon,
                            contentDescription = "Toggle password visibility"
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = viewModel.confPasswordErrMsg.value,
                fontSize = 14.sp,
                color = Color.Red
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    viewModel.SignUp()
                    if (viewModel.isSignUpSuccess.value) {
                        Toast.makeText(
                            context,
                            "${viewModel.userName.value} : SignUp Success , Please Login ",
                            Toast.LENGTH_SHORT
                        ).show()
                        navController.navigate(NavigationItem.LoginScreen.route)
                    }

                },

                modifier = Modifier.fillMaxWidth(),
                enabled = viewModel.isEnabledRegisterButton.value
            ) {
                Text(text = "Sign up")
            }
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = viewModel.signUpErrorMessage.value,
                fontSize = 14.sp,
                color = Color.Red
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextButton(
                onClick = {
                    navigateToLogin()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Already have an account? Sign in",
                    color = Color.Blue
                )
            }

        }
    }
}
