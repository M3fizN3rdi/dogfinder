package com.groegcodedev.dog.ui.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.groegcodedev.dog.R

class OptionDetailsAdapter(
    private val items: List<OptionsButtonItem>,
    private val onItemClick: (OptionsButtonItem) -> Unit)
    : RecyclerView.Adapter<OptionDetailsAdapter.ViewHolder>() {

    // Modelo de datos para los ítems circulares
    data class OptionsButtonItem(val bgDetail: Int, val iconRes: Int)

    // ViewHolder para los elementos del botón circular
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Vistas dentro del elemento del botón circular
        val detailButton: ImageView = itemView.findViewById(R.id.bg_button)
        val icButton: ImageView = itemView.findViewById(R.id.ic_button)
    }

    // Método onCreateViewHolder, que se llama cuando se crea un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Infla el diseño del elemento del botón circular y crea un nuevo ViewHolder con él
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_detail_button, parent, false)
        return ViewHolder(view)
    }

    // Método getItemCount, que devuelve el tamaño de la lista de ítems circulares
    override fun getItemCount(): Int = items.size

    // Método onBindViewHolder, que se llama para asociar los datos de un ítem con su ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Obtiene el ítem en la posición dada
        val item = items[position]
        // Asigna el icono del ítem al ImageView en el ViewHolder
        holder.detailButton.setImageResource(item.bgDetail)
        holder.icButton.setImageResource(item.iconRes)

        // Configura un clic en el elemento del botón circular para llamar a la función onItemClick
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }
}