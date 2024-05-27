package com.groegcodedev.dog.ui.details.presenter

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.groegcodedev.dog.R
import com.groegcodedev.dog.databinding.ActivityDetailsDogBinding
import com.groegcodedev.dog.ui.details.adapter.OptionDetailsAdapter
import com.groegcodedev.dog.ui.home.presenter.HomeActivity
import com.groegcodedev.dog.ui.home.viewmodel.ImageClass
import com.squareup.picasso.Picasso

class DetailsDogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsDogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsDogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Btn back
        binding.returnButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Opcional: cierra la actividad actual si no quieres que permanezca en el backstack
        }

        loadImage()

        setupOptionDetails()
    }

    private fun setupOptionDetails() {
        binding.rvOptionDetail.apply {
            layoutManager = GridLayoutManager(this@DetailsDogActivity, 4)
            adapter = OptionDetailsAdapter(getOptionDetailsItems()) { item ->
                handleCircleButtonClick(item)
            }
        }
    }

    private fun getOptionDetailsItems() = listOf(
        OptionDetailsAdapter.OptionsButtonItem(R.drawable.circle_bg_grey, R.drawable.ic_food),
        OptionDetailsAdapter.OptionsButtonItem(R.drawable.circle_bg_white, R.drawable.ic_doctor),
        OptionDetailsAdapter.OptionsButtonItem(R.drawable.circle_bg_white, R.drawable.ic_habitat),
        OptionDetailsAdapter.OptionsButtonItem(R.drawable.circle_bg_white, R.drawable.ic_paw)
    )

    private fun loadImage() {
        Picasso.get().load(ImageClass.imageGrid).into(binding.imDetail)
    }

    private fun handleCircleButtonClick(item: OptionDetailsAdapter.OptionsButtonItem) =
    // Manejar el clic en el botón circular
        // Puedes realizar alguna acción con el recurso clicado
        when (item.iconRes) {
            R.drawable.ic_food -> {
                binding.tvFeatures.text = "Cualquier dieta debe ser apropiada para el perro."
            }
            R.drawable.ic_doctor -> {
                binding.tvFeatures.text = "Todas sus vacunas."
            }
            R.drawable.ic_habitat -> {
                binding.tvFeatures.text = "Debe haber agua limpia y fresca disponible."
            }
            R.drawable.ic_paw -> {
                binding.tvFeatures.text = "Raza unica."
            }
            else -> {

            }
        }
}