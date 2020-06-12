package com.study.algorithm.stack;

import java.util.Stack;

/*输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。*/
public class IsPopOrder {

    public static boolean isPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int i = 0;i < pushA.length; i++){
            stack.push(pushA[i]);
            if(pushA[i] == popA[j]){
                j++;
                stack.pop();
            }
        }
        while(!stack.empty()){
            if(stack.peek() == popA[j++]){
                stack.pop();
            }else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] popA = {2,3,4,5,1};
        System.out.println(isPopOrder(push,popA));
    }
}
