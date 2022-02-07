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
        val cardViewMenu: CardView = itemView.findViewById(R.id.cardViewMenu)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            //   clickListener?.onItemClick(v!!, layoutPosition)
        }
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_menu_item, parent, false)

        return ViewHolder(itemView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tituloMenu.text = dataSet[position].descricao


        holder.cardViewMenu.setOnClickListener {
            Log.d("teste", " ::: ${dataSet[position].descricao}")
      //     val bundle = bundleOf(USERNAME_KEY to dataSet[position])
//
          //  holder.itemView.findNavController().navigate(R.id.action_menuFragment_to_dispositivosFragment)

            val action = MenuFragmentDirections.actionMenuFragmentToDispositivosFragment(dataSet[position].descricao.toString())
            holder.itemView.findNavController().navigate(action)
        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    companion object {
        const val USERNAME_KEY = "menuName"
    }
}

private val listOfAvatars = listOf(
    R.drawable.menu_logo_picking,
    R.drawable.menu_logo_abastecimento,
)
