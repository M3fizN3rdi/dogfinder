package com.groegcodedev.dog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.groegcodedev.dog.databinding.ActivityRandomDogBinding

class RandomDogActivity : AppCompatActivity() {

    lateinit var binding: ActivityRandomDogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomDogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.returnButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Opcional: cierra la actividad actual si no quieres que permanezca en el backstack
        }


    }
}