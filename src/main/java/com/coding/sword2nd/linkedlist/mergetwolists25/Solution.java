package com.coding.sword2nd.linkedlist.mergetwolists25;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.linkedlist.mergetwolists25
 * \* author: Willi Wei
 * \* date: 2020-07-08 15:00:21
 * \* description:
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * \
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                p.next = l1;
                l1 = l1.next;

            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
            p.next = null;
        }

        if (l1 != null){
            p.next = l1;
        }

        if (l2 != null){
            p.next = l2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);

        l11.next = l12;
        l12.next = l13;

        l21.next = l22;
        l22.next = l23;

        ListNode listNode = new Solution().mergeTwoLists(l11, l21);
        System.out.println(listNode);
    }
}