package com.example.medicalcontrolapp.domain.usecase

import com.example.medicalcontrolapp.domain.model.Appointment
import com.example.medicalcontrolapp.domain.repository.AppointmentRepository

class UpdateAppointment(
    private val repository: AppointmentRepository
) {
    suspend operator fun invoke(cita: Appointment) {
        repository.actualizar(cita)
    }
}