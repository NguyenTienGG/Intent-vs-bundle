package com.example.b14l2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.b14l2.databinding.ActivityMainBinding


private lateinit var binding:ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //activity 2
        binding.btnGo1.setOnClickListener {
            val intent1 = Intent(this, Activity2::class.java)
            // truyen du liêu bằng bundle
            val bundle = Bundle()
            bundle.putString("name", "Nguyen Van A")
            bundle.putInt("age", 20)
            bundle.putBoolean("isStudent", true)
            bundle.putInt("number", 100)

            //đặt bundle vào intent
            intent1.putExtras(bundle)

                // truyền dữ liệu
//            intent1.putExtra("name", "Nguyen Van A")
//            intent1.putExtra("age", 20)
//            intent1.putExtra("isStudent", true)

            startActivity(intent1)
        }

        binding.btnGo2.setOnClickListener {
            val intent2 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"))
            startActivity(intent2)
        }

    }
}