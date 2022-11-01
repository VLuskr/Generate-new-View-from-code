package com.example.generatenewviewfromcode

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myLayout = findViewById<ConstraintLayout>(R.id.main)
        val myButton = Button(this)

        val lp = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT,
        )

        ConstraintLayout.LayoutParams(lp)
        myLayout.addView(myButton)

        myButton.text = "Button"
        myButton.translationX = 100f

    }

}