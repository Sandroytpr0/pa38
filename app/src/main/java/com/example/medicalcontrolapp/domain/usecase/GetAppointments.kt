package com.example.medicalcontrolapp.domain.usecase

import com.example.medicalcontrolapp.domain.repository.AppointmentRepository

class GetAppointments(
    private val repository: AppointmentRepository
) {
    operator fun invoke() = repository.listar()
}