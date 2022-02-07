package com.example.comum.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.comum.R
import com.example.comum.data.model.MenuModel
import com.example.comum.presentation.ui.DispositivosFragmentDirections
import com.example.comum.presentation.ui.MenuFragmentDirections

class MenuAdapter(private val dataSet: MutableList<MenuModel> ) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

   // class ViewHolder(val item: View) : RecyclerView.ViewHolder(item)

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val tituloMenu: TextView = view.findViewById(R.id.tituloMenu)
        val imageMenu: ImageView = itemView.findViewById(R.id.imageMenu)
        val cardViewMenu: CardView = itemView.findViewById(R.id.cardViewMenu)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            //   clickListener?.onItemClick(v!!, layoutPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_menu_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tituloMenu.text = dataSet[position].descricao
        holder.imageMenu.setImageResource(dataSet[position].image!!)

        holder.cardViewMenu.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuFragmentToDispositivosFragment(dataSet[position].descricao.toString())
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount() = dataSet.size

}
