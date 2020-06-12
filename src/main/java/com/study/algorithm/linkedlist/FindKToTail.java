package com.study.algorithm.linkedlist;
/**
 * 两个指针p1,p2，开始都指向头结点
 * 先让p2走k步
 * 然后p1,p2同时向下走
 * 当p2指向null的时候，p1就是倒数第k个节点
 */
public class FindKToTail {
    public static ListNode FindKthToTail(ListNode head,int k) {
        if(k <= 0 || head == null)return null;
        ListNode p1 = head;
        ListNode p2 = head;
        int tmp = 1;
        while(p2.next!=null){
            tmp++;
            if(tmp <= k){
                p2 = p2.next;
            }else{
                p2 = p2.next;
                p1 = p1.next;
            }
        }
        if(k > tmp)return null;
        return p1;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(10);
        ListNode listNode1 = new ListNode(20);
        ListNode listNode2 = new ListNode(15);
        ListNode listNode3 = new ListNode(25);
        ListNode listNode4 = new ListNode(135);
        ListNode listNode5 = new ListNode(35);
        ListNode listNode6 = new ListNode(45);
        ListNode listNode7 = new ListNode(25);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = null;
        System.out.println(FindKthToTail(listNode,1).val);
    }
}