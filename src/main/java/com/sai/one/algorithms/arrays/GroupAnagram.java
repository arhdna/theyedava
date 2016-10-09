package com.sai.one.algorithms.arrays;

import java.util.*;

/**
 * Created by shravan on 10/9/2016.
 * http://www.programcreek.com/2014/04/leetcode-anagrams-java/
 */
public class GroupAnagram {
    public static void main(String[] args) {
        String[] arr1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.print(groupAnagrams(arr1));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String tmp = s;
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String srt = String.valueOf(ch);
            if (map.containsKey(srt)) {
                map.get(srt).add(tmp);
            } else {
                List<String> lst = new ArrayList<>();
                lst.add(tmp);
                map.put(srt, lst);
            }
        }
        result.addAll(map.values());
        return result;
    }
}
