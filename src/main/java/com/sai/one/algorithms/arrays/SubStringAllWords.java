package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shravan on 15/9/16.
 * http://www.programcreek.com/2014/06/leetcode-substring-with-concatenation-of-all-words-java/
 * z alogorithm
 */
public class SubStringAllWords {

    public static void main(String[] args) {
        String[] ch = {"foo", "bar"};

        System.out.print(findSubstring("barbarfoofoothefoobarman", ch));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> mainmap = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            if (mainmap.containsKey(words[i])) {
                mainmap.put(words[i], mainmap.get(words[i]) + 1);
            } else {
                mainmap.put(words[i], 1);
            }
        }

        int len = words[0].length();

        for (int i = 0; i < len; i++) {
            HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
            int count = 0;
            int start = i;

            for (int j = i; j < s.length() - len; j = j + len) {
                String sub = s.substring(j, j + len);
                if (mainmap.containsKey(sub)) {
                    if (currentMap.containsKey(sub)) {
                        currentMap.put(sub, currentMap.get(sub) + 1);
                    } else {
                        currentMap.put(sub, 1);
                    }

                    count++;

                    while (currentMap.get(sub) > mainmap.get(sub)) {
                        String next = s.substring(start, start + len);
                        currentMap.put(next, currentMap.get(next) - 1);
                        count--;
                        start = start + len;
                    }

                    if (words.length == count) {
                        res.add(start);
                        String next = s.substring(start, start + len);
                        currentMap.put(next, currentMap.get(next) - 1);
                        count--;
                        start = start + len;
                    }
                } else {
                    start = j + len;
                    currentMap.clear();
                    count = 0;
                }
            }
        }
        return res;
    }

}
