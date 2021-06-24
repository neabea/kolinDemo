package com.wttech.kolindemo.base

import kotlin.reflect.KProperty

/**
 * @author LZY
 * @time 2020/10/26.
 */
class Delegates{
    //属性代理
    var hello by Propertys()
}



class Propertys{
    private var value:String?=null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("getValue:$thisRef->${property.name} = $value")
        return value?:""
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value:String) {
        println("setValue:$thisRef->${property.name} = $value")
        this.value = value
    }
}