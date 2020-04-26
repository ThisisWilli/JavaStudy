package com.coding.leetcode.linkedlist.mergeKLists;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-26 09:14
 **/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        return mergeSort(lists, 0, lists.length - 1);
    }

    public ListNode mergeSort(ListNode[] lists, int low, int high){
        if (low < high){
            int mid = (low + high) / 2;
            ListNode left = mergeSort(lists, low, mid);
            ListNode right = mergeSort(lists, mid + 1, high);
            return merge(left, right);
        }else {
            return lists[low];
        }
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next;

            }else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        while (l1 != null){
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }
        while (l2 != null){
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l4;
        l4.next = l5;

        ListNode l21 = new ListNode(1);
        ListNode l23 = new ListNode(3);
        ListNode l24 = new ListNode(4);
        l21.next = l23;
        l23.next = l24;

        ListNode l32 = new ListNode(2);
        ListNode l36 = new ListNode(6);
        l32.next = l36;

        ListNode[] lists = new ListNode[]{l1, l21, l32};
        ListNode node = new Solution().mergeKLists(lists);
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
