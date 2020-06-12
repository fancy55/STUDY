package com.study.greed;

import java.util.Scanner;

public class CutRope {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] f = new int[n+1];
        f[1] = 1;f[2] = 2;f[3] = 3;
        for(int i = 4;i <= n; i++){
            for(int j = 1;j <= i/2; j++){
                f[i] = Math.max(f[i], f[j]*f[i-j]);
            }
        }
        if(n<4) System.out.println(f[n-1]);
        else System.out.println(f[n]);
    }
}
