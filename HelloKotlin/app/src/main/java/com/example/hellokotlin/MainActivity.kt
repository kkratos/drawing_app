package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val btn_click_me = findViewById(R.id.button) as Button
        //val myText = findViewById(R.id.hello) as TextView

        var timesClicked = 0
        button.setOnClickListener{
            timesClicked = timesClicked + 1
            hello.text = timesClicked.toString();
            Toast.makeText(this@MainActivity, "You clicked me", Toast.LENGTH_SHORT).show()};

    }
}