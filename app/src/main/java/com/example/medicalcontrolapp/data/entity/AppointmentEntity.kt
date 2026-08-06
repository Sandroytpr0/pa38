package com.example.medicalcontrolapp.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "citas",
    foreignKeys = [
        ForeignKey(
            entity = DoctorEntity::class,
            parentColumns = ["codigo"],
            childColumns = ["codigoDoctor"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class AppointmentEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val codigoDoctor: String,

    val nombrePaciente: String,

    val dniPaciente: String,

    val fechaAtencion: String,

    val hora: String,

    val costo: Double,

    val observaciones: String

)