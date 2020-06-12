package com.study.algorithm.array;

import java.util.Scanner;

public class NumberOf1Between1AndN {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int res = 0;
        for(int i = m;i <= n; i++){
            String s = String.valueOf(i);
            for(int j = 0;j < s.length(); j++){
                if(s.charAt(j)-'0' == 1)res++;
            }
        }
        System.out.println(res);
    }
}
