package com.example.testerapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Main_Menu_Page : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu_page)

        sharedPreferences = getSharedPreferences("MenuQuantities", Context.MODE_PRIVATE)

        // Chicken Chop
        handleMenuItem(
            "Chicken Chop",
            R.id.btnAddItem1,
            R.id.btnRemoveItem1,
            R.id.txtQuantityItem1
        )

        // Fish and Chips
        handleMenuItem(
            "Fish And Chips",
            R.id.btnAddItem2,
            R.id.btnRemoveItem2,
            R.id.txtQuantityItem2
        )

        // Done button
        val btnDoneMainMenu: Button = findViewById(R.id.btnDoneMainMenu)
        btnDoneMainMenu.setOnClickListener {
            finish() // Closes the current activity
        }
    }

    private fun handleMenuItem(
        key: String,
        addButtonId: Int,
        removeButtonId: Int,
        quantityTextViewId: Int
    ) {
        val btnAdd: Button = findViewById(addButtonId)
        val btnRemove: Button = findViewById(removeButtonId)
        val txtQuantity: TextView = findViewById(quantityTextViewId)

        var quantity = sharedPreferences.getInt(key, 0)
        txtQuantity.text = quantity.toString()

        btnAdd.setOnClickListener {
            quantity++
            txtQuantity.text = quantity.toString()
            saveQuantity(key, quantity)
        }

        btnRemove.setOnClickListener {
            if (quantity > 0) {
                quantity--
                txtQuantity.text = quantity.toString()
                saveQuantity(key, quantity)
            }
        }
    }

    private fun saveQuantity(key: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }
}
