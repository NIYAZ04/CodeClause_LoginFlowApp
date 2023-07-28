package com.example.firebaseapp.Screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firebaseapp.LoginViewModel
import com.example.firebaseapp.R
import com.example.firebaseapp.app.data.LoginUIEvent
import com.example.firebaseapp.components.ButtonComponent
import com.example.firebaseapp.components.ClickableLoginTextComponent
import com.example.firebaseapp.components.DividerTextComponent
import com.example.firebaseapp.components.HeadingTextComponent
import com.example.firebaseapp.components.MyTextField
import com.example.firebaseapp.components.NormalTextComponent
import com.example.firebaseapp.components.PasswordTextField
import com.example.firebaseapp.components.UnderLinedNormalTextComponent
import com.example.firebaseapp.navigation.FirebaseFirstRouter
import com.example.firebaseapp.navigation.Screen
import com.example.firebaseapp.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()){

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Surface(
            modifier= Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(18.dp)

        ) {

            Column(
                modifier= Modifier
                    .fillMaxSize()
            ) {
                NormalTextComponent(value = stringResource(id = R.string.login))
                HeadingTextComponent(value = stringResource(id = R.string.Welcome_Back))

                Spacer(modifier = Modifier.height(20.dp))

                MyTextField(labelValue = stringResource(id = R.string.email) ,
                    painterResource = painterResource(
                        id = R.drawable.message),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )
// for Password
                PasswordTextField(labelValue = stringResource(id = R.string.password) ,
                    painterResource = painterResource(
                        id = R.drawable.lock),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )

                Spacer(modifier = Modifier.height(40.dp))

                UnderLinedNormalTextComponent(value = stringResource(id = R.string.forgot_password))

                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(value = stringResource(id = R.string.login),
                    onButtonClicked = {
loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()


                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    FirebaseFirstRouter.navigateTo(Screen.SignUpScreen)
                })

            }

        }
        if(loginViewModel.loginInProgress.value){
            CircularProgressIndicator()
        }

    }




    SystemBackButtonHandler {
        FirebaseFirstRouter.navigateTo(Screen.SignUpScreen)
    }
}
@Preview
@Composable
fun LoginScreenPreview()
{
    LoginScreen()
}