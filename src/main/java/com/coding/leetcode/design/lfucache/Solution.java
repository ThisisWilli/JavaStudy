package com.coding.leetcode.design.lfucache;

import java.util.*;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-05 08:45
 * 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。
 *
 * 在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 *

 **/

public class Solution {
    public static void main(String[] args) {
//        LFUCache cache = new LFUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        int a = cache.get(1);// 返回 1
//        cache.put(3, 3);    // 去除 key 2
//        int b = cache.get(2);// 返回 -1 (未找到key 2)
//        int c = cache.get(3);// 返回 3
//        cache.put(4, 4);    // 去除 key 1
//        int d = cache.get(1);// 返回 -1 (未找到 key 1)
//        int e = cache.get(3);// 返回 3
//        int f = cache.get(4);// 返回 4
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//        System.out.println(e);
//        System.out.println(f);
    }

}

//class LFUCache {
//
//    private int capacity;
//
//    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
//    private LinkedHashMap<Integer, Integer> countMap = new LinkedHashMap<>();
//
//
//    public LFUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if (this.capacity == 0){
//            return -1;
//        }
//        if (map.containsKey(key)){
//            int oldCount = countMap.get(key);
//            int newCount = countMap.get(key) + 1;
//            countMap.replace(key, oldCount, newCount);
//            return map.get(key);
//        }else {
//            return -1;
//        }
//    }
//
//    public void put(int key, int value) {
//        if (map.size() == this.capacity){
//            Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
//            int minKey = Integer.MAX_VALUE;
//            int minValue = Integer.MAX_VALUE;
//            for (Map.Entry<Integer, Integer> entry : entrySet) {
//                if (entry.getValue() < minValue){
//                    minKey = entry.getKey();
//                    minValue = entry.getValue();
//                }
//            }
//            map.remove(minKey);
//            countMap.remove(minKey);
//            map.put(key, value);
//            countMap.put(key, 1);
//        } else {
//            map.put(key, value);
//            countMap.put(key, 1);
//        }
//    }
//}
class LFUCache {
    Map<Integer, Node> cache;  // 存储缓存的内容
    Map<Integer, LinkedHashSet<Node>> freqMap; // 存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public LFUCache(int capacity) {
        cache = new HashMap<> (capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}

class Node {
    int key;
    int value;
    int freq = 1;

    public Node() {}

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
