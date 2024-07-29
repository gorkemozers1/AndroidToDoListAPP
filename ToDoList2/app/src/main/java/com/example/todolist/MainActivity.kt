// java/com/example/todolist2/MainActivity.kt
package com.example.todolist2 // Paket adı AndroidManifest.xml ile aynı olmalı

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.R

class MainActivity : AppCompatActivity() {
    private lateinit var editTextTask: EditText
    private lateinit var buttonAdd: Button
    private lateinit var listViewTasks: ListView
    private val taskList = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTask = findViewById(R.id.editTextTask)
        buttonAdd = findViewById(R.id.buttonAdd)
        listViewTasks = findViewById(R.id.listViewTasks)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)
        listViewTasks.adapter = adapter

        buttonAdd.setOnClickListener {
            val task = editTextTask.text.toString()
            if (task.isNotBlank()) {
                taskList.add(task)
                adapter.notifyDataSetChanged()
                editTextTask.text.clear()
            }
        }
    }
}

