package com.study.designpattern.Strategy;

import java.util.Arrays;

/*comparable*/
public class Strategy1 {
    public static void main(String[] args) {
        UserE[] users={new UserE("lily2",18), new UserE("lucy3",10),new UserE("fancy3",22)};
        ManagerE[] managerES={new ManagerE("mma1",55.5f), new ManagerE("mma2",60.11f),new ManagerE("mma3",35f)};
        SorterE.sortUser(users);
        System.out.println(Arrays.toString(users));
        SorterE.sortUser(managerES);
        System.out.println(Arrays.toString(managerES));
    }
}

class SorterE{
    public static void sortUser(Comparable[] users){
        for(int i = 0;i < users.length-1; i++){
            int tmp = i;
            for(int j = i+1;j < users.length; j++){
                tmp = users[j].compareTo(users[tmp]) == -1?j:tmp;
            }
            swap(users, i, tmp);
        }
    }
    public static void swap(Object[] t, int i, int j){
        Object tmp = t[i];
        t[i] = t[j];
        t[j] = tmp;
    }
}


class UserE implements Comparable<UserE>{
    private String name;
    private Integer no;
    public UserE(String name, Integer no){this.name=name;this.no=no;}
    public int compareTo(UserE user){
        if(this.no < user.no)return -1;
        else if(this.no > user.no)return 1;
        return 0;
    }
    @Override
    public String toString() {
        return "UserE{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}

class ManagerE implements Comparable<ManagerE>{
    private String name;
    private Float flag;//权限
    public ManagerE(String name, Float flag){this.name=name;this.flag=flag;}
    public int compareTo(ManagerE manager){
        if(this.flag < manager.flag)return -1;
        else if(this.flag > manager.flag)return 1;
        return 0;
    }
    @Override
    public String toString() {
        return "ManagerE{" +
                "name='" + name + '\'' +
                ", flag=" + flag +
                '}';
    }
}


interface Comparable<T>{
    int compareTo(T o);  //如果是Object则强制转换
}