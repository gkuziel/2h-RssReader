package com.gkuziel.skyrssreader.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gkuziel.skyrssreader.databinding.ItemItemBinding
import com.gkuziel.skyrssreader.model.RssItem
import coil.load


class RssItemAdapter(private val context: Context) :
    RecyclerView.Adapter<RssItemAdapter.ItemViewHolder>() {

    private lateinit var items: List<RssItem>

    fun setItems(items: List<RssItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val binding = ItemItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) {
        holder.binding.apply {
            val item = items[position]
            tvTitle.text = item.title
            tvDescription.text = item.description
            tvLink.text = item.url
            tvLink.setOnClickListener {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(item.url)
                )
                context.startActivity(browserIntent)
            }
            imgImage.load(item.imageUrl)
            // todo: add placeholder for no image
            // todo: add error image
        }
    }

    override fun getItemCount() = items.size

    inner class ItemViewHolder(
        val binding: ItemItemBinding
    ) : RecyclerView.ViewHolder(binding.root)
}