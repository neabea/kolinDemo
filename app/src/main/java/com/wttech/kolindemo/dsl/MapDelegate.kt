package com.wttech.kolindemo.dsl

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author LZY
 * @time 2020/12/22.
 */
class MapDelegate(val map:MutableMap<String,String>):ReadWriteProperty<Any,String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
      return map[property.name]?:""
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
       map[property.name] = value
    }
}