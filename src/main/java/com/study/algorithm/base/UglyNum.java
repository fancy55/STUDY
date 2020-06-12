package com.study.algorithm.base;

import java.util.ArrayList;
import java.util.List;

//丑数 ：只包含质因子2、3、5   （1例外）
public class UglyNum {
    public  static int GetUglyNumber_Solution(int index) {
        if(index < 0)return 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int t2 = 0,t3 = 0,t5 = 0;
        while(list.size() < index){
            int m2 =list.get(t2)*2;
            int m3 =list.get(t3)*3;
            int m5 =list.get(t5)*5;
            int min = Math.min(m2, Math.min(m3,m5));
            if(!list.contains(min))
                list.add(min);
            if(min == m2)t2++;
            else if(min == m3)t3++;
            else if(min == m5)t5++;
        }
        System.out.println(list);
        return list.get(index-1);
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(8));
    }
}
