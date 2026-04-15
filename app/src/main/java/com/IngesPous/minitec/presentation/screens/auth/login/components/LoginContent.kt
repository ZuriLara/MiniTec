package com.IngesPous.minitec.presentation.screens.auth.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.navigation.NavHostController
import com.IngesPous.minitec.R
import com.IngesPous.minitec.presentation.components.DefaultButton
import com.IngesPous.minitec.presentation.components.DefaultTextField
import com.IngesPous.minitec.presentation.navigation.screen.AuthScreen
import com.IngesPous.minitec.ui.theme.PrussianBlue

@Composable
fun LoginContent(navController: NavHostController, paddingValues: PaddingValues){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier  = Modifier.fillMaxSize(),
            painter = painterResource(id= R.drawable.banner),
            contentDescription = "Imagen de fondo",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply {
                    setToScale( 0.5f, 0.5f, 0.5f, 1f)
                }

            )
        )
        Column(
            modifier = Modifier.fillMaxWidth().padding(top=90.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                painter = painterResource(id= R.drawable.logo),
                contentDescription = "logo"
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                colors = CardDefaults.cardColors(
                    //Vuelve transparente el fondo de la tarjeta
                    containerColor = Color.White.copy(alpha = 0.7f)
                )

                ) {
                Column(
                    modifier = Modifier.padding(60.dp, 30.dp, 60.dp )
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "INICIAR SESION",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    //OutlinedTextField genera bordes en los campos
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Correo electronico",
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email


                    )
                    DefaultTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password


                    )
                    //Spacer(modifier = Modifier.height(10.dp))
                    //Genera un espacio entre un elemento y otro
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .padding(top = 15.dp),
                        text = "LOGIN",
                        onClick = { }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 17.dp),
                        horizontalArrangement = Arrangement.Center,

                        ) {
                        Text(text = "No tienes cuenta? ")
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            modifier = Modifier.clickable { navController.navigate(route = AuthScreen.Register.route) },
                            text = "Registrate",
                            color = PrussianBlue
                        )

                    }

                }

            }

        }
    }


}

