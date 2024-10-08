package com.chelsi.buahmovie

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chelsi.buahmovie.Adapter.BuahAdapter
import com.chelsi.buahmovie.model.MockList
import com.chelsi.buahmovie.model.ModelBuah

class CustomImage : AppCompatActivity() {
    private lateinit var rv_buah : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_image)

        rv_buah = findViewById(R.id.rv_data)

        rv_buah.layoutManager = GridLayoutManager(this,1,
            GridLayoutManager.VERTICAL,false)

        val adapter = BuahAdapter(MockList.getModel() as ArrayList<ModelBuah>, this)
        rv_buah.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}