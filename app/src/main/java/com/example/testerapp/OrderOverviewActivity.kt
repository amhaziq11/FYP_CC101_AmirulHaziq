package com.example.testerapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class OrderOverviewActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var txtOrderSummary: TextView
    private lateinit var btnConfirmOrder: Button
    private lateinit var btnDone: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_overview)


        txtOrderSummary = findViewById(R.id.txtOrderSummary)
        btnConfirmOrder = findViewById(R.id.btnConfirmOrder)
        btnDone = findViewById(R.id.btnDone)

        sharedPreferences = getSharedPreferences("MenuQuantities", Context.MODE_PRIVATE)

        displayOrderSummary()

        btnConfirmOrder.setOnClickListener {
            Toast.makeText(this, "Order Confirmed!", Toast.LENGTH_SHORT).show()
        }

        btnDone.setOnClickListener {
            with(sharedPreferences.edit()) {
                clear()
                apply()
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun displayOrderSummary() {
        val allItems = sharedPreferences.all
        val orderSummary = StringBuilder()
        var hasOrders = false

        allItems.forEach { (key, value) ->
            if (value is Int && value > 0) {
                orderSummary.append("$key: $value\n")
                hasOrders = true
            }
        }

        txtOrderSummary.text =
            if (hasOrders) orderSummary.toString() else "No items in your order."
    }
}
