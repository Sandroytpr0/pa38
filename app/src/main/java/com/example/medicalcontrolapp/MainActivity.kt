package com.example.medicalcontrolapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.example.medicalcontrolapp.data.local.AppDatabase
import com.example.medicalcontrolapp.data.repository.DoctorRepositoryImpl
import com.example.medicalcontrolapp.data.repository.AppointmentRepositoryImpl
import com.example.medicalcontrolapp.domain.usecase.*
import com.example.medicalcontrolapp.presentation.doctor.DoctorViewModel
import com.example.medicalcontrolapp.presentation.appointment.AppointmentViewModel
import com.example.medicalcontrolapp.presentation.navigation.NavGraph
import com.example.medicalcontrolapp.ui.theme.MedicalControlAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "medical_db"
        ).build()

        val doctorRepository = DoctorRepositoryImpl(db.doctorDao())
        val appointmentRepository = AppointmentRepositoryImpl(db.appointmentDao())

        val doctorViewModel = DoctorViewModel(
            AddDoctor(doctorRepository),
            UpdateDoctor(doctorRepository),
            DeleteDoctor(doctorRepository),
            GetDoctors(doctorRepository)
        )

        val appointmentViewModel = AppointmentViewModel(
            AddAppointment(appointmentRepository),
            UpdateAppointment(appointmentRepository),
            DeleteAppointment(appointmentRepository),
            GetAppointments(appointmentRepository)
        )

        enableEdgeToEdge()

        setContent {
            MedicalControlAppTheme {
                NavGraph(
                    doctorViewModel = doctorViewModel,
                    appointmentViewModel = appointmentViewModel
                )
            }
        }
    }
}