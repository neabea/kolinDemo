package com.wttech.kolindemo.base

/**
 * @author LZY
 * @time 2020/10/20.
 */

fun main() {
    val arg1: Int = 1;
    val arg2: Int = 2;
    println("$arg1 + $arg2 = ${arg1 + arg2}")

    val str1: String = "hello"
    val str2: String = "hello"
    val str3: String = String(charArrayOf('h', 'e', 'l', 'l', 'o'))
    println(str1 == str2)
    println(str1 === str2)
    println(str1 == str3)//相当于equal
    println(str1 === str3)

    val name = getName()
    println(name?.length)//name是null 返回null

    val name1: String = getName() ?: "yes"// name是null 返回yes
    println(name1)
    println(name1.length)

    val value: String? = "yes1"
    println(value!!.length)//!! 确定value不是null
    println("----------")
    val parent: Parent = Child()
    if (parent is Child) {
        println(parent.getName())//只能类型转换
    }
    val parent1: Parent = Parent()
    println(parent1 as? Child)//将parent1转换为child ，失败返null

    val ranges: IntRange = 0..10//[0,100]
    for (i in ranges) {
        print("$i, ")
    }
    println("----------")
    val array1: IntArray = intArrayOf(1, 2, 3)
    val array2: Array<String> = arrayOf("a", "b")
    println(array1.size)
    for (i in array1) {
        print("$i, ")
    }
    println(array2[1])

}

fun getName(): String? {//? 可以为null
    return null
}

open class Parent() {

}

class Child : Parent() {
    fun getName(): String? {
        return "child"
    }
}