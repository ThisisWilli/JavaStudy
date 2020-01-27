package com.coding.sword.linkedlist.deleteduplication;

/**
 * @program: JavaStudy
 * @description:在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author: Hoodie_Willi
 * @create: 2020-01-27 11:26
 **/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    // 边界情况，所有节点都是一样的和只有一个节点
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null){
            return null;
        }
        // 在找到重复节点的时候，找到最后一个重复节点的下一个节点，将这个节点的信息复制到第一个重复的节点上
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode p = pHead;
        while (p != null){
            if (p.next != null && p.val == p.next.val){
                while (p.next != null && p.val == p.next.val){
                    p = p.next;
                }
                pre.next = p.next;
            }else {
                pre = pre.next;
                // 不能把这句放在这里，这样当p.val = p.next.val时p就不会向下走，不能和pre，同步一起向下走
//                p = p.next;
            }
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode deleteDuplication2(ListNode pHead)    {
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode first = head;
        ListNode second = first.next;
        while(second != null){
            if(second.next != null && second.val == second.next.val){
                while(second.next != null && second.val == second.next.val){
                    second = second.next;
                }
                first.next = second.next;
            }else{
                first = first.next;
            }
            second = second.next;
        }
        return head.next;
    }
}
