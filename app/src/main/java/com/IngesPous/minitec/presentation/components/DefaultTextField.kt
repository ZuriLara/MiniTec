package com.IngesPous.minitec.presentation.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import com.IngesPous.minitec.ui.theme.PrussianBlue

@Composable
fun DefaultTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: ImageVector,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    TextField(
        modifier = modifier, // <--- CORRECCIÓN AQUÍ
        value = value,
        onValueChange = { text ->
            onValueChange(text)
        },
        label = {
            Text(text = label )
        },
        // trallingIcon izquierda
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "",
                tint = PrussianBlue
                //tint=Color.cyan (genera color en los iconos)
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)

        //colors = TextFieldDefaults.Colors(
        //    backgroundColor = Color.White
        // CAMBIA DE COLOR EL RECUADRO DE TEXTO


    )

}