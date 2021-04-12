package com.learning.leetcode.day02;

/**
 * @author glongone
 * @date 2021/4/2 3:01 下午
 * @desc
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int x){
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}