package com.example.medicalcontrolapp.presentation.doctor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicalcontrolapp.domain.model.Doctor
import com.example.medicalcontrolapp.domain.usecase.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DoctorViewModel(
    private val addDoctor: AddDoctor,
    private val updateDoctor: UpdateDoctor,
    private val deleteDoctor: DeleteDoctor,
    private val getDoctors: GetDoctors
) : ViewModel() {

    private val _doctors = MutableStateFlow<List<Doctor>>(emptyList())
    val doctors: StateFlow<List<Doctor>> = _doctors

    init {
        listar()
    }

    fun listar() {
        viewModelScope.launch {
            getDoctors().collect {
                _doctors.value = it
            }
        }
    }

    fun insertar(doctor: Doctor) {
        viewModelScope.launch {
            addDoctor(doctor)
        }
    }

    fun actualizar(doctor: Doctor) {
        viewModelScope.launch {
            updateDoctor(doctor)
        }
    }

    fun eliminar(doctor: Doctor) {
        viewModelScope.launch {
            deleteDoctor(doctor)
        }
    }
}