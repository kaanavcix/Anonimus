package com.example.anonimus.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


sealed  class Screen() {

    object TermsOfConditionsScreen: Screen()
    object SignUpScreen: Screen()
    object  LoginScreen: Screen()


}


object AnonimusAppRoute {

    val currentScreen: MutableState<Screen>   = mutableStateOf(Screen.LoginScreen)

    fun navigateTo(screen: Screen) {
        currentScreen.value = screen
    }

}