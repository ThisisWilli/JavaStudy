package com.coding.leetcode.bfs.rightsideview199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-22 09:21
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);
        result.add(root.val);
        int layerCount = 1;
        int i = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            layerCount--;
            if (node.left != null){
                queue.offerLast(node.left);
                i++;
            }
            if (node.right != null){
                queue.offerLast(node.right);
                i++;
            }
            if (layerCount == 0){
                layerCount = i;
                i = 0;
                if (queue.peekLast() != null){
                    result.add(queue.peekLast().val);
                }
            }

        }
        return result;
    }

}
