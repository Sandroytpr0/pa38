package com.example.medicalcontrolapp.domain.usecase

import com.example.medicalcontrolapp.domain.model.Appointment
import com.example.medicalcontrolapp.domain.repository.AppointmentRepository

class AddAppointment(
    private val repository: AppointmentRepository
) {
    suspend operator fun invoke(cita: Appointment) {
        repository.insertar(cita)
    }
}