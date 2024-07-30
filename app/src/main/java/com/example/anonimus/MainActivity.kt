package com.example.anonimus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.anonimus.app.AnonimusApp
import com.example.anonimus.theme.AnonimusTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnonimusTheme {
AnonimusApp()
            }
        }
    }
}

