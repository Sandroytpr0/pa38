package com.example.medicalcontrolapp.data.repository

import com.example.medicalcontrolapp.data.local.DoctorDao
import com.example.medicalcontrolapp.data.entity.DoctorEntity
import com.example.medicalcontrolapp.domain.model.Doctor
import com.example.medicalcontrolapp.domain.repository.DoctorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DoctorRepositoryImpl(
    private val dao: DoctorDao
) : DoctorRepository {

    override suspend fun insertar(doctor: Doctor) {
        dao.insertar(doctor.toEntity())
    }

    override suspend fun actualizar(doctor: Doctor) {
        dao.actualizar(doctor.toEntity())
    }

    override suspend fun eliminar(doctor: Doctor) {
        dao.eliminar(doctor.toEntity())
    }

    override fun listar(): Flow<List<Doctor>> {
        return dao.listar().map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun buscarPorCodigo(codigo: String): Doctor? {
        return dao.buscarPorCodigo(codigo)?.toDomain()
    }


    private fun Doctor.toEntity(): DoctorEntity {
        return DoctorEntity(
            codigo = codigo,
            nombres = nombres,
            apellidos = apellidos,
            sexo = sexo,
            fechaNacimiento = fechaNacimiento,
            especialidad = especialidad
        )
    }

    private fun DoctorEntity.toDomain(): Doctor {
        return Doctor(
            codigo = codigo,
            nombres = nombres,
            apellidos = apellidos,
            sexo = sexo,
            fechaNacimiento = fechaNacimiento,
            especialidad = especialidad
        )
    }
}