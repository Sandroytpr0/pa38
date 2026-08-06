package com.example.medicalcontrolapp.presentation.appointment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medicalcontrolapp.domain.model.Appointment

@Composable
fun AppointmentScreen(
    viewModel: AppointmentViewModel
) {

    val list by viewModel.appointments.collectAsState()

    var codigoDoctor by remember { mutableStateOf("") }
    var paciente by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }
    var costo by remember { mutableStateOf("") }
    var obs by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Registro de Citas", style = MaterialTheme.typography.titleLarge)

        OutlinedTextField(value = codigoDoctor, onValueChange = { codigoDoctor = it }, label = { Text("Código Doctor") })
        OutlinedTextField(value = paciente, onValueChange = { paciente = it }, label = { Text("Paciente") })
        OutlinedTextField(value = dni, onValueChange = { dni = it }, label = { Text("DNI") })
        OutlinedTextField(value = fecha, onValueChange = { fecha = it }, label = { Text("Fecha") })
        OutlinedTextField(value = hora, onValueChange = { hora = it }, label = { Text("Hora") })
        OutlinedTextField(value = costo, onValueChange = { costo = it }, label = { Text("Costo") })
        OutlinedTextField(value = obs, onValueChange = { obs = it }, label = { Text("Observaciones") })

        Button(
            onClick = {
                viewModel.insertar(
                    Appointment(
                        codigoDoctor = codigoDoctor,
                        nombrePaciente = paciente,
                        dniPaciente = dni,
                        fechaAtencion = fecha,
                        hora = hora,
                        costo = costo.toDoubleOrNull() ?: 0.0,
                        observaciones = obs
                    )
                )
            }
        ) {
            Text("Guardar Cita")
        }

        LazyColumn {
            items(list) { cita ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text("Paciente: ${cita.nombrePaciente}")
                        Text("Fecha: ${cita.fechaAtencion}")
                        Text("Costo: ${cita.costo}")

                        Button(onClick = { viewModel.eliminar(cita) }) {
                            Text("Eliminar")
                        }
                    }
                }
            }
        }
    }
}