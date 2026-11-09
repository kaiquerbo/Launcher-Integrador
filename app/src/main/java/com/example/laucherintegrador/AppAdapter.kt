package com.example.laucherintegrador

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AppAdapter(
    private val context: Context,
    private val listaApps: List<AppInfo>
) : RecyclerView.Adapter<AppAdapter.AppViewHolder>() {

    class AppViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nomeApp: TextView = view.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)

        return AppViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        val app = listaApps[position]

        holder.nomeApp.text = app.nome

        holder.itemView.setOnClickListener {
            val intent = context.packageManager
                .getLaunchIntentForPackage(app.pacote)

            if (intent != null) {
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return listaApps.size
    }
}