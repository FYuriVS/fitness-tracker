package com.yurivital.fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yurivital.fitness.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val btnImc = binding.btnImc

        btnImc.setOnClickListener{
            val i = Intent(this, ImcActivity::class.java)
            startActivity(i)
        }
    }
}