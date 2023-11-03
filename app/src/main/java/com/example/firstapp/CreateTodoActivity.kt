package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

private const val TAG = "CreateTodoActivity"

class CreateTodoActivity : AppCompatActivity() {

    private lateinit var spCategoryTodo: Spinner
    private lateinit var tilNewTodo: TextInputLayout
    private lateinit var btnCreateTodo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        setContentView(R.layout.activity_create_todo)

        setupUI()
    }

    private fun setupUI() {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.categories_default)
        )
        spCategoryTodo = findViewById(R.id.sp_todo_category)
        btnCreateTodo = findViewById(R.id.btn_save_todo)
        tilNewTodo = findViewById(R.id.til_new_todo)

        spCategoryTodo.adapter = adapter

        btnCreateTodo.setOnClickListener {
            val newTodo =
                tilNewTodo.editText?.text.toString()

            if (newTodo.isNotEmpty() &&
                newTodo.isNotBlank() &&
                newTodo != "null") {
                sendDataBack(newTodo)
            } else {
                showSnackBar()
            }
        }
    }

    private fun sendDataBack(newTodo: String) {
        val selectedCategory =
            spCategoryTodo.selectedItem.toString()


        setResult(RESULT_OK,
            Intent().apply {
                putExtra("NewTodo", newTodo)
                putExtra("NewCategory", selectedCategory)
            }
        )
        finish()
    }

    private fun showSnackBar() {
        Snackbar.make(
            findViewById(android.R.id.content),
            getString(R.string.no_empty_todos_please),
            Snackbar.LENGTH_INDEFINITE
        ).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }
}

