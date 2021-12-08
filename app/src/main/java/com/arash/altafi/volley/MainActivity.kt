package com.arash.altafi.volley

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arash.altafi.volley.java.JavaActivity
import com.arash.altafi.volley.kotlin.KotlinActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        btnKotlin.setOnClickListener {
            startActivity(Intent(this , KotlinActivity::class.java))
        }

        btnJava.setOnClickListener {
            startActivity(Intent(this , JavaActivity::class.java))
        }
    }

}