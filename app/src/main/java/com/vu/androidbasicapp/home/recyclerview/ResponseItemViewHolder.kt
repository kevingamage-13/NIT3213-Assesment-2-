package com.vu.androidbasicapp.home.recyclerview

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.DetailsActivity
import com.vu.androidbasicapp.R
import com.vu.androidbasicapp.home.data.ResponseItem

class ResponseItemViewHolder(view: View, private val navigationFunction: (ResponseItem) -> Unit) : RecyclerView.ViewHolder(view) {

    private val name: TextView = view.findViewById(R.id.itemNametext)
    private val technique: TextView = view.findViewById(R.id.techniqueTextView)
    private val equipment: TextView = view.findViewById(R.id.equipmentTextView)
    private val subject: TextView = view.findViewById(R.id.subjectTextView)
    private val details: TextView = view.findViewById(R.id.detailsText)
    private val button: Button = view.findViewById(R.id.navigationButton)

    fun bind(item: ResponseItem) {
        // Bind the item data to the views
        name.text = item.pioneeringPhotographer  // Assuming this is used as the name
        technique.text = "Technique: " + item.technique
        equipment.text = "Equipment: " + item.equipment
        subject.text = "Subject: " + item.subject

        // If there's a description, show the details and button
        val showDetails = if (item.description.isNullOrEmpty()) View.INVISIBLE else View.VISIBLE
        details.visibility = showDetails
        button.visibility = showDetails

        if (showDetails == View.VISIBLE) {
            button.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, DetailsActivity::class.java)

                // Pass the selected item's details to the DetailsActivity
                intent.putExtra("technique", item.technique)
                intent.putExtra("equipment", item.equipment)
                intent.putExtra("subject", item.subject)
                intent.putExtra("pioneeringPhotographer", item.pioneeringPhotographer)
                intent.putExtra("yearIntroduced", item.yearIntroduced)
                intent.putExtra("description", item.description)

                // Start the DetailsActivity
                context.startActivity(intent)
            }
        }
    }
}
