package com.groegcodedev.dog.ui.home.presenter

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import com.groegcodedev.dog.ui.us.presenter.AboutUsActivity
import com.groegcodedev.dog.ui.details.presenter.DetailsDogActivity
import com.groegcodedev.dog.R
import com.groegcodedev.dog.ui.random.presenter.RandomDogActivity
import com.groegcodedev.dog.ui.search.presenter.SearchDogActivity
import com.groegcodedev.dog.databinding.ActivityHomeBinding
import com.groegcodedev.dog.ui.gridfinder.presenter.GridDogActivity
import com.groegcodedev.dog.ui.home.adapter.CircleButtonAdapter
import com.groegcodedev.dog.ui.home.adapter.DogsAdapter
import com.groegcodedev.dog.ui.home.viewmodel.DogViewModel
import com.groegcodedev.dog.ui.home.viewmodel.StateViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding // Accede a las vistas en el layout

    private val viewModel by viewModels<DogViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // Forzar el tema claro en la aplicacion

        setupCircleButtons() // Configura los botones circulares
        call()
        observer()
    }

    private fun call() {
        viewModel.getDogs()
    }

    private fun observer() {
        viewModel.data.observe(this) { data ->
            when (data) {
                is StateViewModel.Success -> {
                    hideLoading()
                    initRecyclerView(
                        data.info.message ?: listOf("https://images.dog.ceo/breeds/terrier-welsh/lucy.jpg")
                    )
                }
                is StateViewModel.Loading -> {
                    showLoading()
                }

                is StateViewModel.Error -> {

                }
            }
        }
        viewModel.getImage().observe(this) {
            navigateToImageDetails()
        }
    }

    private fun showLoading() {
        binding.loadingScreen.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.loadingScreen.visibility = View.GONE
    }

    private fun initRecyclerView(value: List<String>) {
        val adapter = DogsAdapter(value, viewModel::onImageClicked)
        binding.rvDogHome.adapter = adapter
    }


    private fun navigateToImageDetails() {
        val intent = Intent(this, DetailsDogActivity::class.java)
        startActivity(intent)
    }

    /**
     * Configura el RecyclerView que muestra los botones circulares.
     * Utiliza un GridLayoutManager con 4 columnas.
     * Asigna un adaptador con los ítems de los botones circulares.
     */
    private fun setupCircleButtons() {
        binding.rvCircleOption.apply {
            layoutManager = GridLayoutManager(this@HomeActivity, 4)
            adapter = CircleButtonAdapter(getCircleButtonItems()) { item ->
                handleCircleButtonClick(item)
            }
        }
    }

    /**
     * Devuelve una lista de ítems para los botones circulares, cada uno con un drawable, un texto y un color.
     */
    private fun getCircleButtonItems() = listOf(
        CircleButtonAdapter.CircleButtonItem(R.drawable.circle_bg_white, "Aleatorio", Color.BLACK),
        CircleButtonAdapter.CircleButtonItem(R.drawable.circle_bg_black, "Perritos", Color.WHITE),
        CircleButtonAdapter.CircleButtonItem(R.drawable.circle_bg_white, "Nosotros", Color.BLACK),
        CircleButtonAdapter.CircleButtonItem(R.drawable.circle_bg_orange, "Buscar", Color.WHITE)
    )

    private fun handleCircleButtonClick(item: CircleButtonAdapter.CircleButtonItem) {
        // Manejar el clic en el botón circular
        // Puedes realizar alguna acción con el recurso clicado
        when (item.text) {
            "Aleatorio" -> {
                val intent = Intent(this, RandomDogActivity::class.java)
                startActivity(intent)
            }
            "Perritos" -> {
                val intent = Intent(this, GridDogActivity::class.java)
                startActivity(intent)
            }
            "Nosotros" -> {
                val intent = Intent(this, AboutUsActivity::class.java)
                startActivity(intent)
            }
            "Buscar" -> {
                val intent = Intent(this, SearchDogActivity::class.java)
                startActivity(intent)
            }
            else -> {

            }
        }
    }
}
