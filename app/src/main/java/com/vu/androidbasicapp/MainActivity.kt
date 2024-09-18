package com.vu.androidbasicapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.vu.androidbasicapp.home.ui.HomeScreenFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val keypass = intent.getStringExtra("keypass") ?: ""

        // Load the HomeScreenFragment and pass the keypass
        loadHomeScreenFragment(keypass)

    }

    private fun loadHomeScreenFragment(keypass: String) {
        val fragment = HomeScreenFragment()

        // Create a Bundle to pass arguments to the fragment
        val bundle = Bundle()
        bundle.putString("keypass", keypass)
        fragment.arguments = bundle

        // Replace the fragment in the container and pass the arguments
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
