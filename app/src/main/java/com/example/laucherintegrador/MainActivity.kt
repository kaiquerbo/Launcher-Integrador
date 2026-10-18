package com.example.laucherintegrador

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import com.example.launcherintegrador.R

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val botao = findViewById<Button>(
            R.id.btnAumentarFonte
        )

        botao.setOnClickListener {
            val intent = Intent(
                Settings.ACTION_DISPLAY_SETTINGS
            )
            startActivity(intent)
        }
    }
}