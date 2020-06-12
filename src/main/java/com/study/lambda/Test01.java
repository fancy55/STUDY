package com.study.lambda;

/**为什么要使用lambda表达式？
 * 1、避免匿名内部类定义过多
 * 2、让代码看上去很简洁
 * 3、去掉一堆没有意义的代码，只剩下核心的逻辑
 */

/**函数式接口：
 *      任何接口，如果只包含了一个方法，它就是一个函数式接口
 * 对于函数式接口，我们可以通过lambda表达式来创建该接口的对象。
 */
public class Test01 {
    public static void main(String[] args) {
        //1、
        A a = new IA();
        a.AA();
        //2、静态内部类
        A a1 = new IB();
        a1.AA();
        //3、局部内部类
        class IC implements A{
            @Override
            public void AA() {
                System.out.println("局部内部类");
            }
        }
        A a2 = new IC();
        a2.AA();
        //4、匿名内部类,没有名字，必须借助接口或者父类
        A a3 = new A(){
            @Override
            public void AA() {
                System.out.println("匿名内部类");
            }
        };
        a3.AA();
        //5、lambda简化，jdk8之后才出现
        //实质是函数式编程
        A a4 = ()->{
            System.out.println("lambda");
        };
        a4.AA();
    }


    static class IB implements A{

        @Override
        public void AA() {
            System.out.println("静态内部类");
        }
    }
}



//11、定义一个函数式接口
interface A{
    void AA();
}

//22、实现类
class IA implements  A{

    @Override
    public void AA() {
        System.out.println("it's lambda");
    }
}