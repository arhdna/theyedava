package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shravan on 29/10/16.
 * http://www.programcreek.com/2014/05/leetcode-palindrome-pairs-java/
 */
public class PalindromePairs {

    public static void main(String[] args) {
        String[] arr = {"a", ""};
        System.out.print( palindromePairs(arr));
    }


    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {

            //if word is palindrome
            if (isPalindrome(words[i])) {
                if (map.containsKey("") && map.get("") != i) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(map.get(""));
                    result.add(arr);
                    arr = new ArrayList<>();
                    arr.add(map.get(""));
                    arr.add(i);
                    result.add(arr);
                }
            }

            //find if reverse word is palindrome
            String reverse = new StringBuilder(words[i]).reverse().toString();
            if (map.containsKey(reverse) && map.get(reverse) != i) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                arr.add(map.get(reverse));
                result.add(arr);
            }

            //last scenario compare palindrome letters for left and right
            for(int k =1 ; k< words[i].length(); k++){
                String left = words[i].substring(0,k);
                String right = words[i].substring(k);

                if(isPalindrome(left)){
                    String rev = new StringBuilder(right).reverse().toString();
                    if(map.containsKey(rev) && map.get(rev) != i){
                        ArrayList<Integer> arr = new ArrayList<>();
                        arr.add(map.get(rev));
                        arr.add(i);
                        result.add(arr);
                    }
                }

                if(isPalindrome(right)){
                    String rev = new StringBuilder(left).reverse().toString();
                    if(map.containsKey(rev) && map.get(rev) != i){
                        ArrayList<Integer> arr = new ArrayList<>();
                        arr.add(i);
                        arr.add(map.get(rev));
                        result.add(arr);
                    }
                }
            }

        }
        return result;
    }

    public static boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
