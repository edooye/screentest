package com.example.test3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity:AppCompatActivity() {

    private lateinit var tvName : TextView
    private lateinit var btnEvent : Button
    private lateinit var btnGuest : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvName = findViewById(R.id.tv_name)
        btnEvent = findViewById(R.id.btn_event)
        btnGuest = findViewById(R.id.btn_guest)


        val name = intent.getStringExtra("name")
        tvName.text = "Hallo," + name

        btnEvent.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        btnGuest.setOnClickListener {
            val intent = Intent(this, FourActivity::class.java)
            startActivity(intent)
        }




    }

}