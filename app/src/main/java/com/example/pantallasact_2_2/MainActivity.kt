package com.example.pantallasact_2_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pantallasact_2_2.model.Routes.*
import com.example.pantallasact_2_2.ui.theme.PantallasAct_2_2Theme
import com.example.pantallasact_2_2.ui.theme.*


class MainActivity : ComponentActivity() {
    var text by rememberSaveable { mutableStateOf("Text") }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallasAct_2_2Theme {
                val navigationController = rememberNavController()
                NavHost(navController = navigationController,
                    startDestination = MainScreen.route) {
                    composable(MainScreen.route) { Screen1(navigationController) }
                    composable(Pantalla2.route) { Screen2(navigationController) }
                    composable(Pantalla3.route) { Screen3(navigationController) }
                    composable(
                        PantallaConArgOblligatorios.route,
                        arguments = listOf(navArgument("name") { type = NavType.StringType })
                    ) {
                        Screen4(
                            navigationController,
                            it.arguments?.getString("name").orEmpty()
                        )
                    }
                    composable(
                        PantallaFinal.route,
                        arguments = listOf(navArgument("age") { defaultValue = 25 })
                    ) {
                        Screen5(
                            navigationController,
                            it.arguments?.getInt("age")?:0
                        )
                    }
                }
            }
        }
    }
}

