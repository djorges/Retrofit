package com.example.retrofit_example.presentation.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.retrofit_example.R
import com.example.retrofit_example.data.model.Channel.Item


class ItemAdapter(val context: Context, itemList: List<Item>) : RecyclerView.Adapter<ItemAdapter.ItemHolder>()
{
    private var itemList: List<Item>
    init {
        //Setup list
        this.itemList = itemList;
        notifyDataSetChanged();
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent,false)
        return ItemHolder(itemView)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = itemList.get(position)
        holder.setData(item)
    }
    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtDate: TextView
        private val txtTitle: TextView
        private val txtContent: TextView
        private val img: ImageView

        init {
            //Init views
            txtTitle = itemView.findViewById(R.id.card_title)
            txtDate = itemView.findViewById(R.id.card_date)
            txtContent = itemView.findViewById(R.id.card_content)
            img = itemView.findViewById(R.id.card_image)
        }
        fun setData(item: Item){
            val date = item.pubDate

            txtTitle.text = item.title
            txtDate.text = date!!.substring(0, date.length-12)
            txtContent.text = item.content
            Glide.with(img)
                .load(item.media!!.url)
                .error(RequestOptions().error(R.drawable.ic_baseline_library_books_24))
                .into(img)

            itemView.setOnClickListener {
                //Redirect to link
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.link))
                context.startActivity(intent)
            }
        }
    }
}