package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 20/8/16.
 * http://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/
 */
public class RegExMatching {

    public static void main(String args[]) {
        String text = "";
        String pattern = ".*";
        System.out.print(isMatch(text, pattern));
    }

    private static boolean isMatch(String text, String pattern) {

        char[] textarr = text.toCharArray();
        char[] patternarr = pattern.toCharArray();

        if ((textarr.length == 0 && patternarr.length == 0)) return true;


        if ((patternarr.length == 0)) return false;


        boolean[][] arrmatch = new boolean[text.length() + 1][pattern.length() + 1];
        arrmatch[0][0] = true;

        for (int i = 1; i < patternarr.length + 1; i++) {
            if (patternarr[i - 1] == '*') {
                arrmatch[0][i] = arrmatch[0][i - 2];
            }
        }

        for (int i = 1; i < (text.length() + 1); i++) {
            for (int j = 1; j < (pattern.length() + 1); j++) {
                if (patternarr[j - 1] == '.' || patternarr[j - 1] == textarr[i - 1]) {
                    arrmatch[i][j] = arrmatch[i - 1][j - 1];
                } else if (patternarr[j - 1] == '*') {
                    arrmatch[i][j] = arrmatch[i][j - 2];
                    if (patternarr[j - 2] == textarr[i - 1] || patternarr[j - 2] == '.') {
                        arrmatch[i][j] = arrmatch[i][j] || arrmatch[i - 1][j];
                    }
                } else {
                    arrmatch[i][j] = false;
                }
            }
        }

        return arrmatch[text.length()][pattern.length()];


    }
}
