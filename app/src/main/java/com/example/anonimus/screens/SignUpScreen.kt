package com.example.anonimus.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.sharp.Lock
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.anonimus.R
import com.example.anonimus.components.ButtonComponent
import com.example.anonimus.components.CheckBoxComponents
import com.example.anonimus.components.HeadingTextComponent
import com.example.anonimus.components.NormalTextComponent
import com.example.anonimus.components.TextFieldComponent
import com.example.anonimus.extension.AutoSize


@Composable
fun SignUpScreenView() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), color = Color.White
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(R.string.introduce_login_text))
            HeadingTextComponent(value = stringResource(R.string.create_an_account))

            TextFieldComponent(
                labelValue = "Your name",
                labelIcon = Icons.Filled.Person,
                keyboardType = KeyboardType.Text,
                false
            )
            20.0.AutoSize()
            TextFieldComponent(
                labelValue = "Your Surnname",
                labelIcon = Icons.Filled.Person,
                keyboardType = KeyboardType.Text,
                false
            )
            20.0.AutoSize()
            TextFieldComponent(
                labelValue = "Your Email",
                labelIcon = Icons.Filled.Email,
                keyboardType = KeyboardType.Text,
                false
            )
            20.0.AutoSize()
            TextFieldComponent(
                labelValue = "Your Password",
                labelIcon = Icons.Sharp.Lock,
                keyboardType = KeyboardType.Text,
                true
            )
            10.0.AutoSize()
            CheckBoxComponents()
            10.0.AutoSize()
            ButtonComponent(onClick = { /*TODO*/ }, text = stringResource(R.string.sign_up_text) )


        }
    }
}    //  NormalTextComponent(value = stringResource(R.string.introduce_login_text))
//HeadingTextComponent(value = stringResource(R.string.create_an_account))





@Preview(showBackground = true, showSystemUi = true)
@Composable
 fun DefaultPreviewOfSignUpScreen( ) {
   SignUpScreenView()
}