package com.groegcodedev.dog

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.groegcodedev.dog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding // Accede a las vistas en el layout
    private lateinit var dogAdapter: DogAdapter // Adapter para el RecyclerView de perros
    private val dogList = ArrayList<DogAdapter.Dog>() // Lista para almacenar los datos de los perros

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicializa el binding inflando el layout
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Forzar el tema claro en la aplicacion
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setupCircleButtons() // Configura los botones circulares
        setupDogRecyclerView() // Configura el RecyclerView de perros
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
                val intent = Intent(this, FurryFriendsActivity::class.java)
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

    /**
     * Configura el RecyclerView que muestra la lista de perros.
     * Utiliza un LinearLayoutManager en orientación horizontal.
     * Asigna un adaptador con la lista de perros.
     * Configura un LinearSnapHelper para alinear los elementos en el centro al deslizar.
     */
    private fun setupDogRecyclerView() {
        binding.rvDog.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.HORIZONTAL, false)
            LinearSnapHelper().attachToRecyclerView(this)
            adapter = DogAdapter(dogList)
        }
        populateDogList() // Agrega datos a la lista de perros
    }

    /**
     * Llena la lista de perros con datos iniciales.
     * Agrega tres elementos de muestra a la lista.
     */
    private fun populateDogList() {
        dogList.apply {
            add(DogAdapter.Dog(R.drawable.dog2))
            add(DogAdapter.Dog(R.drawable.dog3))
            add(DogAdapter.Dog(R.drawable.dog7))
        }
    }
}
