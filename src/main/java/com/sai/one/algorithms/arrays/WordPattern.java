package com.sai.one.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shravan on 10/18/2016.
 * http://www.programcreek.com/2014/05/leetcode-word-pattern-java/
 */
public class WordPattern {

    public static void main(String[] args) {

        System.out.print(wordPattern("abba", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");

        if (arr.length != pattern.length())
            return false;

        Map<Character, String> mp = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (mp.containsKey(pattern.charAt(i))) {
                if (!arr[i].equalsIgnoreCase(mp.get(pattern.charAt(i))))
                    return false;
            } else {
                if (mp.containsValue(arr[i]))
                    return false;
                else
                    mp.put(pattern.charAt(i), arr[i]);
            }
        }

        return true;
    }
}
