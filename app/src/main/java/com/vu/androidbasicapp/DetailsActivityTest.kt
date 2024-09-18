package com.vu.androidbasicapp

import android.content.Intent
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DetailsActivityTest {

    private lateinit var intent: Intent

    @Before
    fun setup() {
        // Prepare the mock intent
        intent = Intent(ApplicationProvider.getApplicationContext(), DetailsActivity::class.java).apply {
            putExtra("technique", "Long Exposure")
            putExtra("equipment", "Tripod")
            putExtra("subject", "Night Sky")
            putExtra("pioneeringPhotographer", "Michael Kenna")
            putExtra("yearIntroduced", 1975)
            putExtra("description", "A technique where the camera's shutter is left open for an extended period.")
        }
    }

    @Test
    fun detailsActivity_displaysCorrectData() {
        val scenario = ActivityScenario.launch<DetailsActivity>(intent)

        scenario.onActivity { activity ->
            // Assert that the text in each TextView matches the passed Intent extras
            assertEquals("Technique: Long Exposure", activity.findViewById<TextView>(R.id.detailTechnique).text)
            assertEquals("Equipment: Tripod", activity.findViewById<TextView>(R.id.detailEquipment).text)
            assertEquals("Subject: Night Sky", activity.findViewById<TextView>(R.id.detailSubject).text)
            assertEquals("Pioneering Photographer: Michael Kenna", activity.findViewById<TextView>(R.id.detailPhotographer).text)
            assertEquals("Year Introduced: 1975", activity.findViewById<TextView>(R.id.detailYear).text)
            assertEquals("Description: A technique where the camera's shutter is left open for an extended period.", activity.findViewById<TextView>(R.id.detailDescription).text)
        }
    }
}
