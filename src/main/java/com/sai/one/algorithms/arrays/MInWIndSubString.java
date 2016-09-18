package com.sai.one.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shravan on 17/9/16.
 * http://www.programcreek.com/2014/05/leetcode-minimum-window-substring-java/
 */
public class MInWIndSubString {

    public static void main(String[] args) {

        System.out.print(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> main = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            if (main.containsKey(c)) {
                main.put(c, main.get(c) + 1);
            } else {
                main.put(c, 1);
            }
        }

        Map<Character, Integer> current = new HashMap<Character, Integer>();
        int count = 0;
        int left = 0;
        int minLen = s.length() + 1;
        String result = "";

        for (int i = 0; i < s.length(); i++) {

            if (main.containsKey(s.charAt(i))) {
                if (current.containsKey(s.charAt(i))) {
                    if (current.get(s.charAt(i)) < main.get(s.charAt(i))) {
                        count++;
                    }
                    current.put(s.charAt(i), current.get(s.charAt(i)) + 1);

                } else {
                    current.put(s.charAt(i), 1);
                    count++;
                }

            }

            if (t.length() == count) {
                char ch = s.charAt(left);
                while (!main.containsKey(ch) || current.get(ch) > main.get(ch)) {
                    if (current.containsKey(ch) && current.get(ch) > main.get(ch)) {
                        current.put(ch, current.get(ch) - 1);
                    }
                    left++;
                    ch = s.charAt(left);
                }

                if (i - left + 1 < minLen) {
                    result = s.substring(left, i + 1);
                    minLen = i - left + 1;
                }
            }
        }
        return result;
    }
}
