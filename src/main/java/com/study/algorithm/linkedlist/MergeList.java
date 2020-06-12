package com.study.algorithm.linkedlist;

/*输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。*/
public class MergeList {
    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode list = null;
        if(list1==null)return list2;
        else if(list2==null)return list1;
        if(list1.val >= list2.val){
            list = list2;
            list2 = list2.next;
        }
        else {
            list=list1;
            list1=list1.next;
        }
        ListNode listAns = list;
        while(list1 !=null || list2 != null){
            if(list1 == null){
                list.next=list2;
                return listAns;
            }else if(list2 == null){
                list.next=list1;
                return listAns;
            }
            else if(list1.val >= list2.val){
                list.next = list2;
                list2 = list2.next;
            }
            else{
                list.next = list1;
                list1 = list1.next;
            }
            list = list.next;
        }
        list.next=null;
        return listAns;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(10);
        ListNode listNode1 = new ListNode(20);
        ListNode listNode2 = new ListNode(35);
        ListNode listNode3 = new ListNode(55);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;

        ListNode l = new ListNode(15);
        ListNode l1 = new ListNode(17);
        ListNode l2 = new ListNode(25);
        ListNode l3 = new ListNode(45);
        l.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        System.out.println(Merge(listNode, null).toString());
    }
}
