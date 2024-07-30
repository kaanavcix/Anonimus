package com.example.anonimus.app

import androidx.compose.animation.Crossfade
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.anonimus.navigation.AnonimusAppRoute
import com.example.anonimus.navigation.Screen
import com.example.anonimus.screens.LoginScreen
import com.example.anonimus.screens.SignUpScreenView
import com.example.anonimus.screens.TermOfConditionScreenView

@Composable
fun AnonimusApp() {

    Surface (modifier = Modifier,
        ) {


        Crossfade(targetState = AnonimusAppRoute.currentScreen.value) {
            when(it) {
                is Screen.TermsOfConditionsScreen -> {
                    // Add your code here
                    TermOfConditionScreenView()
                }
                is Screen.SignUpScreen -> {
                    // Add your code here
                    SignUpScreenView()
                }
                is Screen.LoginScreen -> {
                    // Add your code here
                    LoginScreen()
                }
            }

        }


    }
}