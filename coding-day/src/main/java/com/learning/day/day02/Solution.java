package com.learning.day.day02;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author glong
 * @date 2020/4/2 21:57
 * @desc:
 */

public class Solution {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ListNode node = listNode;

        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> sta = new Stack<Integer>();

        while (listNode != null) {
            sta.push(listNode.val);
            listNode = listNode.next;
        }

        while (!sta.isEmpty()) {
            list.add(sta.pop());
        }

        return list;

    }

}
