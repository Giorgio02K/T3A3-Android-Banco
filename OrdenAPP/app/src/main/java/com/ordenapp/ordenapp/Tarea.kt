package com.ordenapp.ordenapp
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tareas")
data class Tarea(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var titulo: String,
    val categoria: String,
    val frecuencia: String
)