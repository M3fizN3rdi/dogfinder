package com.groegcodedev.dog.ui.random.presenter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.groegcodedev.dog.ui.details.presenter.DetailsDogActivity
import com.groegcodedev.dog.databinding.ActivityRandomDogBinding
import com.groegcodedev.dog.ui.home.presenter.HomeActivity
import com.groegcodedev.dog.ui.home.viewmodel.ImageClass
import com.groegcodedev.dog.ui.random.viewmodel.RandomDogViewModel
import com.groegcodedev.dog.ui.random.viewmodel.StateRandomDogViewModel
import com.squareup.picasso.Picasso

class RandomDogActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRandomDogBinding
    private val viewModel by viewModels<RandomDogViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomDogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icSearchRandom.setOnClickListener {
            callRandomDog()
        }

        binding.returnButton.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        binding.imageViewRandomActivity.setOnClickListener {
            clickPhoto()
        }

        callRandomDog()
        observer()
    }

    private fun callRandomDog() {
        viewModel.getRandomDog()
    }

    private fun clickPhoto() {
        navigateToImageDetails()
    }

    private fun observer() {
        viewModel.getData().observe(this) { data ->
            when (data) {
                is StateRandomDogViewModel.Success -> {
                    initImage((data.info.message ?: "").toString())
                }

                is StateRandomDogViewModel.Error -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }

        ////viewModel.selectedImageUrl.observe(this) { imageUrl ->
        ////if (imageUrl != null) {
//                navigateToImageDetails(imageUrl)
        ////}
        ////}
    }

    private fun showLoading() {
        binding.loadingScreen.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.loadingScreen.visibility = View.GONE
    }

    private fun initImage(value: String) {
//        binding.dogPhoto.setImageURI(value)
        Picasso.get().load(value).into(binding.imageViewRandomActivity)
        ImageClass.imageGrid = value

    }

    private fun navigateToImageDetails() {
        val intent = Intent(this, DetailsDogActivity::class.java)
        startActivity(intent)
    }
}