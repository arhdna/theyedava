package com.sai.one.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shravan
 */
public class IsomorphicString {
    public static void main(String args[]) {
        String s1 = "aabvvvx";
        String s2 = "bbcmmmx";
        boolean isomorphic = stringIsomorphic(s1, s2);
        System.out.print(isomorphic);
    }

    private static boolean stringIsomorphic(String s1, String s2) {
        Map<Character, Character> mapch = new HashMap<Character, Character>();
        boolean iso = true;
        if (s1 == null || s2 == null || s1.length() != s2.length())
            iso = false;
        for (int i = 0; i < s1.length(); i++) {
            Character c1 = s1.charAt(i);
            Character c2 = s2.charAt(i);
            if (mapch.containsKey(c1)) {
                if (mapch.get(c1) != c2) {
                    iso = false;
                    break;
                }
            } else {
                if (mapch.containsValue(c2)) {
                    iso = false;
                    break;
                } else {
                    mapch.put(c1, c2);
                }

            }
        }
        return iso;
    }
}
