package com.study.thread;

/** 1、自定义线程类继承Thread
 *  2、重写run方法、编写线程执行体
 *  3、创建线程对象，调用start()启动线程
 */
//交替执行，若速度太快则看不出，i设更大、1CPU单核的,一时间只能做一件事
//CPU安排调度
//Thread实现了Runnable接口
//不建议使用：避免OOP单继承局限性
public class thread01 extends Thread{
    @Override
    public void run() {
        for(int i = 0;i < 10;i++) {
            try {
                Thread.sleep(500);
                System.out.println(i + "======="+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        thread01 t1 = new thread01();
        t1.start();
        System.out.println(t1.getState());
        for(int i = 0;i < 10;i++) {
            Thread.sleep(1000);
            t1.join();//等待t1执行完才能继续执行
            System.out.println(i + "====main线程");
        }
        System.out.println(t1.getState());
    }
}
