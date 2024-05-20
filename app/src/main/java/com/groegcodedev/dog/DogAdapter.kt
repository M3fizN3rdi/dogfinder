package com.groegcodedev.dog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class DogAdapter(
    private val dogList: ArrayList<Dog> // Lista de perros a mostrar en el RecyclerView
) :
    RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    // Modelo de datos para los perros
    data class Dog(val dogImage: Int)

    // Clase interna DogViewHolder, que representa cada elemento de la lista en el RecyclerView
    class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dogImageView: ImageView = itemView.findViewById(R.id.imageView_dog) // Referencia al ImageView en el layout del elemento
        //val dogNameTv: TextView = itemView.findViewById(R.id.textView) // Referencia al TextView en el layout del elemento
    }

    // Método onCreateViewHolder, que se llama cuando se crea un nuevo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        // Infla el layout del elemento del RecyclerView y crea un nuevo ViewHolder con él
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    // Método getItemCount, que devuelve el tamaño de la lista de perros
    override fun getItemCount(): Int {
        return dogList.size
    }

    // Método onBindViewHolder, que se llama para asociar los datos de un elemento con su ViewHolder
    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        // Obtiene el objeto Dog en la posición dada
        val dog = dogList[position]
        // Asigna la imagen del perro al ImageView en el ViewHolder
        holder.dogImageView.setImageResource(dog.dogImage)
        //holder.dogNameTv.text = dog.dogName
    }
}
