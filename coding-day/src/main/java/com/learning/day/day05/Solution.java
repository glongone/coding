package com.learning.day.day05;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: glongone
 * @date: 2020/9/5 3:02 下午
 * @desc: 将链表从尾部依次返回
 *
 * 效率对比 方案2优于方法1
 * 空间换时间
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(58);
        ListNode node2 = new ListNode(24);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(67);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        long start0 = System.nanoTime();
        System.out.println(new Solution().printListFromTailToHead(node1));
        long end0 = System.nanoTime();
        System.out.println(end0 - start0);

        long start1 = System.nanoTime();
        System.out.println(new Solution().printListFromTailToHead2(node1));
        long end1 = System.nanoTime();
        System.out.println(end1 - start1);
    }

    // 解决方案1，尾部回调法，回溯法
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(null != listNode){
            fullList(list, listNode, listNode.next);
        }
        return list;
    }

    public ListNode fullList(ArrayList<Integer> list, ListNode node, ListNode next){
        if (next == null){
            list.add(node.val);
            return null;
        } else {
            next = fullList(list, next, next.next);
        }
        list.add(node.val);
        return null;
    }

    // 解决方案2，利用堆栈FILO性质
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> sta = new Stack<Integer>();
        while(listNode != null){
            sta.push(listNode.val);
            listNode = listNode.next;
        }
        while(!sta.isEmpty()){
            list.add(sta.pop());
        }
        return list;
    }
}
