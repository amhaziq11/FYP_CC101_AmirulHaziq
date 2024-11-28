package com.example.testerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.testerapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Array of button IDs
        val buttonIds = arrayOf(
            R.id.btnTable1, R.id.btnTable2, R.id.btnTable3,
            R.id.btnTable4, R.id.btnTable5, R.id.btnTable6,
            R.id.btnTable7, R.id.btnTable8, R.id.btnTable9, R.id.btnTable10
        )

        // Set click listeners for each button
        buttonIds.forEachIndexed { index, buttonId ->
            findViewById<Button>(buttonId).setOnClickListener {
                val tableNumber = index + 1 // Table numbers start from 1
                val intent = Intent(this, Selection_Menu::class.java).apply {
                    putExtra("TABLE_NUMBER", tableNumber.toString())
                }
                startActivity(intent)
            }
        }
    }
}
