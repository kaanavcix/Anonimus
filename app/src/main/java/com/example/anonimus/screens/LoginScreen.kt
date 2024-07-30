package com.example.anonimus.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.anonimus.components.ButtonComponent
import com.example.anonimus.components.ClickableTextComponent
import com.example.anonimus.components.HeadingTextComponent
import com.example.anonimus.components.HorizontalOrLine
import com.example.anonimus.components.NormalTextComponent
import com.example.anonimus.components.TextFieldComponent
import com.example.anonimus.extension.AutoSize


@Composable
fun LoginScreen(modifier: Modifier = Modifier) {


    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .background(Color.White)){
        // Add your code here
        Column (modifier = Modifier.fillMaxSize(),Arrangement.Top,Alignment.CenterHorizontally) {


            NormalTextComponent(value = "Hello")
            HeadingTextComponent(value = "Welcome Back")
            20.0.AutoSize()
            TextFieldComponent(
                labelValue = "E-mail",
                labelIcon = Icons.Rounded.Email,
                keyboardType = KeyboardType.Email,
                isPassword = false
            )
            10.0.AutoSize()
            TextFieldComponent(
                labelValue = "Password",
                labelIcon = Icons.Rounded.Lock,
                keyboardType = KeyboardType.Password,
                isPassword = true
            )
            20.0.AutoSize()
            ButtonComponent(onClick = { /*TODO*/ }, text = "Giriş Yap" )
            Spacer(modifier = Modifier.fillMaxSize(0.7f))
           HorizontalOrLine(text = " Or ")
10.0.AutoSize()
            ClickableTextComponent(isLogin = true)

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() {

    LoginScreen()
}