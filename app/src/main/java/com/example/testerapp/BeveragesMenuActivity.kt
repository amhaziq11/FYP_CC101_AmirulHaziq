package com.example.testerapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BeveragesMenuActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beverages_menu)

        sharedPreferences = getSharedPreferences("MenuQuantities", Context.MODE_PRIVATE)

        // Matcha Latte Item
        val btnAddItem8: Button = findViewById(R.id.btnAddItem8)
        val btnRemoveItem8: Button = findViewById(R.id.btnRemoveItem8)
        val txtQuantityItem8: TextView = findViewById(R.id.txtQuantityItem8)

        var quantityItem8 = sharedPreferences.getInt("Matcha latte", 0)
        txtQuantityItem8.text = quantityItem8.toString()

        btnAddItem8.setOnClickListener {
            quantityItem8++
            txtQuantityItem8.text = quantityItem8.toString()
            saveQuantity("Matcha latte", quantityItem8)
        }

        btnRemoveItem8.setOnClickListener {
            if (quantityItem8 > 0) {
                quantityItem8--
                txtQuantityItem8.text = quantityItem8.toString()
                saveQuantity("Matcha latte", quantityItem8)
            }
        }

        // Thai Tea Item
        val btnAddItem9: Button = findViewById(R.id.btnAddItem9)
        val btnRemoveItem9: Button = findViewById(R.id.btnRemoveItem9)
        val txtQuantityItem9: TextView = findViewById(R.id.txtQuantityItem9)

        var quantityItem9 = sharedPreferences.getInt("Thai tea", 0)
        txtQuantityItem9.text = quantityItem9.toString()

        btnAddItem9.setOnClickListener {
            quantityItem9++
            txtQuantityItem9.text = quantityItem9.toString()
            saveQuantity("Thai tea", quantityItem9)
        }

        btnRemoveItem9.setOnClickListener {
            if (quantityItem9 > 0) {
                quantityItem9--
                txtQuantityItem9.text = quantityItem9.toString()
                saveQuantity("Thai tea", quantityItem9)
            }
        }

        // Done Button
        val btnDoneBeverages: Button = findViewById(R.id.btnDoneBeverages)
        btnDoneBeverages.setOnClickListener {
            finish() // Closes the current activity
        }
    }

    private fun saveQuantity(key: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }
}
