package com.study.thread;

//设置标志位停止
//正常停止->利用次数，不建议死循环
public class thread_stop implements Runnable{
    static boolean flag = true;
    @Override
    public void run() {
        int i=0;
        while(flag){
            System.out.println("flag "+i++);
        }
    }

    public static void stop(){
        flag = false;
    }

    public static void main(String[] args) {
        new Thread(new thread_stop(),"stop").start();

        for(int i = 0;i <= 1000; i++){
            System.out.println("main");
            if(i==1000){
                thread_stop.stop();
                System.out.println("停止了！！！");
            }

        }
    }
}
