package com.example.testerapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NoodlesMenuActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noodles_menu)

        sharedPreferences = getSharedPreferences("MenuQuantities", Context.MODE_PRIVATE)

        // Menu item buttons and quantity
        val btnAddItem3: Button = findViewById(R.id.btnAddItem3)
        val btnRemoveItem6: Button = findViewById(R.id.btnRemoveItem6)
        val txtQuantityItem6: TextView = findViewById(R.id.txtQuantityItem6)

        // Done button
        val btnDoneNoodles: Button = findViewById(R.id.btnDoneNoodles)

        // Load saved quantity for item 6
        var quantityItem6 = sharedPreferences.getInt("Ginger Beef Kuey Teow", 0)
        txtQuantityItem6.text = quantityItem6.toString()

        // Update quantity and save to SharedPreferences
        btnAddItem3.setOnClickListener {
            quantityItem6++
            txtQuantityItem6.text = quantityItem6.toString()
            saveQuantity("Ginger Beef Kuey Teow", quantityItem6)
        }

        btnRemoveItem6.setOnClickListener {
            if (quantityItem6 > 0) {
                quantityItem6--
                txtQuantityItem6.text = quantityItem6.toString()
                saveQuantity("Ginger Beef Kuey Teow", quantityItem6)
            }
        }

        // Done button action
        btnDoneNoodles.setOnClickListener {
            finish() // Closes the current activity
        }
    }

    private fun saveQuantity(key: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }
}
