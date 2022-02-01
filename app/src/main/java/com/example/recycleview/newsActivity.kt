package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class newsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        val headingnews:TextView=findViewById(R.id.text_heading)
        val mainnews:TextView=findViewById(R.id.text_news)
        val imagenews:ImageView =findViewById(R.id.img_news)

        val bundle:Bundle?=intent.extras
        val heading=bundle!!.getString("heading")
        val imageId=bundle.getInt("imageId")
        val news=bundle!!.getString("news")

        headingnews.text=heading

        mainnews.text=news
        imagenews.setImageResource(imageId)

    }
}