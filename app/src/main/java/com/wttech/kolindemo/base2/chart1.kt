package com.wttech.kolindemo.base2

/**
 * @author LZY
 * @time 2021/6/23.
 */
fun main(){
    //函数引用 使用::
    showOnBoard("张三", ::getDiscount)
    //一个函数lambda参数排在最后，或者是唯一参数
    showOnBoard("李四"){
        name:String,hour:Int->
        val current = 2017
         "${current}年，姓名${name}，时间${hour}"
    }
    //函数类型作为返回类型
    val discount2 = getDiscount2()
    println(discount2("jack"))


}

//具名函数
fun showOnBoard(name:String,showDisCounts:(String,Int)->String){
    val hour = (1..24).shuffled().last()
    println(showDisCounts(name,hour))
}


fun getDiscount(name: String,hour:Int):String{
    val current = 2017
    return "${current}年，姓名${name}，时间${hour}"
}

fun getDiscount2():(String)->String{
    val current = 2027
    val hour = (1..24).shuffled().last()
    return {
         "${current}年，姓名${it}，时间${hour}"
    }
}