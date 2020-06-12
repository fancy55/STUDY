package com.study.algorithm.sort;

import java.util.ArrayList;

/*O（nlogn）*/
public class QuickSort {
    public void sort(int[] arr) {
        for(int i = 0;i < arr.length; i++){
            int tmp = i;

        }
    }

    public static int binarySort(int[] a){
        if(a.length == 0)return 0;
        int left = 0, right = a.length-1;
        if(a[left] < a[right])return a[left];
        while(left < right){
            int mid = (left+right)/2;
            if(a[mid] > a[left])left = mid;
            else if(a[mid] < a[left])right = mid;
            else return Math.min(a[mid], a[right]);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {6,7,-2,-1,1,2,3,4,5,6};
        System.out.println(binarySort(a));
    }

}