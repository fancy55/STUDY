package com.study.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToClientDialog implements Runnable{

    private Socket dialogSocket = null;

    public ToClientDialog() {
        super();
    }

    //初始化
    public ToClientDialog(Socket socket){
        dialogSocket = socket;
    }

    public void run() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (dialogSocket != null) {
            BufferedReader in;
            PrintWriter out;
            try {
                //接收
                in = new BufferedReader(new InputStreamReader(dialogSocket.getInputStream()));
                //输出
                out = new PrintWriter(dialogSocket.getOutputStream(), true);
                //获取用户输入
                BufferedReader line = new BufferedReader(new InputStreamReader(
                        System.in));
                while(true){
                    //接收客户端发送来的数据
                    String msg = in.readLine();
                    if (msg.equals("end")) {
                        break;
                    }
                    System.out.println(sdf.format(new Date()) + "  client：" + msg);
                    //向客户端发送用户输入的数据
                    out.println(line.readLine());
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

