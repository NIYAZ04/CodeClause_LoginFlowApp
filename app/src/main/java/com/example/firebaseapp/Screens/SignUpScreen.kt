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
import com.example.firebaseapp.R
import com.example.firebaseapp.app.data.SignupViewModel
import com.example.firebaseapp.app.data.SignupUIEvent
import com.example.firebaseapp.components.ButtonComponent
import com.example.firebaseapp.components.CheckboxComponent
import com.example.firebaseapp.components.ClickableLoginTextComponent
import com.example.firebaseapp.components.DividerTextComponent
import com.example.firebaseapp.components.HeadingTextComponent
import com.example.firebaseapp.components.MyTextField
import com.example.firebaseapp.components.NormalTextComponent
import com.example.firebaseapp.components.PasswordTextField
import com.example.firebaseapp.navigation.FirebaseFirstRouter
import com.example.firebaseapp.navigation.Screen


@Composable
fun SignUpScreen(signupViewModel: SignupViewModel= viewModel()){


    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )

    {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
                .background(Color.White),

            )
        {
            Column(modifier=Modifier.fillMaxSize()) {
                NormalTextComponent(value = stringResource(id = R.string.hello))
                HeadingTextComponent(value = stringResource(id = R.string.Creat_Account))
                Spacer(modifier = Modifier.height(20.dp))

                MyTextField(labelValue = stringResource(id = R.string.first_name),
                    painterResource(id = R.drawable.profile),
                    onTextSelected = {
                        signupViewModel.onEvent(SignupUIEvent.FirstNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.firstNameError
                )

                //Another Component


                MyTextField(
                    labelValue = stringResource(id = R.string.last_name),
                    painterResource = painterResource(id = R.drawable.profile),
                    onTextSelected = {
                        signupViewModel.onEvent(SignupUIEvent.LastNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.lastNameError
                )


                //Another Component


                MyTextField(
                    labelValue = stringResource(id = R.string.email),
                    painterResource = painterResource(id = R.drawable.message),
                    onTextSelected = {
                        signupViewModel.onEvent(SignupUIEvent.EmailChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.emailError
                )


                //Another Component


                PasswordTextField(
                    labelValue = stringResource(id = R.string.password),
                    painterResource = painterResource(id = R.drawable.lock),
                    onTextSelected = {
                        signupViewModel.onEvent(SignupUIEvent.PasswordChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.passwordError

                )


                //Another Component

                CheckboxComponent(value = stringResource(id = R.string.terms_and_conditions),
                    onTextSelected ={
                        FirebaseFirstRouter.navigateTo(Screen.TermsAndConditionsScreen)
                    },
                    onCheckedChange = {
                        signupViewModel.onEvent(SignupUIEvent.PrivacyPolicyCheckBoxClicked(it))
                    }
                )

                Spacer(modifier = Modifier.height(80.dp))
                //Another Component

                ButtonComponent(value = stringResource(id = R.string.register),
                    onButtonClicked = {
                        signupViewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
                    },
                    isEnabled= signupViewModel.allValidationPassed.value

                )



                //Another Component


                DividerTextComponent()

                //Another Component
                ClickableLoginTextComponent(onTextSelected = {
                    FirebaseFirstRouter.navigateTo(Screen.LoginScreen)
                })
            }
        }
        if (signupViewModel.signUpInProgress.value){
            CircularProgressIndicator()
        }

    }


}
@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}