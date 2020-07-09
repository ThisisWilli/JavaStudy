package com.coding.sword2nd.heap.medianfinder41;

import java.util.PriorityQueue;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.heap.medianfinder41
 * \* author: Willi Wei
 * \* date: 2020-07-09 14:15:06
 * \* description:
 * \如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 *
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[1.5],[null],[3]]
 */
public class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    /**
     * 1. 最大堆在最左边，最小堆在最右边
     * 2. 最大堆堆顶存放左边元素的最大值，最小堆堆顶存放右边元素的最小值
     * 3. 当最小堆的堆顶元素小于最大堆的堆顶元素，那么将交换两个堆顶元素
     * 4. 当最小堆的大小与最大堆的大小差值大于1的时候，见队列多的元素的队列的堆顶元素移入元素较少的堆
     */
    public MedianFinder() {
        min = new PriorityQueue<>();
        max  = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        max.add(num);
        while (Math.abs(max.size() - min.size()) > 1){
            min.add(max.poll());
        }

        if (max.size() > 0 && min.size() > 0){
            while (max.peek() > min.peek()){
                int temp = max.poll();
                max.add(min.poll());
                min.add(temp);
            }
        }
    }

    public double findMedian() {
        return (double)((max.size() + min.size()) % 2 == 0 ? (min.peek() + max.peek()) / 2.0 : max.peek());
    }
}