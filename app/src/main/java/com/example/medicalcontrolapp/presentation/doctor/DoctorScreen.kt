package com.example.medicalcontrolapp.presentation.doctor

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medicalcontrolapp.domain.model.Doctor

@Composable
fun DoctorScreen(
    viewModel: DoctorViewModel
) {

    val doctors by viewModel.doctors.collectAsState()

    var codigo by remember { mutableStateOf("") }
    var nombres by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var especialidad by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Registro de Doctores", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = codigo, onValueChange = { codigo = it }, label = { Text("Código") })
        OutlinedTextField(value = nombres, onValueChange = { nombres = it }, label = { Text("Nombres") })
        OutlinedTextField(value = apellidos, onValueChange = { apellidos = it }, label = { Text("Apellidos") })
        OutlinedTextField(value = sexo, onValueChange = { sexo = it }, label = { Text("Sexo") })
        OutlinedTextField(value = fecha, onValueChange = { fecha = it }, label = { Text("Fecha Nacimiento") })
        OutlinedTextField(value = especialidad, onValueChange = { especialidad = it }, label = { Text("Especialidad") })

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                viewModel.insertar(
                    Doctor(
                        codigo, nombres, apellidos, sexo, fecha, especialidad
                    )
                )
            }
        ) {
            Text("Guardar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Lista de Doctores", style = MaterialTheme.typography.titleMedium)

        LazyColumn {
            items(doctors) { doctor ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text("Código: ${doctor.codigo}")
                        Text("Nombre: ${doctor.nombres} ${doctor.apellidos}")
                        Text("Especialidad: ${doctor.especialidad}")

                        Row {
                            Button(onClick = { viewModel.eliminar(doctor) }) {
                                Text("Eliminar")
                            }
                        }
                    }
                }
            }
        }
    }
}