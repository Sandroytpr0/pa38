package com.example.medicalcontrolapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doctores")
data class DoctorEntity(

    @PrimaryKey
    val codigo: String,

    val nombres: String,

    val apellidos: String,

    val sexo: String,

    val fechaNacimiento: String,

    val especialidad: String

)