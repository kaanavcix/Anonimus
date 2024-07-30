package com.example.anonimus.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material.icons.twotone.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anonimus.navigation.AnonimusAppRoute
import com.example.anonimus.navigation.Screen
import com.example.anonimus.theme.TextColor


@Composable

fun NormalTextComponent(value: String) {
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 20.dp),
        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal), color = TextColor, textAlign = TextAlign.Center,

        //style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(fontSize = 40.sp, fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal), color = TextColor, textAlign = TextAlign.Center
        //style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun TextFieldComponent(labelValue:String,labelIcon:ImageVector,keyboardType :androidx. compose. ui. text. input.KeyboardType,
                       isPassword:Boolean,) {

    val textValue :MutableState<String>  = remember { mutableStateOf("") }
    val passwordVisible =  remember { mutableStateOf(false) }
    OutlinedTextField(

        modifier = Modifier.fillMaxWidth(), value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(labelIcon , contentDescription = labelIcon.name)        } ,
        label = { Text(labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.Black.copy(alpha = 0.1f),

        ),

        keyboardActions = KeyboardActions.Default,
        keyboardOptions = KeyboardOptions(keyboardType =keyboardType,) ,

        shape = RoundedCornerShape(8.dp)

        , trailingIcon = {if(isPassword)  {
            val iconImageVector :ImageVector =  if(passwordVisible.value) Icons.TwoTone.Done else Icons.Rounded.Send
            IconButton(onClick = {
                passwordVisible.value = !passwordVisible.value
            },
            content = {
                Icon(iconImageVector , contentDescription = "Password")
            })
        }}
 , visualTransformation =  //! This for visibility of charachter

        if(isPassword) {
            if(passwordVisible.value) {
                androidx.compose.ui.text.input.VisualTransformation.None
            } else {
                androidx.compose.ui.text.input.PasswordVisualTransformation()
            }
        } else {
            androidx.compose.ui.text.input.VisualTransformation.None})
}


@Composable
fun CheckBoxComponents(modifier: Modifier = Modifier) {

    val checkedVal = remember {
        mutableStateOf(false)
    }

    Row (modifier = modifier
        .fillMaxWidth()
        .heightIn(56.dp),Arrangement.Start,Alignment.CenterVertically) {
        Checkbox(
            checked = checkedVal.value,
            onCheckedChange = { checkedVal.value = !checkedVal.value })
        ClickableTextComponent(isLogin = false)
    }
}

@Composable
fun ClickableTextComponent(modifier: Modifier = Modifier, isLogin : Boolean) {


    val initialText  = if(isLogin) "If you havent a account " else "By contiuning you accept our "
    val privaciyPoliciyText  =  if (isLogin) " Register " else "Privacy Policy"
    val andText = " and "
    val termsAndConditionsText = "Terms and Conditions"
    val annotatedString = androidx.compose.ui.text.buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            pushStringAnnotation(tag = "Privacy Policy", annotation = privaciyPoliciyText)
            append(privaciyPoliciyText)
        }
        if(isLogin) {
            return@buildAnnotatedString
        }
        append(andText)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            pushStringAnnotation(tag = "Terms and Conditions", annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }
    }
    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(tag = "Privacy Policy", start = offset, end = offset)
            .firstOrNull()?.let {
                // Handle privacy policy click
                if (isLogin){
                    AnonimusAppRoute.navigateTo(Screen.SignUpScreen)
                }else {
                           AnonimusAppRoute.navigateTo(Screen.TermsOfConditionsScreen)
            }}
        annotatedString.getStringAnnotations(tag = "Terms and Conditions", start = offset, end = offset)
            .firstOrNull()?.let {
                // Handle terms and conditions click
                AnonimusAppRoute.navigateTo(Screen.TermsOfConditionsScreen)

            }
    })
        
    }


@Composable
fun ButtonComponent(modifier: Modifier = Modifier, onClick: () -> Unit,text:String) {

    Button(onClick = onClick,modifier = modifier
        .fillMaxWidth(), contentPadding = PaddingValues(16.dp),
        shape = RoundedCornerShape(8.dp)) {

        Text(text = text, style =  TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ))


    }
/*
        Box(modifier = Modifier.fillMaxWidth().height(50.dp) .background(brush = Brush.linearGradient(
            colors = listOf(Color.Blue, Color.Cyan),
            start = Offset.Zero,


        )), contentAlignment = Alignment.Center){




            Text(text = "Sign Up", textAlign = TextAlign.Center, style = TextStyle(
                fontSize = 16.sp, fontWeight = FontWeight.Bold
            ))
        }




    }

 */

}

@Composable
fun HorizontalOrLine(modifier: Modifier = Modifier, text: String) {
    Row(modifier = modifier
        .fillMaxWidth()
        .height(20.dp), verticalAlignment =  Alignment.CenterVertically) {
        HorizontalDivider(
            color = Color.Gray,
            thickness = 1.dp,
modifier = Modifier.fillMaxWidth(0.5f)

        )


            Text(text = " "+text+" ", color = Color.Black,
                style = TextStyle(fontSize = 12.sp, fontStyle = FontStyle.Italic,))



        HorizontalDivider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth(1f)

        )


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AppComponentTestPreview() {

    //HorizontalOrLine(text = "Or")
    ButtonComponent(Modifier, onClick = {},text = "Sign Up")
    
}


