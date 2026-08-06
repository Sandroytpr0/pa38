package com.example.medicalcontrolapp.domain.repository

import com.example.medicalcontrolapp.domain.model.Doctor
import kotlinx.coroutines.flow.Flow

interface DoctorRepository {

    suspend fun insertar(doctor: Doctor)

    suspend fun actualizar(doctor: Doctor)

    suspend fun eliminar(doctor: Doctor)

    fun listar(): Flow<List<Doctor>>

    suspend fun buscarPorCodigo(codigo: String): Doctor?
}