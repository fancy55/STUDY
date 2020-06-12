package com.study.designpattern.Singleton;

/*不仅可以解决线程同步，还可以防止反序列化*/
//詹姆斯·高斯林  Effective Java
public enum  Singleton3 {
    INSTANCE;
    public void test(){
        System.out.println("test-单例-枚举");
    }
    public static void main(String[] args) {
        for(int i = 0; i < 10 ;i++){
            new Thread(()->{
                System.out.println(Singleton3.INSTANCE.hashCode());
            }).start();
        }
    }
}
/**java的反射：通过class文件然后加载到内存new一个实例
 *
 *枚举不会被反序列化：枚举没有构造方法，反序列只能是INSTANCE这个值 【反编译后，是一个abstract class】
 */