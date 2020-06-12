package com.study.algorithm.array;

import java.util.*;

//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
public class MoreThanHalfArrayLen {

    public static  int MoreThanHalfNum_Solution(int [] array) {
        if(array == null)return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < array.length; i++){
            if(map.containsKey(array[i]))
                map.put(array[i], map.get(array[i])+1);
            else map.put(array[i], 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int res = list.get(0).getValue();
        if(res > array.length/2+1)
            return list.get(0).getKey();
        return 0;
    }

    public static void main(String[] args) {
//        int[] a= {1,2,3,2,2,2,5,4,2};
        int[] a={};
        System.out.println(MoreThanHalfNum_Solution(a));
    }
}
