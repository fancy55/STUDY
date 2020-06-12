package com.study.designpattern.Singleton;

/*静态内部类
* JVM保证单例
* 加载外部类时不会加载内部类，这样实现了懒加载
* */
public class Singleton2 {
    private Singleton2(){}
    private static class s2{
        private final static Singleton2 INSTANCE = new Singleton2();
    }
    public static Singleton2 getInstance(){
        return s2.INSTANCE;
    }
    public void  test(){
        System.out.println("test-单例-静态内部类");
    }

    public static void main(String[] args) {
        for(int i = 0;i < 10; i++){
            new Thread(()-> {
                System.out.println(Singleton2.getInstance().hashCode());
            }).start();
        }
    }
}
