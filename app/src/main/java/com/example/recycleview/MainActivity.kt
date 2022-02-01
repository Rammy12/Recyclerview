package com.example.recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var newRecyclerview:RecyclerView
    private lateinit var newsArraylist:ArrayList<News>
    lateinit var imageId:Array<Int>
    lateinit var heading:Array<String>
    lateinit var tv_news:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageId= arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j


        )
        heading= arrayOf(
            "बिहार में वीडियो वायरल कर बोली बेटी- पापा परेशान मत होइए, बस एक बात का ख्याल रखिएगा",
            "सीएम नीतीश कुमार की योजना को जदयू के नेता ही मिट्टी में मिला रहे, मुजफ्फरपुर का मामला",
            "निर्मला सीतारमण आज पेश करेंगी बजट, स्वास्थ्य क्षेत्र और बुनियादी ढांचे समेत इन मुद्दों पर रहेगा जोर",
            "उत्तर भारत के अधिकांश हिस्सों में बारिश के आसार, फरवरी माह भी रहेगा ठंडा",
            "यूपी विधानसभा चुनाव का पांचवां चरण : 12 जिलों की 61 सीटों के लिए आज जारी होगा नोटिफिकेशन",
            "लुक और फीचर्स के मामले में लाजवाब है Honda Amaze, फैमिली को मिलेगा शानदार अनुभव",
            "होली से पहले भारतीय रेलवे ने दी बड़ी राहत, कई ट्रेनों में लगाएगा अतिरिक्त बोगियां; देखें; लिस्ट",
            " बढ़े शिक्षा का बजट, गर्ल्स एजुकेशन, ई-लर्निंग पर फोकस सहित जानिए वित्त मंत्री से और क्या-क्या हैं आस",
            "रूस और यूक्रेन के बीच युद्ध हुआ तो पूरी दुनिया को चुकानी होगी इसकी कीमत",
            "आज से शुरू हो रहा है संसद का बजट सत्र, दोनों सदनों को संबोधित करेंगे राष्ट्रपति"
        )
        tv_news= arrayOf(
            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c),
            getString(R.string.news_d),
            getString(R.string.news_e),
            getString(R.string.news_f),
            getString(R.string.news_g),
            getString(R.string.news_h),
            getString(R.string.news_i),
            getString(R.string.news_j)

        )
        newRecyclerview=findViewById(R.id.recycle_view)
        newRecyclerview.layoutManager=LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)
        newsArraylist= arrayListOf<News>()
        getUserdata()
    }

    private fun getUserdata() {
        for(i in imageId.indices)
        {
            val news=News(imageId[i],heading[i])
            newsArraylist.add(news)
        }
        var adepter=Adepter(newsArraylist)
        newRecyclerview.adapter=adepter
        adepter.setOnItemClicklistener(object:Adepter.onItemClicklistener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@MainActivity,"you clicked on item no.${position+1}",Toast.LENGTH_SHORT).show()
                val i=Intent(this@MainActivity,newsActivity::class.java)
                i.putExtra("heading",newsArraylist[position].heading)
                i.putExtra("imageId",newsArraylist[position].titleImage)
                i.putExtra("news",tv_news[position])
                startActivity(i)
            }

        })
    }
}