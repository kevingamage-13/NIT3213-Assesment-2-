package com.vu.androidbasicapp.home.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.R
import com.vu.androidbasicapp.home.network.RestfulApiDevRetrofitClient
import com.vu.androidbasicapp.home.recyclerview.MyRecyclerViewAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeScreenFragment : Fragment() {

    private val apiClient = RestfulApiDevRetrofitClient()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = MyRecyclerViewAdapter(mutableListOf()) { item ->
            Toast.makeText(requireContext(), "Clicked: ${item.technique}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter

        // Fetch keypass and use it to fetch the dashboard data
        val keypass = arguments?.getString("keypass") ?: ""

        if (keypass.isNotEmpty()) {
            fetchDashboardData(keypass)
        } else {
            Toast.makeText(requireContext(), "Keypass missing!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchDashboardData(keypass: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiClient.apiService.getDashboardData(keypass)

                // Ensure the fragment is attached before updating the UI
                if (isAdded) { // Check if the fragment is still attached to its activity
                    requireActivity().runOnUiThread {
                        adapter.setData(response.entities)
                        Toast.makeText(requireContext(), "Dashboard data fetched", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Handle the case where the fragment is no longer attached
                    Log.e("FragmentError", "Fragment not attached to activity.")
                }
            } catch (e: Exception) {
                if (isAdded) { // Check if the fragment is still attached before updating UI
                    requireActivity().runOnUiThread {
                        Toast.makeText(requireContext(), "Failed to fetch dashboard data", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

}
