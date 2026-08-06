package com.example.medicalcontrolapp.presentation.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MenuScreen(
    onDoctorsClick: () -> Unit,
    onAppointmentsClick: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Medical Control App", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = onDoctorsClick) {
            Text("Doctores")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = onAppointmentsClick) {
            Text("Citas Médicas")
        }
    }
}