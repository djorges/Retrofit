package com.example.retrofit_example.presentation.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.retrofit_example.R
import com.example.retrofit_example.data.model.ArticleModel
import com.example.retrofit_example.presentation.viewmodel.MainViewModel

class MainAdapter(
        val context: Context,
        private val articles: MutableList<ArticleModel>,
        private val viewModel: MainViewModel,
        private val menuId:Int
) : RecyclerView.Adapter<MainAdapter.MainHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent,false)
        return MainHolder(itemView)
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val article = articles.get(position)

        holder.setData(article)
        holder.txtTitle.setOnClickListener {
            //Redirect to link
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article.link))
            context.startActivity(intent)
        }
        holder.btnOptions.setOnClickListener{
            //Show Menu
            val popup = PopupMenu(context, it)
            popup.menuInflater.inflate(menuId, popup.menu)
            popup.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu_main_save -> {
                        //Save Article
                        viewModel.saveArticle(article)
                        true
                    }
                    R.id.menu_fav_delete -> {
                        //Delete Article
                        articles.removeAt(position)
                        notifyItemRemoved(position)
                        viewModel.deleteArticle(article)
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
            popup.show()
        }
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtDate: TextView = itemView.findViewById(R.id.card_date)
        val txtTitle: TextView = itemView.findViewById(R.id.card_title)
        private val txtContent: TextView = itemView.findViewById(R.id.card_content)
        private val img: ImageView = itemView.findViewById(R.id.card_image)
        val btnOptions: ImageButton = itemView.findViewById(R.id.card_btn_options)

        fun setData(article: ArticleModel){
            //Set Data
            txtTitle.text = article.title
            txtDate.text = article.pubDate!!.substring(0, article.pubDate!!.length-12)
            txtContent.text = article.content
            Glide.with(img)
                .load(article.media?.url)
                .error(RequestOptions().error(R.drawable.ic_baseline_library_books_24))
                .into(img)
        }
    }
}