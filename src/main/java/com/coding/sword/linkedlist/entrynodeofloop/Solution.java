package com.coding.sword.linkedlist.entrynodeofloop;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-11 13:32
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 **/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * 使用快慢指针的方法解题
 *          1、先确定链表中是否有环，定义两个快慢指针，一个每次走一步，一个每次走两步，若两个指针最终相遇了，那么一定有环存在
 *          2、确定环的起始节点，要先确定环的大小，然后再令两个快慢节点，快的节点先走环的长度大小的步数，然后慢的指针在开始走，直到快的
 *          指针和慢的指针相遇的点就是环的起点
 *          3、环的大小可以在第一次快慢指针走的过程中确定，若两个指针相遇了，那么记住这个点，继续走，开始计数，下次到达这个节点就是环的
 *          长度
 */
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode loopNode = isLoop(pHead);
        if (loopNode == null){
            return null;
        }
        int len = getLength(loopNode);
        ListNode slow = pHead, fast = pHead;
        while (len > 0){
            fast = fast.next;
            len--;
        }
        while (fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 判断链表中是否有环
     * @param pHead
     * @return
     */
    private ListNode isLoop(ListNode pHead){
        if (pHead == null){
            return null;
        }
        ListNode slow = pHead.next;
        if (slow == null) {
            return null;
        }
        ListNode fast = slow.next;
        if (fast == null){
            return null;
        }
        while (slow != null && fast != null){
            // 要进行双重确认
            if (slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null){
                fast = fast.next;
            }
        }
        return null;
    }

    private int getLength(ListNode loopNode){
        int len = 1;
        ListNode p = loopNode.next;
        while (p != loopNode){
            len++;
            p = p.next;
        }
        return len;
    }
}
