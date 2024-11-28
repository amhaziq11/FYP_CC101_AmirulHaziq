package com.example.testerapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RiceMenuActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rice_menu)

        sharedPreferences = getSharedPreferences("MenuQuantities", Context.MODE_PRIVATE)

        // Menu item buttons and quantity
        val btnAddItem7: Button = findViewById(R.id.btnAddItem7)
        val btnRemoveItem7: Button = findViewById(R.id.btnRemoveItem7)
        val txtQuantityItem7: TextView = findViewById(R.id.txtQuantityItem7)

        // Done button
        val btnDoneRice: Button = findViewById(R.id.btnDoneRice)

        // Load saved quantity for item 7
        var quantityItem7 = sharedPreferences.getInt("Mui Fan rice", 0)
        txtQuantityItem7.text = quantityItem7.toString()

        // Update quantity and save to SharedPreferences
        btnAddItem7.setOnClickListener {
            quantityItem7++
            txtQuantityItem7.text = quantityItem7.toString()
            saveQuantity("Mui Fan rice", quantityItem7)
        }

        btnRemoveItem7.setOnClickListener {
            if (quantityItem7 > 0) {
                quantityItem7--
                txtQuantityItem7.text = quantityItem7.toString()
                saveQuantity("Mui Fan rice", quantityItem7)
            }
        }

        // Done button action
        btnDoneRice.setOnClickListener {
            finish() // Closes the current activity
        }
    }

    private fun saveQuantity(key: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }
}
