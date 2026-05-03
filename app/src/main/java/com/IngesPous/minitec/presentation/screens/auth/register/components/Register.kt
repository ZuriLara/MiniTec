package com.IngesPous.minitec.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.IngesPous.minitec.domain.util.Resource
import com.IngesPous.minitec.presentation.components.ProgressBar
import com.IngesPous.minitec.presentation.navigation.screen.AuthScreen
import com.IngesPous.minitec.presentation.screens.auth.register.RegisterMiniTec

@Composable
fun Register(navController: NavHostController, vm: RegisterMiniTec = hiltViewModel()){
    when(val response = vm.registerResponse ) {
        Resource.Loading -> { ProgressBar() }
        is Resource.Success -> {
            navController.navigate(route = AuthScreen.Home.route)
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