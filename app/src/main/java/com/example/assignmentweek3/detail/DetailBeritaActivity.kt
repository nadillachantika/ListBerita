package com.example.assignmentweek3.detail

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.assignmentweek3.R

import kotlinx.android.synthetic.main.activity_detail_berita.*
import kotlinx.android.synthetic.main.content_detail_berita.*

class DetailBeritaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)
        setSupportActionBar(toolbar)


        val desk = intent.getStringExtra("desk")
        val judul = intent.getStringExtra("judul")
        val penulis = intent.getStringExtra("penulis")
        val img = intent.getStringExtra("img")

        jdlDetail.text = judul
        penulisDetail.text = penulis
        deskDetail.text = desk


        Glide.with(this).load(img).into(imgDetail)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

}
