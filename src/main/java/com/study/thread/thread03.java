package com.study.thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class thread03 implements Callable<String> {
    private int tmp = 10;
    private Lock lock = new ReentrantLock();//可重入锁
    @Override
    public String call() throws InterruptedException {
        synchronized (this) {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    tmp++;
                }
            }finally {
                lock.unlock();
                String name = Thread.currentThread().getName();
                System.out.println(name + "===============" + tmp);
                return name + "===============" + tmp;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //创建执行服务
        thread03 t = new thread03();
        ExecutorService ser = Executors.newFixedThreadPool(3);
        Future<String> r1 = ser.submit(t);//提交执行
        Future<String> r2 = ser.submit(t);
        Future<String> r3 = ser.submit(t);
        System.out.println(r1.get()+".......get");
        System.out.println(r2.get()+".......get");
        System.out.println(r3.get()+".......get");
    }
}
//        Callable<String> c1 = new thread03();
//        FutureTask<String> futureTask1 = new FutureTask<>(c1);
//        new Thread(futureTask1).start();
//        System.out.println("ans:"+futureTask1.get());