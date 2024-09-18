package com.vu.androidbasicapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Get data from the Intent
        val technique = intent.getStringExtra("technique")
        val equipment = intent.getStringExtra("equipment")
        val subject = intent.getStringExtra("subject")
        val pioneeringPhotographer = intent.getStringExtra("pioneeringPhotographer")
        val yearIntroduced = intent.getIntExtra("yearIntroduced", 0)
        val description = intent.getStringExtra("description")

        // Find views and set data
        findViewById<TextView>(R.id.detailTechnique).text = "Technique: $technique"
        findViewById<TextView>(R.id.detailEquipment).text = "Equipment: $equipment"
        findViewById<TextView>(R.id.detailSubject).text = "Subject: $subject"
        findViewById<TextView>(R.id.detailPhotographer).text = "Pioneering Photographer: $pioneeringPhotographer"
        findViewById<TextView>(R.id.detailYear).text = "Year Introduced: $yearIntroduced"
        findViewById<TextView>(R.id.detailDescription).text = "Description: $description"
    }
}
