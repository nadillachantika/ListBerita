package com.example.assignmentweek3.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignmentweek3.R
import com.example.assignmentweek3.detail.DetailBeritaActivity
import com.example.assignmentweek3.model.Berita
import kotlinx.android.synthetic.main.item_berita.view.*

class BeritaAdapter (var article : ArrayList<Berita>?) : RecyclerView.Adapter<BeritaAdapter.BeritaHolder>() {
    class BeritaHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val img = itemView.itemImg
        val textJudul = itemView.itemJudul
        val textPenulis = itemView.itemPenulis

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_berita,parent,false)

        val holder=BeritaHolder(view)
        return holder
    }

    override fun getItemCount(): Int {

        return article?.size ?: 0
    }

    override fun onBindViewHolder(holder: BeritaHolder, position: Int) {

        holder.textJudul.text=article?.get(position)?.title
        holder.textPenulis.text=article?.get(position)?.author

        Glide.with(holder.itemView.context).load(article?.get(position)?.urlToImage).into(holder.img)

        holder.itemView.setOnClickListener{

            val intent = Intent(holder.itemView.context,DetailBeritaActivity::class.java)

            intent.putExtra("judul", article?.get(position)?.title)
            intent.putExtra("penulis",article?.get(position)?.author)
            intent.putExtra("desk",article?.get(position)?.description)
            intent.putExtra("img",article?.get(position)?.urlToImage)
            holder.itemView.context.startActivity(intent)



        }


    }

}