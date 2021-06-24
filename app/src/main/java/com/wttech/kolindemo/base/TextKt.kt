package com.wttech.kolindemo.base

/**
 * @author LZY
 * @time 2020/10/26.
 */
fun main(args: Array<String>) {
    val et = Delegates()
    println(et.hello)
    et.hello = "099"
    println(et.hello)
}

