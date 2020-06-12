package com.study.thread;

//多线程操作统一对象
//买火车票
//发现问题：多个线程操作同一个资源，线程不安全、数据紊乱【多个人拿到同一张票，票数为负
public class thread02_1 implements Runnable{
    int ticket = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket <= 0) break;
                try {
                    Thread.sleep(200);//模拟网络延迟、放大问题的发生性
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "拿到了第" + ticket-- + "张票");
            }
        }
    }

    public static void main(String[] args) {
        thread02_1 t = new thread02_1();
        new Thread(t,"别人").start();
        new Thread(t,"我").start();
        new Thread(t,"黄牛党").start();
    }
}
