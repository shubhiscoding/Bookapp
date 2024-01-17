package com.example.bookapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.databinding.LayoutHomeBinding

class BooksAdapter(val list:ArrayList<BooksModel>, val context: Context):RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
    class ViewHolder(val binding:LayoutHomeBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutHomeBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        holder.binding.apply {
            imageView2.setImageResource(model.image!!)
            titletext.text = model.title
            descriptionview.text = model.description
            if(model.slctday>0){
                availableMain.text = "Available in ${model.slctday} days"
            }
            viewbox.setOnClickListener {
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("book_title", model.title)
                intent.putExtra("book_desc", model.description)
                intent.putExtra("contact", model.contact)
                intent.putExtra("book_image", model.image)
                intent.putExtra("maxDays", model.maxBorrow)
                intent.putExtra("index", model.count)
                intent.putExtra("isBorrowed", model.isBorrowed)
                intent.putExtra("slctday", model.slctday)
                context.startActivity(intent)
            }
        }
    }

}