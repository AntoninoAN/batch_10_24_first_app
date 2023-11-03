package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var btnSaveTodo: Button
    private lateinit var etInputTodo: EditText
    private lateinit var lvDisplayTodo: ListView
    private lateinit var adapter: ArrayAdapter<String>

    /**
     * OnCreate
     * It will be invoked ONLY ONCE per lifecycle.
     * Used to initialize views and other references.
     * It will invoke the method setContentView(Layout)
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSaveTodo = findViewById(R.id.btn_save_todo)
        //etInputTodo = findViewById(R.id.todo_input)
        lvDisplayTodo = findViewById(R.id.lv_display_todos)


        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1
        )
        lvDisplayTodo.adapter = adapter

        // Anonymous listener
        btnSaveTodo.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    // here
                }
            }
        )
        // Interface Implementation
        btnSaveTodo.setOnClickListener(this)

        // XML reference.
        //android:onClick = "methodName"

        // Method reference
        btnSaveTodo.setOnClickListener(::foo)

        // Lambdas
        btnSaveTodo.setOnClickListener {
            val openCreateActivity = Intent()
            openCreateActivity.setClass(this,
                CreateTodoActivity::class.java)
            startActivityForResult(
                openCreateActivity,
                1166
            )

//            val todoInput =
//                etInputTodo.text.toString()
//
//            if (todoInput.isNotEmpty()
//                && todoInput.isNotBlank())
//                updateTodoList(todoInput)
//            else
//                Toast.makeText(
//                    this,
//                    "No empty todos",
//                    Toast.LENGTH_SHORT)
//                    .show()
//            // clean
//            etInputTodo.text.clear()
        }
    }

    private fun updateTodoList(newTodo: String) {
        adapter.add(newTodo)


    }

    override fun onClick(v: View?) {
        main()
        foo()
    }

    private fun foo(kdkdkdkd: View) {}

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1166 &&
            resultCode == RESULT_OK &&
            data != null) {

            val newTodo = data.getStringExtra("NewTodo")
            Log.d(TAG, "onActivityResult: $newTodo")
            adapter.add(newTodo)
        }
    }

    /**
     * OnStart
     * Immediately called after the layout is "render"
     * You will see the UI but it will not be interactive.
     * We use it to update references that are not default,
     * like the user name to replace a placeholder.
     */
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    /**
     * OnResume
     * All the view and ui events are connected.
     * Usually we connect any "observable" or data result
     * to update the UI.
     */
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    /**
     * OnPause
     * Called when the Activity is "moving out". The UI is
     * still visible but not interactive.
     * Also called when there is a Dialog (popup) in the screen.
     * Use it to "save" or starting to save data.
     */
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    /**
     * OnStop
     * Last warrantied callback to be invoked.
     * The Activity will be soon being disposed.
     * Used to clean up and disconnect references.
     */
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    /**
     * OnDestroy
     * Is not warrantied to be invoked.
     * Used to signal this Activity is about to be disposed.
     * Not real use cases.
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

}
/*
1.- Create the variable references and init with the findViewByID
2.- Setup the UI events for those views that the user will interact.
Flow:
    User inputs a todo.
    User clicks in Save button.
    List view receives a new todo.
 */
















