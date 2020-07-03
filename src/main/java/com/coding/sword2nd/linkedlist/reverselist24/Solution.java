package com.coding.sword2nd.linkedlist.reverselist24;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.linkedlist.reverselist24
 * \* author: Willi Wei
 * \* date: 2020-07-03 11:08:05
 * \* description:
 * \定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseList(ListNode head) {

        if (head == null){
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode p = head;
        while (head != null){
            p = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = p;
        }


        return dummy.next;
    }
}