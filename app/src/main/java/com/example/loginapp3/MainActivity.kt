package com.example.loginapp3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginapp3.screens.LoginLayout
import com.example.loginapp3.screens.WelcomeLayout
import com.example.loginapp3.ui.theme.LoginApp3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "login") {
                composable("login") {
                    LoginLayout(navController = navController)
                }
                composable(
                    "welcome/{nom}/{prenom}",
                ) { backStackEntry ->
                    val nom = backStackEntry.arguments?.getString("nom") ?: ""
                    val prenom = backStackEntry.arguments?.getString("prenom") ?: ""
                    WelcomeLayout(nom = nom, prenom = prenom, navController = navController)
                }
            }
        }
    }
}
