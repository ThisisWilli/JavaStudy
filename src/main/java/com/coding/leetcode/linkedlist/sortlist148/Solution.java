package com.coding.leetcode.linkedlist.sortlist148;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import java.util.LinkedList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.linkedlist.sortlist148
 * \* author: Willi Wei
 * \* date: 2020-06-13 09:37:04
 * \* description:
 * \在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if (head.next == null){
            return head;
        }

        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null){
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(p);
        return merge(l, r);
    }

    /**
     * 合并两个链表
     * @param h1
     * @param h2
     * @return
     */
    private ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (h1 != null && h2 != null){
            if (h1.val <= h2.val){
                head.next = h1;
                h1 = h1.next;
                head = head.next;
            }else {
                head.next = h2;
                h2 = h2.next;
                head = head.next;
            }
        }

        head.next = (h1 != null) ? h1 : h2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node_4 = new ListNode(4);
        ListNode node_2 = new ListNode(2);
        ListNode node_1 = new ListNode(1);
        ListNode node_3 = new ListNode(3);

        node_4.next = node_2;
        node_2.next = node_1;
        node_1.next = node_3;

        ListNode node = new Solution().sortList(node_4);
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}