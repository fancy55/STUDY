package com.study.thread;

/*notify和wait*/
public class thread04{
    public static int cnt = 10;
    public static void main(String[] args) {
        thread04 t = new thread04();
        new Thread(new produce(t)).start();
        new Thread(new consume(t)).start();
    }
}

class produce implements Runnable{
    private thread04 t;
    public produce(thread04 t){this.t = t;}
    @Override
    public void run() {
        while(true) {
            synchronized (t) {
                try {
                    while (thread04.cnt > 5) t.wait();
                    ++thread04.cnt;
                    System.out.println("生产后的库存有：：：" + thread04.cnt);
                    t.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class consume implements Runnable {
    private thread04 t;
    public consume(thread04 t){this.t = t;}
    @Override
    public void run() {
        while(true) {
            synchronized(t) {
                try {
                    while(thread04.cnt <= 0)t.wait();
                    thread04.cnt--;
                    System.out.println("消费后剩余："+thread04.cnt);
                    t.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}