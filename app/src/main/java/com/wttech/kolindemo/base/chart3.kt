package com.wttech.kolindemo.base

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.OutputStream
import java.lang.StringBuilder

/**
 * @author LZY
 * @time 2020/12/3.
 */
fun main(args: Array<String>) {
    val arrays: Array<Int> = arrayOf(1, 2, 3, 1, 4)
    val pdf1 = PdfPrint::println
    val pdf = PdfPrint()
    var result = arrays.filter(pdf::isOne)
    println(result)
    args.filter(String::isNotEmpty)
    args.forEach(pdf::println)


    println("map---------")
    val list = listOf(1, 2, 3)
    val newList = ArrayList<Int>()
    list.forEach {
        val newElement = it * 2
        newList.add(newElement)
    }
    newList.forEach(::println)
    val newlist2 = list.map {
        it * 2
    }
    newlist2.forEach(::println)

    println("flatmap--------- 打平map")
    val list2 = listOf(
        1..5, 2..7, 10..13
    )
    val flatlist = list2.flatMap {
//        it.map { "No.$it" }
        it
    }
    flatlist.forEach(::println)
    println("求和" + flatlist.reduce { acc, s -> acc + s })
    println("阶乘--------")
    (0..6).map(::factorial).forEach(::println)
    println((0..6).map(::factorial).fold(5) { acc, i ->
        acc + i
    })
    println((0..6).map(::factorial).fold(StringBuilder()) { acc, i ->
        acc.append(i).append(";")
    })
    println("拼接字符串--------")
    println((0..6).joinToString(";"))
    println((0..6).map(::factorial).takeWhile { it % 2 == 1 })//取遇到奇数的前面的数据

    println("let 判空 返回最后一行， apply 调用方法返回自己--------")
    val person3 = findPerson3()//实际是null
    findPerson3()?.let {
        println(it.name)
        it.work()
    }
    findPerson3()?.apply {
        println(name)
        work()
    }
    val br = BufferedReader(FileReader("hello.txt"))
    with(br) {//with传参不能为null
        var line: String?
        while (true) {
            line = readLine() ?: break
            println(line)
        }
        close()
    }
    BufferedReader(FileReader("hello.txt")).use { //去除close() 注意it
        var line: String?
        while (true) {
            line = it.readLine() ?: break
            println(line)
        }
    }

    println("闭包--------")
    val add5 = adds(5)
    println(add5(2))
    val fibo = fibonacci()
    println(fibo())
    println(fibo())
    println(fibo())
    println(fibo())
    println(fibo())
    println("复合函数--------")
    println(multiply2(add10(3)))
//    var add109 = add10
//    val mut2 = multiply2(add10)
    val addmuti = intAdd10 addThen intMultiply2
    val addmuti2 = intAdd10 compose intMultiply2
    val ss = add10(3)
    println(addmuti(3))//f(g(x)) （3+10）* 2
    println(addmuti2(3))//g(f(x)) 3*2 + 10

    println("Curried 科理化--------")
    logs("zeyu",System.out,"测试")
    logsCurried("zeyu2")(System.out)("测试2")
    ::logs.curriends()("zeyu3")(System.out)("测试3")

    println("统计build.gradle字符个数demo--------")
    val maps = HashMap<Char,Int>()
    File("build.gradle").readText().toCharArray().filterNot (Char::isWhitespace).forEach{
        val count = maps[it]
        if(count==null){
            maps[it] = 1
        }else{
            maps[it] = count +1
        }
    }
    maps.forEach(::println)
    println("--------")
    File("build.gradle").readText().toCharArray().filterNot (Char::isWhitespace).groupBy { it }.map {
        it.key to it.value.size
    }.forEach(::println)
}

class PdfPrint {
    fun println(any: Any) {
        kotlin.io.println(any)
    }

    fun isOne(value: Int): Boolean {
        return value == 1
    }
}

fun findPerson3(): Person3? {
    return null
}

//阶乘
fun factorial(n: Int): Int {
    if (n == 0) return 1
    return (1..n).reduce { acc, i -> acc * i }
}

data class Person3(val name: String, val age: Int) {
    fun work() {
        println("work!")
    }
}

//fun adds2(x: Int) = fun(y: Int) = x + y
fun adds(x: Int): (Int) -> Int {
    return fun(y: Int): Int {
        return x + y
    }
}

fun fibonacci():()->Long{
    var first = 0L
    var second = 1L
    return fun ():Long{
        val result = second
        second += first
        first = second - first
        return result
    }
}

val intAdd10 = { i: Int -> i + 10 }//g(x)
val intMultiply2 = { i: Int -> i * 2 }//f(x)
fun add10(x: Int): Int = x + 10

fun multiply2(x: Int): Int {
    return x * 2
}

infix fun <P1, P2, R> Function1<P1, P2>.addThen(function: Function1<P2, R>): Function1<P1, R> {
    return fun(p1: P1): R {
        return function.invoke(this.invoke(p1))
    }
}

infix fun <P1, P2, R> Function1<P2, R>.compose(function: Function1<P1, P2>): Function1<P1, R> {
    return fun(p1: P1): R {
        return this.invoke(function.invoke(p1))
    }
}

fun logs(tag:String,target: OutputStream,message:Any?){
    target.write("[$tag] $message\n".toByteArray())
}

fun logsCurried(tag:String) = fun (target: OutputStream) = fun (message:Any?) = target.write("[$tag] $message\n".toByteArray())

fun<P1,P2,P3,R> Function3<P1,P2,P3,R> .curriends()=
    fun (p1:P1) = fun (p2:P2) = fun (p3:P3) = this(p1,p2,p3)

