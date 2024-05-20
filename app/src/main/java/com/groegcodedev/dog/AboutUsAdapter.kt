package com.groegcodedev.dog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class AboutUsAdapter(
    private val aboutUsList: ArrayList<AboutUs> // Lista de elementos "Acerca de Nosotros" a mostrar en el RecyclerView
) : RecyclerView.Adapter<AboutUsAdapter.AboutUsViewHolder>() {

    // Modelo de datos para los elementos "Acerca de Nosotros"
    data class AboutUs(val aboutUsImage: Int)

    // ViewHolder para los elementos del "Acerca de Nosotros"
    class AboutUsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Vista de imagen para el "Acerca de Nosotros"
        val aboutUsImageView: ImageView = itemView.findViewById(R.id.imageView_aboutUs)
    }

    // Método onCreateViewHolder, que se llama cuando se crea un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutUsViewHolder {
        // Infla el diseño del elemento "Acerca de Nosotros" del RecyclerView y crea un nuevo ViewHolder con él
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_about_us, parent, false)
        return AboutUsViewHolder(view)
    }

    // Método getItemCount, que devuelve el tamaño de la lista de elementos "Acerca de Nosotros"
    override fun getItemCount(): Int {
        return aboutUsList.size
    }

    // Método onBindViewHolder, que se llama para asociar los datos de un elemento con su ViewHolder
    override fun onBindViewHolder(holder: AboutUsViewHolder, position: Int) {
        // Obtiene el objeto "Acerca de Nosotros" en la posición dada
        val member = aboutUsList[position]
        // Asigna la imagen del "Acerca de Nosotros" al ImageView en el ViewHolder
        holder.aboutUsImageView.setImageResource(member.aboutUsImage)
    }
}
