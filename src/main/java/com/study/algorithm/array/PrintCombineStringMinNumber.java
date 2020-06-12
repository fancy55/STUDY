package com.study.algorithm.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
public class PrintCombineStringMinNumber {
    public static String PrintMinNumber(int [] numbers) {
        List<String> list = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(int i = 0;i < numbers.length; i++)
            list.add(String.valueOf(numbers[i]));
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.concat(o2).compareTo(o2.concat(o1));
            }
        });
        for(String str: list)
            s.append(str);
        return s.toString();
    }

    public static void main(String[] args) {
        int[] q = {1,3,32,321};
        System.out.println(PrintMinNumber(q));
    }
}
