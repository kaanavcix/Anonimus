package com.example.anonimus.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.anonimus.components.NormalTextComponent

@Composable
fun TermOfConditionScreenView(modifier: Modifier = Modifier) {

    Surface(modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        // Add your code here
        NormalTextComponent(value ="Terms of Conditions")



    }
}