package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 1/10/16.
 * http://www.programcreek.com/2014/03/leetcode-count-and-say-java/
 */
public class CountSay {

    public static void main(String[] args) {
        System.out.print(countAndSay(5));
    }


    public static String countAndSay(int n) {
        if (n <= 0)
            return null;

        String res = "1";

        int loop = 1;

        while (loop < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int i = 1; i < res.length(); i++) {
                if (res.charAt(i) == res.charAt(i - 1)) {
                    count++;
                } else {
                    sb.append(count).append(res.charAt(i - 1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(res.charAt(res.length() - 1));
            loop++;
            res = sb.toString().length() > 0 ? sb.toString() : res;
        }
        return res;
    }
}
