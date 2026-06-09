package com.example.numberstoragewitharrays

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Array of size 10 to store values
        val numbers = Array(10) { 0 }
        var counter = 0

        val edtInput = findViewById<EditText>(R.id.edtInput)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        Log.d("", "Array app loaded — size: ${numbers.size}")

        btnSave.setOnClickListener {
            // Check if array is full
            if (counter >= numbers.size) {
                tvResult.text = "Array is full! No more values can be stored."
                Log.d("", "Array full — cannot store more values")
                btnSave.isEnabled = false
                btnSave.alpha = 0.5f
                return@setOnClickListener
            }

            val input = edtInput.text.toString().toIntOrNull()

            if (input == null) {
                tvResult.text = "Please enter a valid number!"
                Log.d("", "Invalid input")
                return@setOnClickListener
            }

            // Store value at current counter position
            numbers[counter] = input
            counter++

            Log.d("", "Stored $input at position ${counter - 1}")

            val remaining = numbers.size - counter
            tvResult.text = "Saved! $counter/10 slots used. $remaining remaining."

            edtInput.text.clear()
        }
    }
}
