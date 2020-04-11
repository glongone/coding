package com.learning.day.day04;

/**
 * @author glong
 * @date 2020/4/10 15:36
 * @desc: 重建二叉树
 */
public class Solution {

    int[] pre = {1,2,4,7,3,5,6,8};
    int[] in = {4,7,2,1,5,3,8,6};

    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        int[] pres = new int[pre.length-1];
        int[] ins = new int[in.length -1];
        int[] pred = new int[pre.length -1];
        int[] ind = new int[in.length -1];

        if (pre[0] != 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);

        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]){
                for (int j=0; j<=i; j++){
                    pres[j] = pre[j+1];
                }
                for (int j = i; j < pre.length; j++) {

                }
            }
        }

        treeNode.left = reConstructBinaryTree(pres, ins);


        return treeNode;
    }

}
