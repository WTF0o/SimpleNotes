package com.example.simplenotes

import MainAdapter
import MainAdapter.Callback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val items: MutableList<Note> = mutableListOf<Note>()
    private lateinit var adapter: MainAdapter
    private var positionNote: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.add(Note("Тест"   , false , "Тест"))
        items.add(Note("Тест2"  , false , "Тест2"))
        items.add(Note("Тест3"  , false , "Тест3"))

        val gridLayout = GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false)
        recycler?.layoutManager = gridLayout

        adapter = MainAdapter(items, object : Callback {
            override fun onItemClicked(item: Note) {
                positionNote = items.indexOf(item)
            }
        })
        recycler.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.add_note -> {
                items.add(Note("Тест4", false, "Тест4"))
                adapter.notifyDataSetChanged()
            }
            R.id.remove_note -> {
                if (items.size > 0) {
                    adapter.notifyItemRemoved(positionNote)
                    items.removeAt(positionNote)
                } else {
                    val toast = Toast.makeText(applicationContext, "У вас нет заметок", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER,0 ,0)
                    toast.show()
                }
            }
        }
        return super.onOptionsItemSelected(item)

    }
}