package com.yurivital.fitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yurivital.fitness.databinding.ActivityListCalcBinding
import com.yurivital.fitness.model.Calc

class ListCalcActivity : AppCompatActivity() {
    private val binding: ActivityListCalcBinding by lazy { ActivityListCalcBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val type = intent?.extras?.getString("type") ?: throw IllegalStateException("type not found")
        Thread {
            val app = (application as App)
            val dao = app.db.calcDao()

            runOnUiThread {
            }
        }.start()


    }
}