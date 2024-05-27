package com.groegcodedev.dog.ui.search.presenter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.groegcodedev.dog.databinding.ActivitySearchDogBinding
import com.groegcodedev.dog.ui.home.presenter.HomeActivity

class SearchDogActivity : AppCompatActivity() {

    lateinit var binding: ActivitySearchDogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchDogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.returnButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Opcional: cierra la actividad actual si no quieres que permanezca en el backstack
        }

    }
}