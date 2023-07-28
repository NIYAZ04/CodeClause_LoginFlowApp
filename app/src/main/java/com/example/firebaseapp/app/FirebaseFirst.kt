package com.example.firebaseapp.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.firebaseapp.Screens.HomeScreen
import com.example.firebaseapp.Screens.LoginScreen
import com.example.firebaseapp.Screens.SignUpScreen
import com.example.firebaseapp.Screens.TermsAndConditionsScreen
import com.example.firebaseapp.app.data.SignupViewModel
import com.example.firebaseapp.navigation.FirebaseFirstRouter
import com.example.firebaseapp.navigation.Screen


@Composable
fun FirebaseFirst() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        Crossfade(targetState = FirebaseFirstRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }
                is Screen.HomeScreen ->{
                    HomeScreen()
                }
            }
        }
    }}