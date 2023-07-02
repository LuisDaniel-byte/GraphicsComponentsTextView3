package com.example.graphicscomponents4

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MySecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_my_second)
    }

    override fun onResume() {
        super.onResume()

        //Toast.makeText(this, "Hola", Toast.LENGTH_LONG).show()
    }
}