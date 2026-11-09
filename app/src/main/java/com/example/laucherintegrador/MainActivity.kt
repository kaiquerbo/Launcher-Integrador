package com.example.laucherintegrador

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.launcherintegrador.R

class MainActivity : AppCompatActivity() {

    private lateinit var listaApps: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaApps = findViewById(R.id.listaApps)

        val aplicativos = carregarAplicativos()

        listaApps.layoutManager = LinearLayoutManager(this)
        listaApps.adapter = AppAdapter(this, aplicativos)
    }

    private fun carregarAplicativos(): List<AppInfo> {

        val lista = mutableListOf<AppInfo>()

        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_LAUNCHER)

        val aplicativos = packageManager.queryIntentActivities(
            intent,
            PackageManager.MATCH_ALL
        )

        for (app in aplicativos) {

            val nome = app.loadLabel(packageManager).toString()
            val pacote = app.activityInfo.packageName
            val icone = app.loadIcon(packageManager)

            lista.add(
                AppInfo(nome, pacote, icone)
            )
        }

        return lista.sortedBy { it.nome }
    }
}