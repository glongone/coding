package com.learning.leetcode.day02;

/**
 * @author glongone
 * @date 2021/4/2 3:01 下午
 * @desc
 */
public class Solution02 {

    ListNode l3 = new ListNode();
    boolean addOne = false;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 != null || l2 != null) {
            addTwoNumbers(l1,l2,l3);
        }
        return l3;
    }

    public void addTwoNumbers(ListNode l1, ListNode l2, ListNode nextNode) {
        int val = 0;
        if (l1 != null && l2 != null) {
            val = l1.val + l2.val;
            l1 = l1.next;
            l2 = l2.next;
        } else if (l1 != null && l2 == null) {
            val = l1.val;
            l1 = l1.next;
        } else if (l1 == null && l2 != null) {
            val = l2.val;
            l2 = l2.next;
        }

        if (addOne) val = val + 1;

        if (val <= 0 && l1 == null && l2 == null) {
            return;
        }

        if (val >= 10) {
            addOne = true;
        } else {
            addOne = false;
        }

        val = val % 10;
        nextNode.val = val;
        if (l1 != null || l2 != null || addOne) {
            ListNode next = new ListNode();
            nextNode.next = next;
            addTwoNumbers(l1, l2, next);
        }

    }
}
