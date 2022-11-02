package com.example.generatenewviewfromcode

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import android.widget.Button
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    val gameZone = Screen.GameZone()
    var arrayAlien: ArrayList<SkyDriver> = arrayListOf()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        layoutSize()    // set screen size

        cycle(30)


    }

    fun btOnClickAddAlien(view: View) {
        val imageView = createImageView()
        val newSkyDriver = SkyDriver(imageView)
        newSkyDriver.init()
        arrayAlien.add(newSkyDriver)
    }

    private fun layoutSize() {

        val layout = findViewById<ConstraintLayout>(R.id.main)

        layout.viewTreeObserver.addOnGlobalLayoutListener(
            object : OnGlobalLayoutListener {
                override fun onGlobalLayout() {
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                        layout.viewTreeObserver.removeGlobalOnLayoutListener(this)
                    } else {
                        layout.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    }
                    val height = layout.measuredHeight
                    val width = layout.measuredWidth
                    val initStatus = gameZone.init(width, height)
                    Log.d(
                        "MyLog", "Screen init status is ${initStatus.toString().uppercase()}: " +
                                "${gameZone.maxWidth()} x ${gameZone.maxHeight()}"
                    )
                }
            })
    }


    private fun cycle(second: Long) {
        val timer = object : CountDownTimer(second * 1000, 50) {
            override fun onTick(p0: Long) {

                if (arrayAlien.size > 0)
                    arrayAlien.forEach { it.move() }
            }

            override fun onFinish() {
                finish()
            }
        }
        timer.start()
    }

    private fun createImageView(): ImageView {
        val myLayout = findViewById<ConstraintLayout>(R.id.main)
        val imageView = ImageView(this)

        val lp = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )

        ConstraintLayout.LayoutParams(lp)
        myLayout.addView(imageView)

        return imageView
    }


}