package com.coding.leetcode.design.lrucache;

import java.util.*;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.design.lruCache
 * \* author: Willi Wei
 * \* date: 2020-07-23 15:36:28
 * \* description:
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到
 * 上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * \
 */
public class LRUCache {

    HashMap<Integer, Node> map;
    int capacity;
    Node dummyHead = new Node();
    Node dummyTail = new Node();

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        dummyHead.pre = null;
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
        dummyTail.next = null;
    }

    /**
     * 如果包含这个key，通过map定位，然后将这个元素插入队头
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;

            // 将元素插入队头
            node.next = dummyHead.next;
            node.pre = dummyHead;
            node.next.pre = node;
            dummyHead.next = node;
            return node.value;
        }else {
            return -1;
        }
    }

    /**
     * 如果容量等于容量上限，那么需要将最少使用的数据作废，并插入最新数据
     * @param key
     * @param value
     */
    public void put(int key, int value) {

        // 如果元素存在，并且容量没有超，则替换原来的元素
        if (map.size() <= capacity && map.containsKey(key)){
            map.get(key).value = value;
            Node moveNode = map.get(key);
            moveNode.pre.next = moveNode.next;
            moveNode.next.pre = moveNode.pre;
            moveNode.next = dummyHead.next;
            moveNode.pre = dummyHead;
            moveNode.next.pre = moveNode;
            dummyHead.next = moveNode;
        }else if (map.size() < capacity){
            // 插入新元素
            Node node = new Node(key, value);
            node.next = dummyHead.next;
            node.next.pre = node;
            node.pre = dummyHead;
            dummyHead.next = node;
            map.put(key, node);
        }else {
            // 删除最小使用的元素，并插入新元素
            // 找出队尾node
            Node deleteNode = dummyTail.pre;
            // 从map中移除队尾node
            map.remove(deleteNode.key);

            // 从链表中删除node
            deleteNode.pre.next = deleteNode.next;
            deleteNode.next.pre = deleteNode.pre;

            // 在map中插入元素
            Node newNode = new Node(key, value);
            map.put(key, newNode);

            // 在链表头部插入新元素
            newNode.next = dummyHead.next;
            newNode.pre = dummyHead;
            newNode.next.pre = newNode;
            dummyHead.next = newNode;
        }
    }

    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }


        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Node o = (Node)obj;
            return o.key == this.key;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));
//        cache.put(3, 3);    // 该操作会使得关键字 2 作废
//        System.out.println(cache.get(2));
//        cache.put(4, 4);    // 该操作会使得关键字 1 作废
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));

        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*
    LRUCache cache = new LRUCache( 2/* 缓存容量 *//*);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // 返回  1
    cache.put(3, 3);    // 该操作会使得关键字 2 作废
    cache.get(2);       // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得关键字 1 作废
    cache.get(1);       // 返回 -1 (未找到)
    cache.get(3);       // 返回  3
    cache.get(4);       // 返回  4
*/
