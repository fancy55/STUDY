package com.study.algorithm.base;

import java.util.LinkedList;
import java.util.Queue;

/*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。*/
public class reOrderArray {
    public static void reArray(int[] a){
        Queue<Integer> q2 = new LinkedList<>();
        int tmp = 0;
        for(int i = 0, j = 0;i < a.length; i++){
            if((a[i]&1) == 1){
                a[j++] = a[i];
                tmp = j;
            }
            else if((a[i]&1) == 0){
                q2.add(a[i]);
            }
        }
        while(!q2.isEmpty()){
            a[tmp++] = q2.poll();
        }

    }

    public static void swap(int a[], int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {1,4,2,5,6,2,43,6,2};
        reArray(a);
        for(int i = 0;i < a.length; i++)
        System.out.print(a[i]+" ");
    }
}
