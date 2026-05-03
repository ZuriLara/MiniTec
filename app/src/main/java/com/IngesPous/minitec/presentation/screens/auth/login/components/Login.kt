package com.IngesPous.minitec.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.IngesPous.minitec.domain.util.Resource
import com.IngesPous.minitec.presentation.navigation.screen.AuthScreen
import com.IngesPous.minitec.presentation.screens.auth.login.LoginMinitec

@Composable
fun Login(navController: NavHostController, vm: LoginMinitec = hiltViewModel()) {
    when(val response = vm.loginResponse){
        is Resource.Loading -> {
            Box(Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is Resource.Success -> {
            LaunchedEffect(Unit){
                navController.navigate(route = AuthScreen.Home.route)
            }

        }

        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }

        else -> {
            if (response != null){
                Toast.makeText(LocalContext.current, "Hubo un error desconocido", Toast.LENGTH_SHORT).show()

            }
        }
    }

}