package com.coding.sword.tree.insertandgetmedian;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-20 09:39
 **/

import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取
 * 数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Solution {
    /**
     * 创建两个最大堆和最小堆，若两个堆的总数为奇数，则返回两个堆中的一个元素，若两个堆的元素总和为偶数，则返回两个堆顶
     * 元素的平均值，但是两个堆的元素个数要相等
     * 1、首先要实现最大堆和最小堆，利用优先队列进行实现
     *
     * @param num
     */
    // 最大堆在左边，最小堆在右边
    // 实现大顶堆
    PriorityQueue<Integer> max = new PriorityQueue<>(11, (o1, o2)->{
        return o2 - o1;
    });
    // 实现小顶堆
    PriorityQueue<Integer> min = new PriorityQueue<>();
    private int count = 0;
    public void Insert(Integer num) {
        // 总数为偶数时，则将num要放到最小堆，总数为奇数时，则将num要放到最大堆
        // 个数为偶数，因为0为第一个数，第一个数放在左边也就是最大堆，先将数放到右边最小堆，再将最小堆中的最小数放入最大堆，数最终被放入最大堆
        if (count % 2 == 0){
            min.offer(num);
            int filterNum = min.poll();
            max.offer(filterNum);
        }else {
            // 同理
            max.offer(num);
            int filterNum = max.poll();
            min.offer(filterNum);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0){
            return new Double((min.peek() + max.peek()))/ 2;
        }else {
            // 最大堆中的数要多，从最大堆中取数
            return new Double(max.peek());
        }
    }

}
