package com.example.test3

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var camera: Button
    private lateinit var gallery: Button
    private lateinit var imageView: ImageView
    private lateinit var name: EditText
    private lateinit var palindrom: EditText
    private lateinit var textView: TextView
    private lateinit var check: Button
    private lateinit var next: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        camera = findViewById(R.id.camera)
        gallery = findViewById(R.id.gallery)
        imageView = findViewById(R.id.image)
        name = findViewById(R.id.et_inputName)
        palindrom = findViewById(R.id.et_inputPalindrome)
        check = findViewById(R.id.palindrome)
        textView = findViewById(R.id.textView1)
        next = findViewById(R.id.next)

        val value = name.text.toString()
//        textView.text = value

        camera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 123)
        }

        gallery.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 456)
        }

        check.setOnClickListener {
           isPalindrom()
        }

        next.setOnClickListener {
                val intent = Intent(this, SecondActivity::class.java)
                    .putExtra("name",name.text.toString())
                startActivity(intent)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 123) {
            val bmp = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(bmp)
        } else if (requestCode == 456) {
            imageView.setImageURI(data?.data)
        }

    }

    private fun isPalindrom() {
        val value2 = palindrom.text.toString()
        val stringToCheck = arrayListOf(value2)
        for(string in stringToCheck) {
            if (string.replace("","").lowercase() == string.replace("","").lowercase().reversed()){
                textView.text = "is Palindrome"
            } else if (string.replace("","").lowercase() != string.replace("","").lowercase().reversed()){
                textView.text = "is Not Palindrome"
            }
        }
    }

// settext view
//    val value = name.text.toString()
//    textView.text = value


}