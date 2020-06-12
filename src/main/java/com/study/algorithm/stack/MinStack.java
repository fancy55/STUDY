package com.study.algorithm.stack;

import java.util.Stack;

public class MinStack {
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    public static void push(int node) {
        if(stack1.empty())stack1.push(node);
        else{
            if(stack1.peek() >= node){
                stack1.push(node);
            }
        }
        stack2.push(node);
    }

    public static void pop() {
        if(stack1.peek() == stack2.peek()){
            stack1.pop();

        }
        stack2.pop();
    }

    public static int top() {
        return stack2.peek();
    }

    public static int min() {
        return stack1.peek();
    }

    public static void main(String[] args) {
        push(4);
        push(24);
        push(41);
        System.out.println(min());

        push(-4);
        push(-4);
        System.out.println(min());

        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
    }
}
