package com.coding.sword.linkedlist.printListFromTailToHead;

import java.util.ArrayList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.linkedlist.printListFromTailToHead
 * \* author: Willi Wei
 * \* date: 2020-01-02 14:58:52
 * \* description:输入一个链表，按照链表从头到尾返回一个ArrayList
 * \
 */

class ListNode{
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode head = new ListNode(0);
        head.next = listNode;
        ListNode p = head.next;
        ListNode result = new ListNode(0);
        while(p != null){
            ListNode temp = result.next;
            result.next = p;
            head.next = p.next;
            p.next = temp;
            p = head.next;
        }
        ListNode num = result.next;
        ArrayList<Integer> results = new ArrayList<>();
        while (num != null){
            results.add(num.val);
            num = num.next;
        }
        return results;
    }
}