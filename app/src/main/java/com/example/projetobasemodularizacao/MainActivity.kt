package com.example.projetobasemodularizacao

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController

import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {


    private val navController: NavController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
               com.example.comum.R.id.action_loginFragment_to_menuFragment,
               com.example.comum.R.id.action_menuFragment_to_dispositivosFragment,

                -> {
                    toolbar.visibility = View.GONE
                }
                else -> {
                    toolbar.visibility = View.VISIBLE
                }
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}