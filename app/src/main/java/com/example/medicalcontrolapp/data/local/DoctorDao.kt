package com.example.medicalcontrolapp.data.local

import androidx.room.*
import com.example.medicalcontrolapp.data.entity.DoctorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DoctorDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertar(doctor: DoctorEntity)

    @Update
    suspend fun actualizar(doctor: DoctorEntity)

    @Delete
    suspend fun eliminar(doctor: DoctorEntity)

    @Query("SELECT * FROM doctores ORDER BY nombres ASC")
    fun listar(): Flow<List<DoctorEntity>>

    @Query("SELECT * FROM doctores WHERE codigo = :codigo")
    suspend fun buscarPorCodigo(codigo: String): DoctorEntity?
}
