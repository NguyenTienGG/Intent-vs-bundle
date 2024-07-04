package com.example.b14l2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.b14l2.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    private lateinit var binding:Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //get du lieu tư main
        val i = intent
        val bundle = i.extras
        if (bundle != null) {
            val name1 = bundle.getString("name")
            val age1 = bundle.getInt("age")
            val isStudent1 = bundle.getBoolean("isStudent")
            val number1 = bundle.getInt("number")

            binding.edtGetIntent.setText("Name: $name1\nAge: $age1\nIs Student: $isStudent1\nNumber: $number1")
        }



//        val name1 = i.getStringExtra("name")
//        val age1 = i.getDoubleExtra("age", 0.0)
//        val isStudent1 = i.getBooleanExtra("isStudent", false)
//
//        binding.edtGetIntent.setText("Name: $name1\nAge: $age1\nIs Student: $isStudent1")


        binding.btnback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        // Nhận dữ liệu



    }
}
