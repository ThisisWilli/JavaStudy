package com.coding.leetcode.linkedlist.isPalindrome234;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Stack;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.linkedlist.isPalindrome234
 * \* author: Willi Wei
 * \* date: 2020-06-10 19:14:17
 * \* description:
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * \
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while(slow != null &&  fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 此时fast指向最后一个节点，slow指向第一个第一部分的最后一个几点
        // 现在开始将后半部分链表反转
        ListNode pre = null;
        ListNode cur = slow.next;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        while(pre != null && head != null){
            if(pre.val == head.val){

            }else{
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        // 1. 首先利用快慢指针的方法，找到中点
        // 2. 再通过快指针进行反转
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 节点个数为偶数个
        if(fast != null){
            fast = slow.next;
            slow.next = null;
        }else{
            ListNode newNode = new ListNode(slow.val);
            newNode.next = slow.next;
            slow.next = newNode;
            fast = newNode;
            slow.next = null;
        }

        ListNode pre = null, dummy2 = fast;
        // 原地反转列表
        while (fast != null){
            ListNode temp = fast.next;
            fast.next = pre;
            pre = fast;
            fast = temp;
        }
        // 比较两个值是否相等
        slow = dummy.next;
        while(slow != null && pre != null){
            if(slow.val != pre.val){
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        System.out.println(new Solution().isPalindrome2(n1));
    }
}