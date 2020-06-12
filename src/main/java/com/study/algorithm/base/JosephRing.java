package com.study.algorithm.base;

public class JosephRing {
    public static void main(String[] args) {
        int n = 11;
        int s = 0;
        for(int i = 2;i <= n; i++) {
            s = (s + 4) % i;

        }
        System.out.println(s + 1);
    }
}
