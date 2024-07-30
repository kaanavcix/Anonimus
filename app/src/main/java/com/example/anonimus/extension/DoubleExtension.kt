package com.example.anonimus.extension

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Double.AutoSize(): Unit {
    Spacer(modifier = Modifier.height(this.dp))
}
