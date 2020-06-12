package com.study.designpattern.Singleton;

/*懒汉式：按需初始化，但会带来线程安全性问题--》加锁*/
/*同一个类的不同对象，它的哈希码是不同的*/
public class Singleton1 {
    private static volatile Singleton1 INSTANCE;  //JIT时,禁止指令重排
    private Singleton1(){}
    public static Singleton1 getInstance(){//外提供一个访问该单例的全局访问点
        if(INSTANCE == null){
            synchronized (Singleton1.class){
                if(INSTANCE == null){
                    try{
                        Thread.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton1();
                }
            }
            return INSTANCE;
        }
        return INSTANCE;
    }
    public void test(){
        System.out.println("test-单例-按需实例化");
    }

    public static void main(String[] args) {
        Singleton1 singleton = Singleton1.getInstance();
        Singleton1 singleton1 = Singleton1.getInstance();
        System.out.println(singleton==singleton1);
    }
}
