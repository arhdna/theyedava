package com.sai.one.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shravan on 18/9/16.
 * https://leetcode.com/problems/bulls-and-cows/
 */
public class BullsCows {
    public static void main(String[] args) {

        System.out.print(getHint("1122", "1222"));
    }

    public static String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : secret.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int bull = 0;
        int cow = 0;

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                bull++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) != secret.charAt(i)) {
                if (map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) > 0) {
                    cow++;
                    map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                }
            }
        }
        return bull + "A" + cow + "B";
    }


}
