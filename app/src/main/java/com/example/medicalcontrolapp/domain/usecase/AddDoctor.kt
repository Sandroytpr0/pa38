package com.example.medicalcontrolapp.domain.usecase

import com.example.medicalcontrolapp.domain.model.Doctor
import com.example.medicalcontrolapp.domain.repository.DoctorRepository

class AddDoctor(
    private val repository: DoctorRepository
) {
    suspend operator fun invoke(doctor: Doctor) {
        repository.insertar(doctor)
    }
}