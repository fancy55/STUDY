package com.study.proxy;

/**静态代理模式总结：
 *  1、真实对象和代理对象实现同一个接口
 *  2、代理对象去代理真实角色
 *
 * 好处：
 *   1、代理对象可以做很多真实对象做不了的事
 *   2、真实对象专注自己的事情
 */
public class StaticProxy {
    public static void main(String[] args) {
        //Thread代理Runnable接口
        new Thread(()-> System.out.println("i love lambda")).start();

        new WeddingCompany(new You()).HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

//真实角色
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("=====结婚啦=====");
    }
}

//代理角色、帮助
class WeddingCompany implements Marry{

    //真实目标角色
    Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    void before(){
        System.out.println("===布置现场===");
    }

    void after(){
        System.out.println("===付尾款===");
    }
}