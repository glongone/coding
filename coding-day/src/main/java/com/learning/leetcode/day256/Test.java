package com.learning.leetcode.day256;

import java.util.ArrayList;
import java.util.List;

/**
 * @author glongone
 * @date 2021/4/2 3:08 下午
 * @desc
 */
public class Test {
    public List<String> strs;

    public List<String> binaryTreePaths(TreeNode root) {
        strs = new ArrayList<String>();
        if (null == root){
            return new ArrayList();
        }
        getStrs(root, new StringBuffer(String.valueOf(root.val)));

        return strs;
    }

    public void getStrs(TreeNode root, StringBuffer buf){

        String buf1 = buf.toString();
        StringBuffer buffer = new StringBuffer(buf1);
        if (root.left == null && root.right == null) {
            strs.add(buf.toString());
            return;
        }
        if (root.left != null){
            buf.append("->").append(root.left.val);
            getStrs(root.left, buf);
        }
        if (root.right != null){
            buffer.append("->").append(root.right.val);
            getStrs(root.right, buffer);
        }
    }
}

