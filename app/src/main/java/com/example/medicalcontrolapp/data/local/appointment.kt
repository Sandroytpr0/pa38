package com.example.medicalcontrolapp.data.local

import androidx.room.*
import com.example.medicalcontrolapp.data.entity.AppointmentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppointmentDao {

    @Insert
    suspend fun insertar(cita: AppointmentEntity)

    @Update
    suspend fun actualizar(cita: AppointmentEntity)

    @Delete
    suspend fun eliminar(cita: AppointmentEntity)

    @Query("SELECT * FROM citas ORDER BY fechaAtencion DESC")
    fun listar(): Flow<List<AppointmentEntity>>

    @Query("SELECT * FROM citas WHERE nombrePaciente LIKE '%' || :nombre || '%'")
    fun buscarPorPaciente(nombre: String): Flow<List<AppointmentEntity>>

    @Query("SELECT * FROM citas WHERE id = :id")
    suspend fun buscarPorId(id: Int): AppointmentEntity?
}