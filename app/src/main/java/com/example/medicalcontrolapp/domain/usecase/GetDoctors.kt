package com.example.medicalcontrolapp.domain.usecase

import com.example.medicalcontrolapp.domain.repository.DoctorRepository

class GetDoctors(
    private val repository: DoctorRepository
) {
    operator fun invoke() = repository.listar()
}