package com.groegcodedev.dog.ui.gridfinder.presenter

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.groegcodedev.dog.databinding.ActivityGridDogsBinding
import com.groegcodedev.dog.ui.details.presenter.DetailsDogActivity
import com.groegcodedev.dog.ui.gridfinder.adapter.GridDogAdapter
import com.groegcodedev.dog.ui.gridfinder.viewmodel.GridDogsViewModel
import com.groegcodedev.dog.ui.gridfinder.viewmodel.StateGridViewModel
import com.groegcodedev.dog.ui.home.presenter.HomeActivity

class GridDogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGridDogsBinding
    private val viewModel by viewModels<GridDogsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridDogsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Btn back
        binding.returnButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Opcional: cierra la actividad actual si no quieres que permanezca en el backstack
        }

        // Btn paw random
        binding.icPaw.setOnClickListener {
            callGrid()
        }

        callGrid() // Carga el grid por primera vez

        observer() // Actualiza el adapter de las imagenes del RV
    }

    private fun callGrid() {
        viewModel.getGridDogs()
    }
    private fun observer() {
        viewModel.getData().observe(this) { data ->
            when (data) {
                is StateGridViewModel.Sucess -> {
                    initRecyclerView(data.info.message ?: listOf())
                }

                is StateGridViewModel.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModel.getImage().observe(this) {
            navigateToImageDetails()
        }
    }

    private fun initRecyclerView(value: List<String>) {
        binding.rvGridDogs.layoutManager = GridLayoutManager(this, 3)
        val adapter = GridDogAdapter(value, viewModel::onImageClicked)
        binding.rvGridDogs.adapter = adapter
    }

    private fun navigateToImageDetails() {
        val intent = Intent(this, DetailsDogActivity::class.java)
        startActivity(intent)
    }
}