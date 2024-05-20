package com.groegcodedev.dog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.groegcodedev.dog.databinding.ActivityAboutUsBinding

class AboutUsActivity : AppCompatActivity() {

    lateinit var binding: ActivityAboutUsBinding

    private lateinit var memberAdapter: MembersAdapter
    private val memberList = ArrayList<MembersAdapter.Member>()

    private lateinit var aboutUsAdapter: AboutUsAdapter
    private val aboutUsList = ArrayList<AboutUsAdapter.AboutUs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Forzar el tema claro en la aplicacion
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        setupMemberRecyclerView()
        setupAboutUsRecyclerView()

        // Agregar OnClickListener al ImageView para regresar a MainActivity
        binding.returnIcon.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Finalizar esta actividad para volver a la MainActivity
        }
    }



    private fun setupMemberRecyclerView() {
        binding.rvGroupMembers.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@AboutUsActivity, RecyclerView.HORIZONTAL, false)
            LinearSnapHelper().attachToRecyclerView(this)
            adapter = MembersAdapter(memberList)
        }
        populateMemberList()
    }

    private fun populateMemberList() {
        memberList.apply {
            add(MembersAdapter.Member(R.drawable.member0))
            add(MembersAdapter.Member(R.drawable.member1))
            add(MembersAdapter.Member(R.drawable.member2))
            add(MembersAdapter.Member(R.drawable.member0))
            add(MembersAdapter.Member(R.drawable.member1))
            add(MembersAdapter.Member(R.drawable.member2))
            add(MembersAdapter.Member(R.drawable.member0))
            add(MembersAdapter.Member(R.drawable.member1))
            add(MembersAdapter.Member(R.drawable.member2))
        }
    }


    private fun setupAboutUsRecyclerView() {
        binding.rvAboutUs.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@AboutUsActivity, RecyclerView.HORIZONTAL, false)
            LinearSnapHelper().attachToRecyclerView(this)
            adapter = AboutUsAdapter(aboutUsList)
        }
        populateAboutUsList()
    }

    private fun populateAboutUsList() {
        aboutUsList.apply {
            add(AboutUsAdapter.AboutUs(R.drawable.member3))
            add(AboutUsAdapter.AboutUs(R.drawable.member1))
            add(AboutUsAdapter.AboutUs(R.drawable.member2))
            add(AboutUsAdapter.AboutUs(R.drawable.member3))
            add(AboutUsAdapter.AboutUs(R.drawable.member1))
            add(AboutUsAdapter.AboutUs(R.drawable.member2))
            add(AboutUsAdapter.AboutUs(R.drawable.member3))
            add(AboutUsAdapter.AboutUs(R.drawable.member1))
            add(AboutUsAdapter.AboutUs(R.drawable.member2))
        }
    }

}