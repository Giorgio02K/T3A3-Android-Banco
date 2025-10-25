package com.ordenapp.ordenapp

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ordenapp.ordenapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TareaAdapter
    private lateinit var fab: FloatingActionButton
    private lateinit var db: AppDatabase
    private lateinit var dao: TareaDao
    private lateinit var menuContextual: RecyclerView
    private lateinit var button: Button
    private lateinit var dismissButton: Button

    private fun mostrarDialogEditar(tarea: Tarea, position: Int) {
        val editText = EditText(this)
        editText.setText(tarea.titulo)

        AlertDialog.Builder(this)
            .setTitle("Editar tarea")
            .setView(editText)
            .setPositiveButton("Guardar") { _, _ ->
                val tareaEditada = tarea.copy(titulo = editText.text.toString())
                lifecycleScope.launch {
                    dao.actualizarTarea(tareaEditada)
                    adapter.setTareas(dao.obtenerTareas().toMutableList())
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        db = AppDatabase.getDatabase(this)
        dao = db.tareaDao()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = TareaAdapter(
            mutableListOf(),
            onEditar = { tarea, position ->
                mostrarDialogEditar(tarea, position)
            },
            onEliminar = { tarea, position ->
                lifecycleScope.launch {
                    dao.eliminarTarea(tarea)
                    adapter.setTareas(dao.obtenerTareas().toMutableList())
                }
            }
        )
        recyclerView.adapter = adapter

        // Cargar tareas al inicio
        lifecycleScope.launch {
            val tareas = dao.obtenerTareas()
            adapter.setTareas(tareas.toMutableList())
        }


        fab = findViewById(R.id.fab)
        fab.setOnClickListener {
            val input = EditText(this)
            AlertDialog.Builder(this)
                .setTitle("Nueva tarea")
                .setView(input)
                .setPositiveButton("Añadir") { _, _ ->
                    val nuevaTarea = Tarea(
                        titulo = input.text.toString(),
                        categoria = "General",
                        frecuencia = "Diario"
                    )

                    lifecycleScope.launch {
                        dao.insertarTarea(nuevaTarea) // Guardar en BD
                        val tareas = dao.obtenerTareas() // Recargar
                        adapter.setTareas(tareas.toMutableList())
                    }
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }

        recyclerView.adapter = adapter
    }
}


