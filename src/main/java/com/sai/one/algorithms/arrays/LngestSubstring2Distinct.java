package com.sai.one.algorithms.arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by shravan on 12/9/16.
 * http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
 */
public class LngestSubstring2Distinct {
    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstringBetter("abcbbbbcccbdddddddddddddadacb"));
    }


    public static int lengthOfLongestSubstringBetter(String s) {
        int start = 0;
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (mp.containsKey(s.charAt(i))) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) + 1);

            } else {
                mp.put(s.charAt(i), 1);
            }

            while (mp.size() > 2) {
                int cnt = mp.get(s.charAt(start));
                max = Math.max(max, i - start);
                if (cnt == 1) {
                    mp.remove(s.charAt(start));
                } else {
                    mp.put(s.charAt(start), mp.get(s.charAt(start)) - 1);
                }
                start++;
            }
        }
        //max = Math.max(max, s.length()-start);
        return max;
    }


    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int ans = 0;
        HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
        while (i < s.length() && j < s.length()) {
            if (hs.containsKey(s.charAt(j))) {
                if (hs.size() <= 2) {
                    hs.put(s.charAt(j), j);
                    ans = Math.max(ans, j - i);
                    j++;
                } else {
                    //int tmp = hs.get(s.charAt(i));
                    // hs.remove(s.charAt(j-2));
                    Iterator it = hs.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) it.next();
                        if (entry.getKey() != s.charAt(j - 1)) {
                            i = hs.get(entry.getKey()) + 1;
                            it.remove();
                        }
                    }

                    //hs.clear();
                    //hs.put(s.charAt(j-1),j-1);
                    //i = j-1;

                }
            } else {
                if (hs.size() < 2) {
                    hs.put(s.charAt(j), j);
                    ans = Math.max(ans, j - i);
                    j++;
                } else {
                    Iterator it = hs.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) it.next();
                        if (entry.getKey() != s.charAt(j - 1)) {
                            i = hs.get(entry.getKey()) + 1;
                            it.remove();
                            //hs.remove(entry.getKey());
                        }
                    }

                }
            }
        }
        return ans + 1;
    }
}
