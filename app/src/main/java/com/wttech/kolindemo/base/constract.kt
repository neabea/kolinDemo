package com.wttech.kolindemo.base

/**
 * @author LZY
 * @time 2020/10/22.
 * 构造函数
 */
fun main(args: Array<String>) {
    childs(222, "c")
    Parents(22)
    val writer = Writer();
    Manger(writer).write()//接口代理用的Writer 的write方法
    var ov = Overloads()
    var ov1 = Overloads(2)
}

class childs constructor(age: Int) : Parents(age) {
    override var age: Int = 0


    override var name: String
        get() = super.name
        set(value) {}

    constructor(a: Int, b: String) : this(a) {
        this.age = a
        println("childs age:" + this.age)
        println(b)
    }

    override fun work() {
        super.work()
    }

}

open class Parents(open var age: Int) {
    init {
        println("Parents age:" + age)
    }

    open lateinit var name: String

    open fun work() {

    }
}

class Manger(writer: Writer) : Write by writer {//by 接口代理

}

class Writer : Write {
    override fun write() {
        println("Writer is write")
    }

}

interface Write {
    fun write()
}

@JvmOverloads  //提供给java类 实现默认参数
fun Overloads(a:Int = 0):Int{//默认参数
    return a
}