package com.example.medicalcontrolapp.presentation.appointment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medicalcontrolapp.domain.model.Appointment
import com.example.medicalcontrolapp.domain.usecase.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AppointmentViewModel(
    private val addAppointment: AddAppointment,
    private val updateAppointment: UpdateAppointment,
    private val deleteAppointment: DeleteAppointment,
    private val getAppointments: GetAppointments
) : ViewModel() {

    private val _appointments = MutableStateFlow<List<Appointment>>(emptyList())
    val appointments: StateFlow<List<Appointment>> = _appointments

    init {
        listar()
    }

    fun listar() {
        viewModelScope.launch {
            getAppointments().collect {
                _appointments.value = it
            }
        }
    }

    fun insertar(cita: Appointment) {
        viewModelScope.launch {
            addAppointment(cita)
        }
    }

    fun actualizar(cita: Appointment) {
        viewModelScope.launch {
            updateAppointment(cita)
        }
    }

    fun eliminar(cita: Appointment) {
        viewModelScope.launch {
            deleteAppointment(cita)
        }
    }
}