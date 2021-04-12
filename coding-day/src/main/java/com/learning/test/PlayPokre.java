package com.learning.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;
/**
 * @author glongone
 * @date 2021/4/9 11:20 上午
 * @desc
 */
public class PlayPokre {

    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        /*
            ♦3，♦4...♦A,♦2
            ♣3...
            ♥3...
            ♠3...
            大王和小王
         */
        String[] s1 = {"♦", "♣", "♥", "♠"};
        String[] s2 = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        int k = 0;

        for (int j = 0; j < s2.length; j++) {
            for (int i = 0; i < s1.length; i++) {
                hm.put(k, s1[i] + s2[j]);
                k++;
            }
        }
        hm.put(52, "小王");
        hm.put(53, "大王");
        //System.out.println(hm);
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < hm.size(); i++) {
            al.add(i);
        }
        //洗牌
        Collections.shuffle(al);

        TreeSet<Integer> lqxts = new TreeSet<Integer>();
        TreeSet<Integer> lyts = new TreeSet<Integer>();
        TreeSet<Integer> fqyts = new TreeSet<Integer>();
        TreeSet<Integer> dpts = new TreeSet<Integer>();

        //发牌
        for (int i = 0; i < al.size(); i++) {
            int number = al.get(i);
            if (i >= al.size() - 3) {
                dpts.add(number);
            } else if (i % 3 == 0) {
                lqxts.add(number);
            } else if (i % 3 == 1) {
                lyts.add(number);
            } else if (i % 3 == 2) {
                fqyts.add(number);
            }
        }
        //System.out.println(lqxts);
        lookPoker("林青霞", lqxts, hm);
        lookPoker("柳岩", lyts, hm);
        lookPoker("林青阳", fqyts, hm);
        lookPoker("底牌", dpts, hm);

    }
    public static void lookPoker(String name, TreeSet<Integer> ts, HashMap<Integer, String> hm) {
        System.out.println(name + "的牌是:");
        for (int num : ts) {
            System.out.print(hm.get(num) + " ");
        }
        System.out.println();
    }
}

