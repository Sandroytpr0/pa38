package com.example.medicalcontrolapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medicalcontrolapp.presentation.doctor.DoctorScreen
import com.example.medicalcontrolapp.presentation.appointment.AppointmentScreen

@Composable
fun NavGraph(
    doctorViewModel: com.example.medicalcontrolapp.presentation.doctor.DoctorViewModel,
    appointmentViewModel: com.example.medicalcontrolapp.presentation.appointment.AppointmentViewModel
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "menu"
    ) {

        composable("menu") {
            MenuScreen(
                onDoctorsClick = { navController.navigate("doctors") },
                onAppointmentsClick = { navController.navigate("appointments") }
            )
        }

        composable("doctors") {
            DoctorScreen(viewModel = doctorViewModel)
        }

        composable("appointments") {
            AppointmentScreen(viewModel = appointmentViewModel)
        }
    }
}