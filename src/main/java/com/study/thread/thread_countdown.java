package com.study.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

//倒计时
public class thread_countdown implements Runnable{
    Date startTime = new Date(System.currentTimeMillis());
    @Override
    public void run() {
        int cnt = 10;
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(cnt--+","+new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());//更新当前时间
                if(cnt<=0)break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new Thread(new thread_countdown(), "countDown").start();
    }
}
