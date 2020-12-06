package com.example.simplenotes

import MainAdapter
import MainAdapter.Callback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = mutableListOf<Note>()

        items.add(Note("Тест", false,"Макар пидр"))
        items.add(Note("Тест2", false,"Макар пидр2"))
        items.add(Note("Тест3", false,"Макар пидр3"))

        val gridLayout = GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false)
        recycler?.layoutManager = gridLayout

        val adapter = MainAdapter(items, object : Callback {
            override fun onItemClicked(item: Note) {

            }
        })
        recycler.adapter = adapter


    }
}