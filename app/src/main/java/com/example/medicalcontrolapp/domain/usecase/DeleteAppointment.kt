package com.example.medicalcontrolapp.domain.usecase

import com.example.medicalcontrolapp.domain.model.Appointment
import com.example.medicalcontrolapp.domain.repository.AppointmentRepository

class DeleteAppointment(
    private val repository: AppointmentRepository
) {
    suspend operator fun invoke(cita: Appointment) {
        repository.eliminar(cita)
    }
}