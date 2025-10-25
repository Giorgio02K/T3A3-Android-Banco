package com.ordenapp.ordenapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TareaAdapter(
    private val tareas: MutableList<Tarea>,
    private val onEditar: (tarea: Tarea, position: Int) -> Unit,
    private val onEliminar: (tarea: Tarea, position: Int) -> Unit
) : RecyclerView.Adapter<TareaAdapter.TareaViewHolder>() {

    private fun showPopupMenu(view: View, tarea: Tarea, position: Int) {
        val popup = android.widget.PopupMenu(view.context, view)
        popup.menuInflater.inflate(R.menu.item_menu, popup.menu)

        popup.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.editar -> onEditar(tarea, position)
                R.id.eliminar -> onEliminar(tarea, position)
            }
            true
        }
        popup.show()
    }


    class TareaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitulo: TextView = itemView.findViewById(R.id.txtTitulo)
        val txtCategoria: TextView = itemView.findViewById(R.id.txtCategoria)
        val txtFrecuencia: TextView = itemView.findViewById(R.id.txtFrecuencia)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarea, parent, false)
        return TareaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val tarea = tareas[position]
        holder.txtTitulo.text = tarea.titulo
        holder.txtCategoria.text = tarea.categoria
        holder.txtFrecuencia.text = tarea.frecuencia
        holder.itemView.setOnLongClickListener { view ->
            showPopupMenu(view, tarea, position)
            true
        }
    }

    override fun getItemCount(): Int = tareas.size

    fun agregarTarea(tarea: Tarea) {
        tareas.add(tarea)
        notifyItemInserted(tareas.size - 1)
    }

    fun setTareas(lista: MutableList<Tarea>) {
        tareas.clear()
        tareas.addAll(lista)
        notifyDataSetChanged()
    }
}
