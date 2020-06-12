package com.study.thread;

//模拟龟兔赛跑
public class thread02_2 implements Runnable{

    String winner;

    @Override
    public void run() {
        for(int i = 1;i <= 100;i++) {
            //模拟兔子休息
            if(Thread.currentThread().getName().equals("兔子") && i%10==0) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(gameOver(i))break;
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    public static void main(String[] args) {
        thread02_2 t = new thread02_2();

        new Thread(t,"乌龟").start();
        new Thread(t,"兔子").start();
    }

    boolean gameOver(int step) {
        if (winner != null) {
            return true;
        }
        if (step == 100){
            winner = Thread.currentThread().getName();
            System.out.println("winner是" + winner);
            return true;
        }
        return false;
    }
}
