package com.wttech.kolindemo.base

/**
 * @author LZY
 * @time 2020/10/26.
 */
enum class LogLevel(val id:Int) {
    V(11),
    D(12);

    fun getTag(): String {
        return "$id,$name"
    }
}

fun main(args: Array<String>) {
    println(LogLevel.V.getTag())
    LogLevel.values().map (::println)
    var init = Init(33)
    init.pr()
}

sealed class Player{//密封类
}

object Pause:Player()//密封类子类只能定义在密封类的文件里
class Init(val int:Int):Player(){
    fun pr(){
        println(int)
    }
}