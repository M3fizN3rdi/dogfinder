package com.groegcodedev.dog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class GridDogAdapter(private val dogList: ArrayList<GridDogAdapter.Dog>) :
    RecyclerView.Adapter<GridDogAdapter.DogViewHolder>() {

    data class Dog(val dogImage: Int)

    class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dogImageView: ImageView = itemView.findViewById(R.id.imageView_grid_dog)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid_dogs, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount(): Int {
        // Devuelve el número total de elementos en la cuadrícula, que es 3 columnas x 4 filas
        return 3 * 4
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        // Calcula el índice del elemento en la lista de perros
        val index = position % dogList.size
        // Obtiene el perro en el índice calculado
        val dog = dogList[index]
        // Establece la imagen del perro en el ImageView
        holder.dogImageView.setImageResource(dog.dogImage)
    }
}
