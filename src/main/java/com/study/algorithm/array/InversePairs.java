package com.study.algorithm.array;

import java.util.Arrays;

public class InversePairs {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,0};
        Arrays.sort(a);
        int res = 0;
        for(int i = 0;i < a.length-1; i++){//0123456789
            for(int j = i+1;j < a.length; j++){
                if(a[i]<a[j])res = (res+1)%1000000007;
            }
        }
        System.out.println(res);
    }
}
