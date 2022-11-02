package com.example.generatenewviewfromcode

interface Screen {
    fun maxWidth(): Int
    fun maxHeight(): Int

    class GameZone() : Screen {
        private var width = 0
        private var height = 0

        override fun maxWidth(): Int = width
        override fun maxHeight(): Int = height

        fun init(
            width: Int,
            height: Int
        ): Boolean {
            if (width > 0 && height > 0) {
                this.width = width
                this.height = height
            } else return false
            return true
        }
    }
}