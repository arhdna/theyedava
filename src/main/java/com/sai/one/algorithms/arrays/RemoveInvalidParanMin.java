package com.sai.one.algorithms.arrays;

import java.util.*;

/**
 * Created by shravan on 1/11/16.
 * http://www.geeksforgeeks.org/remove-invalid-parentheses/
 * http://www.programcreek.com/2014/05/leetcode-remove-invalid-parentheses-java/
 */
public class RemoveInvalidParanMin {

    public static void main(String[] args) {

        System.out.print(removeInvalidParentheses(")(f"));
    }

    static ArrayList<String> result = new ArrayList<String>();

    public  static List<String> removeInvalidParentheses(String str) {
        int max = 0;
        if (str == null)
            return result;

        Queue<String> q = new LinkedList<>();
        q.add(str);

        Set<String> map = new HashSet<>();
        //Iterator<String> it = q.iterator();
        while (!q.isEmpty()) {
            str = q.poll();
            if (isValidString(str)) {
                max = str.length();
                result.add(str);
            } else {
                for (int i = 0; i < str.length(); i++) {
                    if (!isParenthesis(str.charAt(i))) {
                        continue;
                    }
                    else {
                        String temp = str.substring(0, i) + str.substring(i + 1);
                        if (temp.length()>=max && !map.contains(temp)) {
                            q.add(temp);
                            map.add(temp);
                        }
                    }
                }
            }
        }


        if (result.size() == 0) {
            result.add("");
        }

        return result;
    }


    public  static boolean isParenthesis(char c) {
        return ((c == '(') || (c == ')'));
    }


    public  static boolean isValidString(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }
}