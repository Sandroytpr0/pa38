package com.example.medicalcontrolapp.domain.model

data class Doctor(
    val codigo: String,
    val nombres: String,
    val apellidos: String,
    val sexo: String,
    val fechaNacimiento: String,
    val especialidad: String
)