package com.IngesPous.minitec.presentation.screens.auth.register.components

import android.R.attr.contentDescription
import android.R.attr.top
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.IngesPous.minitec.R
import com.IngesPous.minitec.presentation.components.DefaultButton
import com.IngesPous.minitec.presentation.components.DefaultTextField

@Composable
fun RegisterContent(paddingValues: PaddingValues){
    Box(modifier = Modifier
        .padding(paddingValues= paddingValues)
        .fillMaxSize()
    ){
        //imagen de fondo
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.chef),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale( 0.5f, 0.5f, 0.5f, 1f)
                }

            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .padding(top = 30.dp),

                painter = painterResource(id= R.drawable.user_image),
                contentDescription = ""
            )
            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "Ingresa tu informacion",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color=Color.White
            )
            Spacer(modifier = Modifier.weight(10f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topEnd = 50.dp,
                    topStart = 50.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.7f)
                )
            ) {
                Column(modifier = Modifier.padding(top = 30.dp, start = 30.dp, end = 30.dp, bottom = 30.dp)){
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "Registrate",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Nombre",
                        icon = Icons.Default.Person
                    )
                    Spacer(modifier = Modifier.height(5.dp)) // <--- ESTO DA EL "AIRE" QUE FALTA
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Apellidos",
                        icon = Icons.Outlined.Person
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Correo electronico",
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Matricula",
                        icon = Icons.Default.Badge,
                        keyboardType = KeyboardType.Number
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Confirmar contraseña",
                        icon = Icons.Outlined.Lock,
                        keyboardType = KeyboardType.Password
                    )
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .padding(top = 15.dp),
                        text = "CONTINUAR",
                        onClick = { }
                    )
                }
            } 
        }

    }
}