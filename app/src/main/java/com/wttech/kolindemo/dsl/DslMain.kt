package com.wttech.kolindemo.dsl

/**
 * @author LZY
 * @time 2020/12/22.
 */
fun main(){
    Tag("html").apply {
        properties["ids"] = "htmlId"
        children.add(Tag("head"))
        children.add(Tag("end"))
    }.render().let(::println)

    println("------")
    htmlTest {
//        properties["ids"] = "htmlId"
//        children.add(Tag("head"))
//        children.add(Tag("end"))
        "ids"("htmlId")
        "head"{
            "id"("headid")
        }
        bodytes{
            id = "bodyId"
            `class` = "bodyclass"
            "a"{
                "href"("http://www.baidu.com")
                + "Kotlin 中文"
            }
        }
    }.render().let(::println)
}