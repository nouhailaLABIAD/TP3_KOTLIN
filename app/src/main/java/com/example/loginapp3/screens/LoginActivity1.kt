package com.example.loginapp3.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.loginapp3.data.Person


val peopleList = listOf(
    Person("John", "Doe", "john", "password"),
    Person("Jane", "Doe", "jane", "password123"),
    Person("nouhaila", "labiad", "nouhailalab", "nouha")
)
@Composable
fun LoginLayout( navController: NavController) {
    var errorMessage by remember { mutableStateOf("") }

    var usernameInput by remember {
        mutableStateOf("")
    }
    var username = usernameInput.toString()
    var passwordInput by remember {
        mutableStateOf("")
    }
    var password=passwordInput
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "Login", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(40.dp))

        TextField(value = username, onValueChange = { usernameInput = it },
            label = { Text(text = "login")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            modifier = Modifier.width(350.dp),

        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = password, onValueChange = { passwordInput=it },
            label = { Text(text = "password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.width(350.dp),


            )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val user = peopleList.find { it.username == usernameInput && it.password == passwordInput }
            if (user != null) {
                navController.navigate("welcome/${user.firstName}/${user.lastName}")
            } else {
                errorMessage = "Username or password is incorrect."

            }
        },
            enabled = usernameInput.isNotBlank() && passwordInput.isNotBlank(),
                    modifier = Modifier.width(350.dp),

            ) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (errorMessage.isNotBlank()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

}
