package com.study.algorithm.linkedlist;

/*对此链表进行深拷贝，并返回拷贝后的头结点。*/
public class CloneList {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)return null;
        RandomListNode h = new RandomListNode(pHead.label);
        RandomListNode head = h;
        if(pHead.random != null)h.random = new RandomListNode(pHead.random.label);
        while(pHead.next!=null){
            pHead = pHead.next;
            h.next = new RandomListNode(pHead.label);
            if(pHead.random != null)h.next.random = new RandomListNode(pHead.random.label);
            h = h.next;
        }
        return head;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}