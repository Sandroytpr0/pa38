package com.example.medicalcontrolapp.data.repository

import com.example.medicalcontrolapp.data.local.AppointmentDao
import com.example.medicalcontrolapp.data.entity.AppointmentEntity
import com.example.medicalcontrolapp.domain.model.Appointment
import com.example.medicalcontrolapp.domain.repository.AppointmentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppointmentRepositoryImpl(
    private val dao: AppointmentDao
) : AppointmentRepository {

    override suspend fun insertar(cita: Appointment) {
        dao.insertar(cita.toEntity())
    }

    override suspend fun actualizar(cita: Appointment) {
        dao.actualizar(cita.toEntity())
    }

    override suspend fun eliminar(cita: Appointment) {
        dao.eliminar(cita.toEntity())
    }

    override fun listar(): Flow<List<Appointment>> {
        return dao.listar().map { list ->
            list.map { it.toDomain() }
        }
    }

    override fun buscarPorPaciente(nombre: String): Flow<List<Appointment>> {
        return dao.buscarPorPaciente(nombre).map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun buscarPorId(id: Int): Appointment? {
        return dao.buscarPorId(id)?.toDomain()
    }


    private fun Appointment.toEntity(): AppointmentEntity {
        return AppointmentEntity(
            id = id,
            codigoDoctor = codigoDoctor,
            nombrePaciente = nombrePaciente,
            dniPaciente = dniPaciente,
            fechaAtencion = fechaAtencion,
            hora = hora,
            costo = costo,
            observaciones = observaciones
        )
    }

    private fun AppointmentEntity.toDomain(): Appointment {
        return Appointment(
            id = id,
            codigoDoctor = codigoDoctor,
            nombrePaciente = nombrePaciente,
            dniPaciente = dniPaciente,
            fechaAtencion = fechaAtencion,
            hora = hora,
            costo = costo,
            observaciones = observaciones
        )
    }
}