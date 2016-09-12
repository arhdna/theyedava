package com.sai.one.algorithms.arrays;

import java.util.HashMap;

/**
 * Created by shravan on 12/9/16.
 * http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
 */
public class LngestSubstring2Distinct {
    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("abcbbbbcccbdddadacb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int ans = 0;
        HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
        while (i < s.length() && j < s.length()) {
            if (hs.containsKey(s.charAt(j)) && hs.size() <= 2 || !hs.containsKey(s.charAt(j)) && hs.size() < 2) {
                //if(hs.size()<=2){
                hs.put(s.charAt(j), j);
                ans = Math.max(ans, j - i);
                j++;
//                }else{
//                    int tmp = hs.get(s.charAt(i));
//                    hs.remove(s.charAt(i));
//                    i = tmp+1;
//
//                }
                //} else if(!hs.containsKey(s.charAt(j)) && hs.size()<2){
                //if(hs.size()<2){
//                    hs.put(s.charAt(j),j);
//                    ans =Math.max(ans,j-i);
//                    j++;
//                }else{
//                    int tmp = hs.get(s.charAt(i));
//                    hs.remove(s.charAt(i));
//                    i = tmp+1;
//                }
            } else {
                int tmp = hs.get(s.charAt(i));
                hs.remove(s.charAt(i));
                i = tmp + 1;
            }
        }
        return ans + 1;
    }
}
