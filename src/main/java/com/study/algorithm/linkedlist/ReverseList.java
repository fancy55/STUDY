package com.study.algorithm.linkedlist;

import java.util.Stack;
/*输入一个链表，反转链表后，输出新链表的表头。*/
public class ReverseList {
    public static ListNode ReverseList(ListNode head) {
        if(head == null)return null;
        Stack<ListNode> stack = new Stack<>();
        while(head.next!=null){
            stack.push(head);
            head= head.next;
        }
        ListNode listNode = head;
        ListNode reversetNode = listNode;
        while(!stack.empty()){
            listNode.next = stack.pop();
            listNode = listNode.next;
        }
        listNode.next = null;
        return reversetNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(10);
        ListNode listNode1 = new ListNode(20);
        ListNode listNode2 = new ListNode(15);
        ListNode listNode3 = new ListNode(55);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;
        System.out.println(ReverseList(listNode).toString());
    }
}
