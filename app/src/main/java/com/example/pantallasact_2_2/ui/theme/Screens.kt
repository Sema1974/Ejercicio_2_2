package com.example.pantallasact_2_2.ui.theme

import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pantallasact_2_2.model.Routes.*


@Composable
fun Screen1(navigationController: NavController)
{
    Column(modifier = Modifier.fillMaxWidth()){
        Spacer(modifier = Modifier.size(100.dp))

        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = { Text("User Name") }
        )




        Button(onClick = { navigationController.navigate(Pantalla2.route)}){
            Text(text="Ir a Screen2")
        }
    }
}
@Composable
fun Screen2(navigationController: NavController)
{
    Column(modifier = Modifier.fillMaxWidth()){
        Spacer(modifier = Modifier.size(100.dp))
        Text(text = "Screen1")
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Magenta))
        Button(onClick = { navigationController.navigate(Pantalla3.route)}) {
            Text(text = "Ir a Screen3")
        }
        Button(onClick = { navigationController.navigateUp()}) {
            Text(text = "Volver")
        }
    }
}

@Composable
fun Screen5(navigationController: NavController, age:Int)
{
    Column(modifier = Modifier.fillMaxWidth()){
        Spacer(modifier = Modifier.size(100.dp))
        Text(text = "Edad = $age")
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Blue))
        Button(onClick = { navigationController.navigate(MainScreen.route)}) {
            Text(text = "Ir a Screen1")
        }
        Button(onClick = { navigationController.navigateUp()}) {
            Text(text = "Volver")
        }
    }
}

@Composable
fun Screen3(navigationController: NavController)
{
    Column(modifier = Modifier.fillMaxWidth()){
        Spacer(modifier = Modifier.size(100.dp))
        Text(text = "Screen1")
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow))
        Button(onClick = { navigationController.navigate(PantallaConArgOblligatorios.createRoute("Hola"))}) {
            Text(text = "Ir a Screen1")
        }
    }
}
@Composable
fun Screen4(navigationController: NavController, name:String)
{
    Column(modifier = Modifier.fillMaxWidth()){
        Spacer(modifier = Modifier.size(100.dp))
        Text(text = "Screen1")
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Green))
        Button(onClick = { navigationController.navigate(PantallaFinal.createRoute(25))}) {
            Text(text = "Ir a Screen5")
        }
        Button(onClick = { navigationController.navigateUp()}) {
            Text(text = "Volver")
        }
    }
}
