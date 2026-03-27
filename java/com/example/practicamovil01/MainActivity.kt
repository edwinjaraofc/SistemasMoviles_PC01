package com.example.practicamovil01

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaPrincipal(this)
        }
    }
}

// Revisa si el año es bisiesto
fun esBisiesto(year: Int): Boolean {
    if (year % 4 == 0 && year % 100 != 0) return true
    if (year % 400 == 0) return true
    return false
}

@Composable
fun PantallaPrincipal(contexto: android.content.Context) {
    var resultado by remember { mutableStateOf("") }
    
    val hoy = LocalDate.now()
    val year = hoy.year

    // Centra el contenido en la pantalla
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Boton negro
        Button(
            onClick = {
                val bisiesto = esBisiesto(year)
                val mensaje = if (bisiesto) "es bisiesto" else "no es bisiesto"
                resultado = "Fecha: $hoy. El año $year $mensaje."
                
                // Notificacion
                Toast.makeText(contexto, resultado, Toast.LENGTH_SHORT).show()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text("Verificador Bisiesto")
        }
        
        // Texto
        Text(resultado)
    }
}
