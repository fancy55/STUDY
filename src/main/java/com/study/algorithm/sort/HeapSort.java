package com.study.algorithm.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//输入n个整数，找出其中最小的K个数。
public class HeapSort {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || k > input.length || k <= 0)return res;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });//优先队列与最大堆
        for(int i = 0;i < input.length; i++){
            if(maxHeap.size() != k)maxHeap.offer(input[i]);
            else if(maxHeap.peek() > input[i]){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for(Integer cnt:maxHeap)res.add(cnt);
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return res;
    }

    public static void main(String[] args) {
        int a[] = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(a, 4));
    }

}
