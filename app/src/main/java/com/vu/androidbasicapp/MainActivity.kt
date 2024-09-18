package com.vu.androidbasicapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.vu.androidbasicapp.home.ui.HomeScreenFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Load the HomeScreenFragment that contains the RecyclerView
        loadHomeScreenFragment()
    }

    private fun loadHomeScreenFragment() {
        val fragment = HomeScreenFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
