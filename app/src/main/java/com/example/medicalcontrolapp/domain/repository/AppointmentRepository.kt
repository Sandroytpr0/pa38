package com.example.medicalcontrolapp.domain.repository

import com.example.medicalcontrolapp.domain.model.Appointment
import kotlinx.coroutines.flow.Flow

interface AppointmentRepository {

    suspend fun insertar(cita: Appointment)

    suspend fun actualizar(cita: Appointment)

    suspend fun eliminar(cita: Appointment)

    fun listar(): Flow<List<Appointment>>

    fun buscarPorPaciente(nombre: String): Flow<List<Appointment>>

    suspend fun buscarPorId(id: Int): Appointment?
}