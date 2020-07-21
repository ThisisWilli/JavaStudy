package com.study.sort.heapsort;

/**
 * \* project: JavaStudy
 * \* package: com.study.sort.heapsort
 * \* author: Willi Wei
 * \* date: 2020-07-21 20:27:52
 * \* description:
 * \
 * 堆排序的步骤：
 * 1. 创建堆，将原数组堆化
 * 2. 调整堆，将最大堆的元素放到数组的最末端，调整过程需要保证堆序性质，在一个二叉堆中任意父结点大于其子节点
 * 3. 堆排序，取出位于堆顶的第一个元素，放入数组b中，再将剩下的堆进行迭代
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        // 新建一个最大堆
        heapify(nums);
        for (int i = nums.length - 1; i >= 1; i--){
            // 弹出最大堆的堆顶放在最后
            swap(nums, 0, i);
            // 重建最大堆
            rebuidHeap(nums, 0, i - 1);
        }
        return nums;
    }

    public void heapify(int[] nums){
        for (int i = 1; i < nums.length; i++){
            int parent = (i - 1) >> 1;
            int child = i;
            while (i > 0 && nums[parent] < nums[child]){
                swap(nums, parent, child);
                child = parent;
                // 还要判断换上来的元素是否大于parent，如果大于，继续向上换
                parent = (parent - 1) >> 1;
            }
        }
    }

    public void rebuidHeap(int[] nums, int par, int last){
        int left = par * 2 + 1;
        int right = par * 2 + 2;
        int maxIndex = left;
        // 找到最大子节点
        if (right <= last && nums[right] > nums[left]){
            maxIndex = right;
        }
        // 和最大子节点比较
        if (left <= last && nums[par] < nums[maxIndex]){
            // 互换最大子节点
            swap(nums, par, maxIndex);
            // 重建最大子节点代表的子树
            rebuidHeap(nums, maxIndex, last);
        }
    }

    public void swap(int[] nums, int l1, int l2){
        int temp = nums[l1];
        nums[l1] = nums[l2];
        nums[l2] = temp;
    }

    public static void main(String[] args) {
        int[] array = new Solution().sortArray(new int[]{1, 5, 3, 7, 8, 4, 6});
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}