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

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode){
        if (currentNode != null){
            if (!recursivelyCheck(currentNode.next)){
                return false;
            }
            if (currentNode.val != frontPointer.val){
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}