package com.learning.leetcode.day02;

/**
 * @author: glongone
 * @date: 2020/9/14 8:09 下午
 * @desc:
 */
public class TwoNumAdd {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(0);
        ListNode root = listNode;
        int num = 0;
        while (l1 != null || l2 !=null || num != 0){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + num;
            num = sum / 10;

            ListNode node = new ListNode(sum % 10);
            root.next = node;
            root = node;

        }

        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        ListNode root1 = root;
        ListNode root2 = new ListNode(3);
        root1.next = root2;
        root1 = root2;
        System.out.println(root);
        System.out.println(root1);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
