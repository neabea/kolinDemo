package com.wttech.kolindemo.base

/**
 * @author LZY
 * @time 2020/10/26.
 */
open class Outer {
    inner class Inner {
        fun a() {
            this@Outer
        }
    }
}

interface OnclickListeners {
    fun onClick()
}

class Views {
    var onclickListeners: OnclickListeners? = null
}

fun main(args: Array<String>) {
    val inner = Outer().Inner()
    val views = Views()
    views.onclickListeners = object : Outer(), OnclickListeners {
        //匿名内部类可以继承
        override fun onClick() {
            TODO("Not yet implemented")
        }
    }
}