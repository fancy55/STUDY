package com.study.algorithm.stack;

import java.util.Stack;

/*用两个栈来实现一个队列，完成队列的Push和Pop操作*/
public class TwoStackToQueue {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        push(1);
        push(3);
        push(6);
        System.out.println(pop());
        push(4);
        push(5);
        System.out.println(pop());
    }

    public static void push(int node) {
        if(!stack2.empty()){
            while (!stack2.empty())stack1.push(stack2.pop());
        }
        stack1.push(node);
        if(stack2.empty()){
            while (!stack1.empty())stack2.push(stack1.pop());
        }
    }

    public static int pop() {
        return stack2.pop();
    }
}
