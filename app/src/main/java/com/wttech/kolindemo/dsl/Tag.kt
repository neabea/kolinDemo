package com.wttech.kolindemo.dsl

import java.lang.StringBuilder

/**
 * @author LZY
 * @time 2020/12/22.
 */
open class Tag(val name: String) : Node {

    val children = ArrayList<Node>()
    val properties = HashMap<String, String>()

    operator fun String.invoke(value: String){
        properties[this]=value
    }

    operator fun String.invoke(block:Tag.()->Unit){
        children.add(Tag(this).apply(block))
    }

    operator fun String.unaryPlus(){// 重写String加号
        this@Tag.children.add(StringNodeTest(this))
    }

    operator fun plus(node:Node){// 重写加号
      children.add(node)
    }

    //<html id = "htmlid" > <head></head> <head></head> </html>
    override fun render(): String {
        return StringBuilder()
            .append("<")
            .append(name)
            .let { stringBuilder ->
                if (!properties.isEmpty()) {
                    stringBuilder.append(" ")
                    properties.forEach {
                        stringBuilder.append(it.key)
                            .append("=\"")
                            .append(it.value)
                            .append("\"")
                    }
                }
                stringBuilder
            }
            .append(">")
            .let { stringBuilder ->
                children.map(Node::render).map(stringBuilder::append)
                stringBuilder
            }
            .append("</$name>")
            .toString()
    }
}