package com.study.lambda;

//可读性差

/**
 * 总结：
 * 1、仅有一行代码时才可使用3
 * 2、前提是函数式接口（接口仅能有一个方法）
 * 3、多个参数也可去掉参数类型，要去掉都去掉，必须加括号
 */
public class Test02_param {
    public static void main(String[] args) {
        C c = (s,t) -> {  //可去掉参数类型String
            System.out.println(s+" ending happy "+t);
        };
        c.CC("qly",555);

        //2、简化括号
        B b = s->{
            System.out.println(s+" gogogo!!");
        };
        b.BB("what");

        //3、去掉花括号,代码仅一行
        b = t-> System.out.println(t+" 啊啊啊啊啊！！");
        b.BB("呀呀");
    }
}

interface B{
    void BB(String str);
}

interface C{
    void CC(String str, int i);
}