package com.wttech.kolindemo.base;


/**
 * @author LZY
 * @time 2020/10/22.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(StaticClass.TAG);
        StaticClass sc = StaticClass.ofInt(12);
        StaticClass.Companion.ofValues(sc);
        StaticClass.Companion.print("yes");
        //扩展参数
        System.out.println(ExtendsJavaKt.multi("efg",5));
        //属性代理
    }
}
