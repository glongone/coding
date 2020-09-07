package com.learning.leetcode.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: glongone
 * @date: 2020/9/5 9:20 下午
 * @desc:
 */
public class Solution {

    public List<String> resultList;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.right = new TreeNode(2);
        node.right.right = new TreeNode(5);

        new Solution().binaryTreePaths(node);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        resultList = new ArrayList<String>(10);

        if (null == root){
            return new ArrayList<>();
        }
        buildResultList(root, new StringBuffer(String.valueOf(root.val)));

        return resultList;
    }

    /**
     * Determine whether the current node is a leaf node
     *
     * @param root The node need to be determined
     * @param buf All preceding nodes of the current node
     */
    public void buildResultList(TreeNode root, StringBuffer buf){
        //
        String buf1 = buf.toString();
        StringBuffer buffer = new StringBuffer(buf1);
        if (root.left == null && root.right == null) {
            resultList.add(buf.toString());
            return;
        }
        if (root.left != null){
            buf.append("->").append(root.left.val);
            buildResultList(root.left, buf);
        }
        if (root.right != null){
            buffer.append("->").append(root.right.val);
            buildResultList(root.right, buffer);
        }
    }

}
