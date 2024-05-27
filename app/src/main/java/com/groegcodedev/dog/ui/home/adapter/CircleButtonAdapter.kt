package com.groegcodedev.dog.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.groegcodedev.dog.R

class CircleButtonAdapter(
    private val items: List<CircleButtonItem>, // Lista de ítems con iconos y textos
    private val onItemClick: (CircleButtonItem) -> Unit // Función de clic para manejar el clic en los ítems
) : RecyclerView.Adapter<CircleButtonAdapter.ViewHolder>() {

    // Modelo de datos para los ítems circulares
    data class CircleButtonItem(val iconRes: Int, val text: String, val textColor: Int)

    // ViewHolder para los elementos del botón circular
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Vistas dentro del elemento del botón circular
        val circleButton: ImageView = itemView.findViewById(R.id.circle_button)
        val circleText: TextView = itemView.findViewById(R.id.circle_text)
    }

    // Método onCreateViewHolder, que se llama cuando se crea un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Infla el diseño del elemento del botón circular y crea un nuevo ViewHolder con él
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_circle_button, parent, false)
        return ViewHolder(view)
    }

    // Método getItemCount, que devuelve el tamaño de la lista de ítems circulares
    override fun getItemCount(): Int = items.size

    // Método onBindViewHolder, que se llama para asociar los datos de un ítem con su ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Obtiene el ítem en la posición dada
        val item = items[position]
        // Asigna el icono del ítem al ImageView en el ViewHolder
        holder.circleButton.setImageResource(item.iconRes)
        // Asigna el texto del ítem al TextView en el ViewHolder
        holder.circleText.text = item.text
        // Asigna el color de texto del ítem al TextView en el ViewHolder
        holder.circleText.setTextColor(item.textColor)
        // Configura un clic en el elemento del botón circular para llamar a la función onItemClick
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }
}
