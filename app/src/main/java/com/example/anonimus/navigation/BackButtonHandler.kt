package com.example.anonimus.navigation

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.staticCompositionLocalOf


private val LocalBackDispatcher = staticCompositionLocalOf<OnBackPressedDispatcherOwner?> {
    null
}
private class ComposableBackDispatcherHandler(enabled:Boolean):OnBackPressedCallback(enabled) {

    lateinit var onBackPressed:()->Unit

    override fun handleOnBackPressed() {
        onBackPressed()
    }
}
