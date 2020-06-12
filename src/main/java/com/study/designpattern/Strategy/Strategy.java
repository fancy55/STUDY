package com.study.designpattern.Strategy;
/*策略模式*/
/*出行旅游可以乘坐飞机、乘坐火车、骑自行车或自己开私家车等，超市促销可以釆用打折、送商品、送积分等方法*/
/*该模式定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，且算法的变化不会影响使用算法的客户。策略模式属于对象行为模式，它通过对算法进行封装，把使用算法的责任和算法的实现分割开来，并委派给不同的对象对这些算法进行管理。*/
/*优点：
* 1、多重条件语句不易维护，而使用策略模式可以避免使用多重条件语句。
* 2、策略模式提供了一系列的可供重用的算法族，恰当使用继承可以把算法族的公共代码转移到父类里面，从而避免重复的代码。
* 3、策略模式可以提供相同行为的不同实现，客户可以根据不同时间或空间要求选择不同的。
* 4、策略模式提供了对开闭原则的完美支持，可以在不修改原代码的情况下，灵活增加新算法。
* 5、策略模式把算法的使用放到环境类中，而算法的实现移到具体策略类中，实现了二者的分离
* */
/*缺点：
* 1、客户端必须理解所有策略算法的区别，以便适时选择恰当的算法类。
* 2、策略模式造成很多的策略类。
 */

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

/*compareTo*/
public class Strategy {
    public static void main(String[] args) {
//        User[] users={new User("lily",18), new User("lucy",10),new User("fancy",22)};
//        Sorter.sortUser(users);
//        System.out.println(Arrays.toString(users));
        String[] s = new String[10];
        System.out.println(s.length);
        List list=new ArrayList();
        System.out.println(list.size());
        list.add(1);
        list.add("111");
        System.out.println(list.size());
        List list1 = list;
        System.out.println(list == list1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        System.out.println(list.size());
        System.out.println(list == list);
    }
}

class Sorter{
    public static void sortUser(User[] users){
        for(int i = 0;i < users.length-1; i++){
            int tmp = i;
            for(int j = i+1;j < users.length; j++){
                tmp = users[j].compareTo(users[tmp]) == -1?j:tmp;
            }
            swap(users, i, tmp);
        }
    }
    public static void swap(User[] t, int i, int j){
        User tmp = t[i];
        t[i] = t[j];
        t[j] = tmp;
    }
}


class User{
    private String name;
    private Integer no;
    public User(String name, Integer no){this.name=name;this.no=no;}
    public int compareTo(User user){
        if(this.no < user.no)return -1;
        else if(this.no > user.no)return 1;
        return 0;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}

class Manager{
    private String name;
    private Integer flag;//权限
    public Manager(String name, Integer flag){this.name=name;this.flag=flag;}
    public int compareTo(Manager manager){
        if(this.flag < manager.flag)return -1;
        else if(this.flag > manager.flag)return 1;
        return 0;
    }
    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", flag=" + flag +
                '}';
    }
}