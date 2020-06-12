package com.study.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToServiceDialog implements Runnable {

    private Socket dialogSocket = null;

    public ToServiceDialog(){
    }

    //初始化
    public ToServiceDialog(Socket socket){
        dialogSocket = socket;
        System.out.println("连接"+socket.getInetAddress().getHostName()+"主机成功");
    }

    public void run() {
        BufferedReader in;
        PrintWriter out;
        BufferedReader line;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (dialogSocket != null) {
            try {
                //接收
                in = new BufferedReader(new InputStreamReader(
                        dialogSocket.getInputStream()));
                //输出
                out = new PrintWriter(dialogSocket.getOutputStream(), true);
                //获取用户输入
                line = new BufferedReader(new InputStreamReader(
                        System.in));
                while(true){
                    //接受控制台输入的数据
                    String sendMsg = line.readLine();
                    //向服务端发送数据
                    out.println(sendMsg);
                    if (sendMsg.equals("end")) {
                        break;
                    }
                    //接收服务端发送来的数据
                    String msg = in.readLine();
                    System.out.println(sdf.format(new Date()) + "  service: " + msg);
                }
                line.close();
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
