package com.study.algorithm.string;


import org.omg.CORBA.INTERNAL;

import java.util.*;

//第一次只出现一次的字符
//A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122
public class FirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str) {
        if(str == null)return -1;
        char[] ch = str.toCharArray();
        int[] tmp = new int[123];
        for(int i = 0;i < ch.length; i++){
            tmp[ch[i]-'0']++;
        }
        for(int i = 0;i < ch.length; i++){
            if(tmp[ch[i]-'0'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "sajuehduqaswai";
        System.out.println(firstNotRepeatingChar(str));
    }
}
