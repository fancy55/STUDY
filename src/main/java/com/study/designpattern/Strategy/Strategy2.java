package com.study.designpattern.Strategy;

import java.util.Arrays;

/*利用比较器Comparator*/
/*这里才是真正进入策略模式：可扩展性更棒
* 加，乘。。。。*/
public class Strategy2 {
    public static void main(String[] args) {
        UserEF[] users={new UserEF("lily2",18), new UserEF("lucy3",10),new UserEF("fancy3",22)};
        ManagerEF[] managerES={new ManagerEF("mma1",55.5f), new ManagerEF("mma2",60.11f),new ManagerEF("mma3",35f)};
        SorterEF<UserEF> s1 = new SorterEF<>();
        s1.sortF(users, new UserCmp());
        System.out.println(Arrays.toString(users));

        SorterEF<ManagerEF> s2 = new SorterEF<>();
        s2.sortF(managerES, new ManagerCmp());
        System.out.println(Arrays.toString(managerES));

        s2.sortF(managerES, (o1, o2)->{
            if(o1.flag > o2.flag)return 1;
            else if(o1.flag < o2.flag)return -1;
            return 0;
        });
        System.out.println(Arrays.toString(managerES));
    }
}

class SorterEF<T>{
    public void sortF(T[] arr,Comparator<T> comparator){
        for(int i = 0;i < arr.length-1; i++){
            int tmp = i;
            for(int j = i+1;j < arr.length; j++){
                tmp = comparator.compare(arr[j], arr[tmp]) == -1 ? i:j;//
            }
            swap(arr, i, tmp);
        }
    }
    public void swap(T[] t, int i, int j){
        T tmp = t[i];
        t[i] = t[j];
        t[j] = tmp;
    }
}


class UserEF{
    String name;
    Integer no;
    public UserEF(String name, Integer no){this.name=name;this.no=no;}
    @Override
    public String toString() {
        return "UserEF{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}

class ManagerEF{
    String name;
    Float flag;//权限
    public ManagerEF(String name, Float flag){this.name=name;this.flag=flag;}
    @Override
    public String toString() {
        return "ManagerEF{" +
                "name='" + name + '\'' +
                ", flag=" + flag +
                '}';
    }
}

@FunctionalInterface//函数式接口
interface Comparator<T>{
    int compare(T t1, T t2);
    default void test(){  //1.8以后jdk可以写方法了，加default可以不实现此方法
        System.out.println("test-策略模式-比较器-1.8以后可以在接口中用方法");
    }
}

class UserCmp implements Comparator<UserEF>{
    @Override
    public int compare(UserEF o1, UserEF o2) {
        if(o1.no < o2.no)return -1;
        else if(o1.no > o2.no)return 1;
        return 0;
    }
}

class ManagerCmp implements Comparator<ManagerEF>{
    @Override
    public int compare(ManagerEF o1,ManagerEF o2) {
        if(o1.flag > o2.flag)return -1;
        else if(o1.flag < o2.flag)return 1;
        return 0;
    }
}