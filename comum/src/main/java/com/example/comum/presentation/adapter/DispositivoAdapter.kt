package com.example.comum.presentation.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comum.R
import com.example.comum.data.model.Dispositivos

class DispositivoAdapter (private val dataSet: MutableList<Dispositivos>) :
    RecyclerView.Adapter<DispositivoAdapter.ViewHolder>() {

//    private var clickListener: ItemClickListener? = null
//
//    fun itemClickListener(itemClickListener: ItemClickListener) {
//        this.clickListener = itemClickListener
//    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val nomeDispositivo: TextView = view.findViewById(R.id.nomeDispositivo)
        val statusDispositivo: TextView = view.findViewById(R.id.status_dispositivo)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
         //   clickListener?.onItemClick(v!!, layoutPosition)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.coletores, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.nomeDispositivo.text = dataSet[position].nome
        viewHolder.statusDispositivo.text = dataSet[position].status
//        if (dataSet[position].instancia.isConnected) {
//            dataSet[position].instancia.disconnect()
////            viewHolder.statusDispositivo.text = "Conectado"
////            viewHolder.statusDispositivo.setTextColor(Color.GREEN)
//            viewHolder.statusDispositivo.text = "Conectado Recentemente"
//            viewHolder.statusDispositivo.setTextColor(Color.RED)
//        } else {
//            viewHolder.statusDispositivo.text = "Desconectado"
//            viewHolder.statusDispositivo.setTextColor(Color.RED)
//        }
    }

    override fun getItemCount() = dataSet.size

    fun getItem(position: Int): Dispositivos {
        return dataSet[position]
    }

}
