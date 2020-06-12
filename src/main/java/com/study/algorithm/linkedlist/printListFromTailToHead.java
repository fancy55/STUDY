package com.study.algorithm.linkedlist;

import java.util.ArrayList;

/*从尾到头输出链表*/
public class printListFromTailToHead {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(10);
        ListNode listNode1 = new ListNode(20);
        ListNode listNode2 = new ListNode(15);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = null;
        System.out.println(printListFromTailToHead1(listNode));

    }

    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while(listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i = list.size()-1;i >= 0; i--) {
            ans.add(list.get(i));
        }
        System.out.println(list.size());
        System.out.println(ans.size());
        return ans;
    }
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

