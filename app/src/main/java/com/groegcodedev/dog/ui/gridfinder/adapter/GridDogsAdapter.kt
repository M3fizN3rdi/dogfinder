package com.groegcodedev.dog.ui.gridfinder.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.groegcodedev.dog.R
import com.groegcodedev.dog.databinding.ItemGridDogsBinding
import com.squareup.picasso.Picasso

class GridDogAdapter(private val dogList: List<String>, private val onImageClicked: (String) -> Unit) :
    RecyclerView.Adapter<GridDogsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridDogsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid_dogs, parent, false)
        return GridDogsHolder(view)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    override fun onBindViewHolder(holder: GridDogsHolder, position: Int) {
        holder.render(dogList[position], onImageClicked)
    }
}

class GridDogsHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemGridDogsBinding.bind(view)

    fun render(value: String, value1: (String) -> Unit) {
        Picasso.get().load(value).into(binding.imageViewGridDog)

        itemView.setOnClickListener {
            value1(value)
        }
    }
}
