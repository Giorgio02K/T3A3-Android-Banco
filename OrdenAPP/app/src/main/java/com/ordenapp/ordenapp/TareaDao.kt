package com.ordenapp.ordenapp
import androidx.room.*

@Dao
interface TareaDao {
    @Insert
    suspend fun insertarTarea(tarea: Tarea)

    @Query("SELECT * FROM tareas")
    suspend fun obtenerTareas(): List<Tarea>

    @Delete
    suspend fun eliminarTarea(tarea: Tarea)

    @Update
    suspend fun actualizarTarea(tarea: Tarea)
}