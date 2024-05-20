package com.groegcodedev.dog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.groegcodedev.dog.databinding.ActivityFurryFriendsBinding

class FurryFriendsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFurryFriendsBinding
    private lateinit var dogAdapter: GridDogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFurryFriendsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.returnButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Opcional: cierra la actividad actual si no quieres que permanezca en el backstack
        }

        // Inicializar la lista de perros
        val dogList = ArrayList<GridDogAdapter.Dog>()
        // Agregar perros a la lista (sustituye esto con tu lógica para obtener la lista de perros)
        dogList.add(GridDogAdapter.Dog(R.drawable.dog7))
        dogList.add(GridDogAdapter.Dog(R.drawable.dog2))
        dogList.add(GridDogAdapter.Dog(R.drawable.dog3))
        dogList.add(GridDogAdapter.Dog(R.drawable.member0))
        dogList.add(GridDogAdapter.Dog(R.drawable.member1))
        dogList.add(GridDogAdapter.Dog(R.drawable.member2))
        dogList.add(GridDogAdapter.Dog(R.drawable.member3))
        // Agregar más perros...

        // Configurar el RecyclerView
        dogAdapter = GridDogAdapter(dogList)
        binding.rvGridDogs.layoutManager = GridLayoutManager(this, 3)
        binding.rvGridDogs.adapter = dogAdapter
    }
}
