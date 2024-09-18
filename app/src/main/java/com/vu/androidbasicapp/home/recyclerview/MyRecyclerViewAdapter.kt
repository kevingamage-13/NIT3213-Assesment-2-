package com.vu.androidbasicapp.home.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vu.androidbasicapp.R
import com.vu.androidbasicapp.home.data.ResponseItem

class MyRecyclerViewAdapter(
    private val dataList: MutableList<ResponseItem>,
    private val onItemClicked: (ResponseItem) -> Unit
) : RecyclerView.Adapter<ResponseItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResponseItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_restful_api_dev, parent, false)
        return ResponseItemViewHolder(view, onItemClicked)
    }

    override fun onBindViewHolder(viewHolder: ResponseItemViewHolder, position: Int) {
        viewHolder.bind(dataList[position])
    }

    override fun getItemCount() = dataList.size

    fun setData(newDataList: List<ResponseItem>) {
        dataList.clear()
        dataList.addAll(newDataList)
        Log.d("RecyclerViewAdapter", "Data updated: ${dataList.size} items")
        notifyDataSetChanged()
    }
}
