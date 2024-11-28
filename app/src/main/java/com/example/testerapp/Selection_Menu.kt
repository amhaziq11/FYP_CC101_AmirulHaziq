package com.example.testerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Selection_Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_menu)

        // Buttons for menu types
        val btnMain: Button = findViewById(R.id.btnMain)
        val btnNoodles: Button = findViewById(R.id.btnNoodles)
        val btnPastas: Button = findViewById(R.id.btnPastas)
        val btnRice: Button = findViewById(R.id.btnRice)
        val btnBeverages: Button = findViewById(R.id.btnBeverages)
        val btnOverviewOrder: Button = findViewById(R.id.btnOverviewOrder)

        // Navigate to respective activity for each menu type
        btnMain.setOnClickListener {
            val intent = Intent(this, Main_Menu_Page::class.java)
            intent.putExtra("MENU_TYPE", "Main")
            startActivity(intent)
        }

        btnNoodles.setOnClickListener {
            val intent = Intent(this, NoodlesMenuActivity::class.java)
            intent.putExtra("MENU_TYPE", "Noodles")
            startActivity(intent)
        }

        btnPastas.setOnClickListener {
            val intent = Intent(this, PastasMenuActivity::class.java)
            intent.putExtra("MENU_TYPE", "Pastas")
            startActivity(intent)
        }

        btnRice.setOnClickListener {
            val intent = Intent(this, RiceMenuActivity::class.java)
            intent.putExtra("MENU_TYPE", "Rice")
            startActivity(intent)
        }

        btnBeverages.setOnClickListener {
            val intent = Intent(this, BeveragesMenuActivity::class.java)
            intent.putExtra("MENU_TYPE", "Beverages")
            startActivity(intent)
        }

        btnOverviewOrder.setOnClickListener {
            // Navigate to Order Overview
            val intent = Intent(this, OrderOverviewActivity::class.java)
            startActivity(intent)
        }
    }
}
