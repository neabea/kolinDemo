package com.wttech.kolindemo.base2

import android.os.Build
import androidx.annotation.RequiresApi

/**
 * @author LZY
 * @time 2021/6/24.
 */
@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    println("--------- list --------")
    val  list = listOf("javk","margy","lucy")
    println(list.getOrElse(3){"unknow"}) //数组越界
    println(list.getOrNull(3)?:"unknow") //数组越界
    val  list2 = listOf("javk","margy","margy111","lucy").toMutableList()
    list2.removeIf{it.contains("margy")}
    list2 += "jim"
    println(list2)
    list.forEachIndexed { index, item ->
        println("${index} , ${item}")
    }
    println("--------- map --------")
    var map = mutableMapOf("jack" to 20,"lucy" to 13)
    map.put("mac",44)
    println(map["jack"])
    println(map.getValue("jack"))
    println(map.getOrElse("jack"){"unknow"})
    println(map.getOrDefault("jacs",-1))
    map.forEach { (key:String,value:Int)->
        println("${key} ${value}")
    }
    println(map.getOrPut("rose"){11})//没有put进去数据
}