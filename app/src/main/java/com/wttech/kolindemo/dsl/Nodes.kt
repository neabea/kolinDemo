package com.wttech.kolindemo.dsl

/**
 * @author LZY
 * @time 2020/12/22.
 */
fun htmlTest(block: Tag.() -> Unit): Tag {
    return Tag("html").apply(block)
}

fun Tag.headtes(block: Heads.() -> Unit) {
     this@headtes.children.add(Heads().apply(block))
}

fun Tag.bodytes(block: Bodies.() -> Unit){
    this@bodytes + Bodies().apply(block)
}

class StringNodeTest(val content: String) : Node {
    override fun render(): String {
        return content
    }
}

class Heads : Tag("heads")

class Bodies : Tag("body") {
    var id by MapDelegate(properties)

    var `class` by MapDelegate(properties)
}