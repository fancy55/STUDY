package com.study.designpattern.Singleton;
/*单例模式：保证在内存中只有一个实例*/

/**
 * 饥汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 */
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();//1、
//    private static Singleton INSTANCE;//2、
//    static{
//        INSTANCE = new Singleton();
//    }
    private Singleton(){}//private 避免类在外部被实例化
    public static Singleton getInstance(){//外提供一个访问该单例的全局访问点
        return INSTANCE;
    }
    public void test(){
        System.out.println("test-单例-类加载时初始化");
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton==singleton1);
    }
}
