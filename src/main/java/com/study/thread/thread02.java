package com.study.thread;

import java.util.concurrent.TimeUnit;

/**
 * 1、自定义类实现Runnable
 * 2、实现run()
 * 3、创建线程对象，调用start()启动线程
 */
//推荐：避免单继承局限性、灵活方便、方便同一个对象被多个线程使用
public class thread02 implements Runnable{
    @Override
    public void run() {
        for(int i = 0;i < 10;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + "====" + Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        thread02 t1 = new thread02();//一份资源
        new Thread(t1,"a").start();//可多个代理
        new Thread(t1,"b").start();
        for(int i = 0;i < 10;i++) {
//            Thread.sleep(1000);
            TimeUnit.MICROSECONDS.sleep(1000);
            Thread.yield();
            System.out.println(i + "====main线程");
        }
    }
}
