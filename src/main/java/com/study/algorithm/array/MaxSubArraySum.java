package com.study.algorithm.array;

//连续子数组的最大和，动态规划

/**动态转移方程
 当以第I-1个数字结尾的子数组中所有数字的和小于0时，如果把这个负数与第i个数累加，则得到的结果比第i个数字本身还要小，所以这种情况下以第I个数字结尾的子数组就是第I个数字本身
 * f(i-1) < 0 || i==0, f(i) = a[i]
 * f(i-1) > 0 || i!=0，f(i) = f(i-1) + a[i]
 */
public class MaxSubArraySum {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null) return 0;
        int[] com = new int[array.length];
        com[0] = array[0];
        int res = com[0];
        for(int i = 1;i < array.length; i++){
            if(com[i-1] < 0)com[i] = array[i];
            else com[i] = com[i-1] + array[i];
            if(com[i] > res) res = com[i];
        }
        return res;
    }
}
