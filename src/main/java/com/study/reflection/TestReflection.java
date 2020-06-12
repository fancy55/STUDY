package com.study.reflection;

import com.study.model.Student;
import com.study.model.User;

import java.lang.annotation.ElementType;

//反射是解释性操作，对性能有影响，
//class[外部类、成员类、局部内部类、匿名内部类]、interface、数组、enum、annotation、primitive、void
//java内存：堆、栈、方法区
public class TestReflection {
    static {
        System.out.println("主类被加载");
    }

    void Test01() throws ClassNotFoundException {
        Class c1 = Class.forName("com.study.model.User");//1、ofrName
        Class c2 = Student.class;//2、通过类名.class   最安全可靠
        User user = new User();
        Class c3 = user.getClass();//3、通过对象
        Class c4 = c2.getSuperclass();//获取父类对象
        //c1.xxx;
        //判断c1和c2是否相等，比较hashCode
        Class c5 = Integer.TYPE;//4、内置基本数据类型可以直接用类名.Type
        //5、ClassLoader

    }

    void Test02(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = Override.class; //注解
        Class c6 = ElementType.class;//枚举
        Class c7 = Integer.class;  //基本数据类型
        Class c8 = void.class;
        Class c9 = Class.class;

    }

    void Test03(){
        A a = new A();
        System.out.println(a.m);
        /** 使用类还未加载到内存中，系统对类的初始化有三个步骤：
        * 过程：
        * 1、类加载到内存，产生一个类对应的class对象；
        * 2、链接、结束后m=0；//正式为类变量分配内存并设置默认初始值【方法区中】、JVM常量池内的符号引用（常量名）替换为直接引用地址
        * 3、初始化
        *       类构造器：
        *       <clinit>(){
        *           静态代码块；
        *           m=300;
        *           m=1;
        *       }
        *    m=1;
        *
         */
    }

    void Test04(){
        /** 什么时候发生类的初始化？
        * 1、类的主动引用【一定会发生类的初始化】
        *       当JVM启动，先初始化main()所在类；
        *       new一个对象；
        *       调用类的静态成员（除final）和静态方法；
        *       使用java.lang.reflect包的方法对类进行反射和调用；
        *       当初始化一个类时，若父类未初始化，则会先初始化它的父类；
        * 2、被动引用【不会发生类的初始化】
        *       当访问一个静态域时，只有声明这个域的类才会被初始化。【如子类引用父类的静态变量，子类不会初始化
        *       通过数组定义类引用不会触发此类的初始化
        *       引用常量不会触发此类的初始化
        *
         */
    }

    void Test05() throws ClassNotFoundException {
        /**
         * 类加载器：
         * 作用：将class字节码文件加载到内存中，并将这些静态数据转换成方法区的运行时数据结构，
         *      然后在堆中生成一个代表这个类的java.lang.Class对象，作为方法区中数据的访问入口。
         *      【java编译器：将源程序.java-》字节码.class】
         * 类缓存：标准的JavaSE类加载器可以按钮幺七查找类，但一旦某个类被加载到类加载器中，它将持续加载（缓存）一段时间。
         *          不过JVM垃圾回收机制可以祸首这些Class对象
         *  自上而下：
         *  1、引导类加载器Bootstap Classloader：JVM自带；负责java平台核心库，用来装载核心类库；该加载器无法直接获取；
         *  2、扩展类加载器Extension Classloader：负责jre/lib/ext目录下的jar包，或-D java.ext.dirs指定目录下的jar包装入工作库；
         *  3、系统类加载器System Classloader/Application Classloader：负责java -classpath或-D java.class.path所指定目录下的类或jar包装入工作，是最常见的加载器；
         *  4、自定义加载器：
         */
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();//系统类加载器
        systemLoader.getParent();//扩展类加载器
        systemLoader.getParent().getParent();//根加载器，无法直接获取null
        //测试当前类是哪个加载器
        Class.forName("com.study.reflection.TestReflection").getClassLoader();
        //测试JDK内置类是哪个加载器
        Class.forName("java.lang.Object").getClassLoader();//根-》null

        //获取系统类加载器可以加载的路径
        System.getProperty("java.class.path");
        /**双亲委派机制，保证安全性，保证核心类不被破坏
         *   java.lang.String【JDK已有】
         *  自定义String类，跑不起来
         *  会用根加载器或扩展......中已存在的
         */
    }
}

class A{
    static{
        System.out.println("静态代码块初始化");
        m = 100;
    }

    static int m = 1;

    public A(){
        System.out.println("无参初始化");
    }
}

class B extends A{
    static{
        System.out.println("子类被加载");
        m = 200;
    }
    static int m = 2;
    static final int n = 2;
}

