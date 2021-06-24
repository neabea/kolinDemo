package com.wttech.kolindemo.base

import java.lang.Exception

/**
 * @author LZY
 * @time 2020/10/21.
 */
fun main(args: Array<String>) {
    val arrays: Array<String> = arrayOf("a", "b", "c")

    println(sum(1, 4))//invoke

    run Test@{
        arrays.forEach {
            if (it == "b") return@Test //return main函数 得加@
            println(it)
        }//it 代表 iterator
    }

    println("-------")
    arrays.forEach(::println)
    println(printHello())

    println("成员变量-------")
    val a = A()
    println(a.d?.length)
    a.c = "c"
    println(a.c)//必须初始化
    a.e.show()

    println("表达式-------")
    var str1 = "a"
    when {
        str1 == "a" -> {
            str1 = "aa"
            println(str1)
        }
        str1 == "b" -> {
            println(str1)
        }
        else -> {
            println("default")
        }
    }

    var list = arrayListOf<Int>()
    list.add(11)
    list.add(12)
    list.add(13)
    for (l1 in list) {
        print("$l1, ")
    }
    println()
    for ((index, value) in list.withIndex()) {
        println("$index ,$value ")
    }
    println("异常-------")
    try {
        args[0].toInt()
    } catch (e: Exception) {
//        e.printStackTrace()
        println("异常" + e.message)
    }
    println("变长参数-------")
    hello(3.0, 1, 2, 3, s = "str")
    var arrays2 = intArrayOf(5, 6, 7)
    hello(ints = *arrays2, s = "str2")
    println(Oper("+").apply(3.0, 1.0))
}

val sum = { arg1: Int, arg2: Int ->
    println("$arg1+$arg2=${arg1 + arg2}")
    arg1 + arg2
}//(Int Int)-> Int

fun printHello() {
    println("hello")
}

class A {
    var b = 0
    lateinit var c: String
    var d: String? = null
    val e: X by lazy { //val 必须初始化
        X()
    }
    val f = listOf(1, 3, 4, 5, 6, 7, 9)
}

class X {
    fun show() {
        println("X show")
    }
}

fun hello(d: Double = 1.0, vararg ints: Int, s: String) {//vararg 变长参数 不是最后一个 最后一个参数需要具名
    println(d)
    ints.forEach(::println)
    println(s)
}

class Oper(op: String) {
    var opFun: (left: Double, right: Double) -> Double = { left, right -> left + right }

    init {
        opFun = when (op) {
            "+" -> { l, r -> l + r }
            else -> { l, r -> l - r }
        }
    }

    fun apply(left: Double, right: Double): Double {
        return opFun(left, right)
    }

}