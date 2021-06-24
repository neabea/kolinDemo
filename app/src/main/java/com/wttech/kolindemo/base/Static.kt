package com.wttech.kolindemo.base

/**
 * @author LZY
 * @time 2020/10/22.
 */

fun main(args: Array<String>) {
    val sc1 = StaticClass.ofInt(11)
    println(StaticClass.ofValues(sc1))
    println(StaticClass.TAG)
}

class StaticClass constructor(val value:Int){
    companion object{
        @JvmField
        val TAG:String="this.StaticClass"

        @JvmStatic
        fun ofInt(int:Int):StaticClass{
            println("ofInt："+int)
            return StaticClass(int)
        }

        fun print(string: String){
            println("string："+string)
        }

        fun ofValues(staticClass: StaticClass):StaticClass{//拷贝
            println("ofValues："+staticClass.value)
            return StaticClass(staticClass.value)
        }
    }
}