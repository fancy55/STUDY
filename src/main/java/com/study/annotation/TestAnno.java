package com.study.annotation;


import com.study.enumeration.Weeks;

import java.lang.annotation.*;

//注解，特殊注释
/*定义Annotation能够被应用于源码的哪些位置：
  类或接口：ElementType.TYPE；
  字段：ElementType.FIELD；
  方法：ElementType.METHOD；
  构造方法：ElementType.CONSTRUCTOR；
  方法参数：ElementType.PARAMETER
* */
/*
仅编译期：RetentionPolicy.SOURCE；
仅class文件：RetentionPolicy.CLASS； //默认，不会被加载进JVM
运行期：RetentionPolicy.RUNTIME
* */
/*
使用@Inherited定义子类是否可继承父类定义的Annotation。
@Inherited仅针对@Target(ElementType.TYPE)类型的annotation有效，并且仅针对class的继承，对interface的继承无效：
* */
@Target(value= {ElementType.METHOD,ElementType.TYPE})  //元注解：可以修饰其他注解
@Retention(RetentionPolicy.RUNTIME)//定义了Annotation的生命周期
@Documented
public @interface TestAnno {  //自定义注解
    Weeks[] weeks() default Weeks.MONDAY;   //配置参数，一般名字定为value
    String[] school() default {"清华","北大"};
}
