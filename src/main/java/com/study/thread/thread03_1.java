package com.study.thread;

//import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**实现Callable,需要返回值类型
 * 重写call()，抛出异常
 * 创建目标对象
     * 创建执行服务：ExecutorService ser = Executors.newFixedThreadPool(1);
     * 提交执行：Future<Boolean> res = ser.submit(t1);
     * 获取结果：boolean b1 = res.get();
     * 关闭服务：ser.shutdownNow();
 */
//改写图片
public class thread03_1 implements Callable<Boolean> {
    String url;
    String name;

    public thread03_1(String url, String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownLoader1.upload(url,name);
        System.out.println("下载完的文件名:"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        thread03_1 t1 = new thread03_1("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1312059974,1893880587&os=1089612698,2972884392&simid=0,0&pn=6&rn=1&di=149850&ln=1710&fr=&fmq=1585542567039_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=11&spn=0&pi=0&gsm=0&hs=2&objurl=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201607%2F31%2F20160731101714_NsALZ.thumb.700_0.jpeg&rpstart=0&rpnum=0&adpicid=0&force=undefined","看我的");
        thread03_1 t2 = new thread03_1("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=2850686694,651598194&os=1069111202,395598996&simid=3417044035,351609609&pn=46&rn=1&di=9130&ln=1710&fr=&fmq=1585542567039_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&hs=2&objurl=http%3A%2F%2Fa3.att.hudong.com%2F85%2F48%2F01300001141980131252486572258.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined","宪法");
        thread03_1 t3 = new thread03_1("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=616391314,1357096614&os=1478400022,3202094358&simid=0,0&pn=52&rn=1&di=185600&ln=1710&fr=&fmq=1585542567039_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=11&spn=0&pi=0&gsm=0&hs=2&objurl=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201811%2F17%2F20181117112448_tGQSf.thumb.700_0.jpeg&rpstart=0&rpnum=0&adpicid=0&force=undefined","man");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果
        System.out.println("r1:"+r1.get());
        System.out.println("r2:"+r2.get());
        System.out.println("r3:"+r3.get());

        //关闭服务
        ser.shutdownNow();
    }
}

//文件下载工具FileUtils
class WebDownLoader1{
    //远程路径、存储名字
    public static void upload(String url, String name){
//        try {
//            FileUtils.copyURLToFile(new URL(url), new File(name));//url变成文件
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

