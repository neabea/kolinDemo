package com.wttech.kolindemo.base2

/**
 * @author LZY
 * @time 2021/6/23.
 */
fun main() {
    //空合并操作符?:
    var str: String? = null
    str = str?.let {
        it.capitalize()
    } ?: "jack"
    println(str)
//    println(str?:"jack")

    str = "hello, worlds"
    val data: List<String> = str.split(",")
    println("${data[0]} ${data[1]} ")

    val num1: Int? = "8.7".toIntOrNull()
    println(num1)
    println("--------- let 判空 返回最后一行， apply 调用方法返回自己 ，also 类似let 返回原始对象 --------")
    var str2: Int? = 3
    str2 = str2?.apply {
        println("str2:"+this*2)
    }?.let {
        (it + 2) * it
    }
    println(str2)
    str2 = str2?.also { it * 2 }?.also { it * 3 }
    println(str2)
    println("--------- run 返回最后lamda结果 --------")
    var result = "test".run {
        contains("te")
    }
    println(result)
    var result2 = "test".run {
        length > 10
    }
    println(result2)
    println("--------- with 值参作为第一个参数调用 --------")
    var result3 = with("test") {
        length > 10
    }
    println(result3)
    println("--------- takeif true返回接受者对象  false返回null --------")
    println("test".takeIf { it.contains("te") })
    println("test".takeIf { it.contains("r") })
}