package com.example.medicalcontrolapp.domain.model

data class Appointment(
    val id: Int = 0,
    val codigoDoctor: String,
    val nombrePaciente: String,
    val dniPaciente: String,
    val fechaAtencion: String,
    val hora: String,
    val costo: Double,
    val observaciones: String
)