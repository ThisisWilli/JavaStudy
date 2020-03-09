package com.coding.sword.tree.zhiprint;

import java.util.*;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-09 09:48
 **/

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution {
    // 双端队列实现
    LinkedList<TreeNode> list = new LinkedList<>();
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        if(pRoot == null) return res;
        dq.offerFirst(pRoot);
        int thisLevel = 1;
        int nextLevel = 0;
        boolean lr = true;//奇偶层标记
        while(!dq.isEmpty()){
            TreeNode node = null;
            if(lr == true){//奇术层，队头出对，孩子从队尾入队，先左后右
                node = dq.pollFirst();
                list.add(node.val);
                thisLevel--;
                //左右孩子入队
                if(node.left!=null){
                    dq.offerLast(node.left);
                    nextLevel++;
                }
                if(node.right!=null){
                    dq.offerLast(node.right);
                    nextLevel++;
                }
            }else{//偶数层，队尾出队，孩子从队头入队，先右后做
                node = dq.pollLast();
                list.add(node.val);
                thisLevel--;
                //左右孩子入队
                if(node.right!=null){
                    dq.offerFirst(node.right);
                    nextLevel++;
                }
                if(node.left!=null){
                    dq.offerFirst(node.left);
                    nextLevel++;
                }
            }//if -else结束
            if(thisLevel == 0){
                thisLevel = nextLevel;
                nextLevel = 0;
                lr = !lr;
                res.add(list);
                list = new ArrayList<>();
            }
        }//结束循环
        return res;
    }
}
