package com.example.medicalcontrolapp.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import com.example.medicalcontrolapp.data.entity.DoctorEntity
import com.example.medicalcontrolapp.data.entity.AppointmentEntity

@Database(
    entities = [DoctorEntity::class, AppointmentEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun doctorDao(): DoctorDao
    abstract fun appointmentDao(): AppointmentDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "medical_db"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}