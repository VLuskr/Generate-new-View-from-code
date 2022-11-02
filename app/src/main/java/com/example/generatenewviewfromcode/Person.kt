package com.example.generatenewviewfromcode

import android.view.View
import android.widget.ImageView

interface Person {

    fun init()
    fun move()

}

class SkyDriver(
    val imageView: ImageView
) : Person {
    private var positionX = 0
    private var positionY = 0
    private var deltaX = 0
    private var deltaY = 5

    public fun setX(x: Int) {
        positionX = x
    }

    override fun init() {
        imageView.setImageResource(R.drawable.red_among)
        imageView.adjustViewBounds = true
        imageView.maxHeight = 100
        imageView.maxWidth = 100
        imageView.translationX = positionX.toFloat()
        imageView.translationY = positionY.toFloat()
    }

    override fun move() {
        imageView.translationX += deltaX
        imageView.translationY += deltaY
    }
}