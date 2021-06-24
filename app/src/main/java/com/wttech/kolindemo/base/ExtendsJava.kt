package com.wttech.kolindemo.base

import java.lang.StringBuilder

/**
 * @author LZY
 * @time 2020/10/23.
 */


fun main(args: Array<String>) {
        println("abc".multi(5))
}


fun String.multi(int: Int):String{
    var StringBuilder = StringBuilder()
    for(i in 0 until int){
        StringBuilder.append(this)
    }
    return StringBuilder.toString()
}

val String.a:String //扩展成员 ，类似接口属性
    get() {
       return "aaa"
    }
