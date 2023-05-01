package com.example.lessonviewpager.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonviewpager.R
import com.example.lessonviewpager.model.Product

class RecycleItemProductAdapter(var list:MutableList<Product>): RecyclerView.Adapter<RecycleItemProductAdapter.Myholder>() {
    class Myholder(itemView: View):RecyclerView.ViewHolder(itemView){
            var name = itemView.findViewById<TextView>(R.id.product_item_recycle_name)
            var img = itemView.findViewById<ImageView>(R.id.product_item_recycle_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return Myholder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Myholder, position: Int) {
        var item = list[position]

        holder.name.text = item.name
        holder.img.setImageResource(item.img)
    }
}