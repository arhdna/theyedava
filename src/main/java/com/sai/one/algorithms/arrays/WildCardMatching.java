package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 20/8/16.
 * http://www.programcreek.com/2014/06/leetcode-wildcard-matching-java/
 */
public class WildCardMatching {

    public static void main(String args[]) {
        String text = "sabbsbbx";
        String pattern = "*bd*";
        System.out.print(isMatchOptimized(text, pattern));
    }

    private static boolean isMatchOptimized(String text, String pattern) {
        int i = 0;
        int j = 0;
        int iindex = -1;
        int jindes = -1;
        while (i < text.length()) {

            if (j < pattern.length() && (pattern.charAt(j) == '?' || pattern.charAt(j) == text.charAt(i))) {
                i++;
                j++;
            } else if (j < pattern.length() && pattern.charAt(j) == '*') {
                iindex = i;
                jindes = j;
                j++;
            } else if (jindes != -1) {
                i = iindex + 1;
                j = jindes + 1;
                iindex++;
            } else
                return false;

        }

        while (j < pattern.length() && pattern.charAt(j) == '*') {
            j++;
        }

        return j == pattern.length();
    }


    private static boolean isMatch(String text, String pattern) {
        char[] textarr = text.toCharArray();
        char[] patternarr = pattern.toCharArray();

        if ((textarr.length == 0 && patternarr.length == 0)) return true;

        if (textarr.length == 0) {
            return patternarr.length == 1 && patternarr[0] == '*';
        }

        if ((patternarr.length == 0)) return false;

        int counter = 0;
        boolean first = true;
        //remove duplicate *
        for (int i = 0; i < patternarr.length; i++) {
            if (patternarr[i] == '*') {
                if (first) {
                    patternarr[counter++] = patternarr[i];
                    first = false;
                }
            } else {
                patternarr[counter++] = patternarr[i];
                first = true;
            }

        }

        boolean[][] arrmatch = new boolean[text.length() + 1][counter + 1];
        arrmatch[0][0] = true;
        if (counter > 0 && patternarr[0] == '*') {
            arrmatch[0][1] = true;
        }

        for (int i = 1; i < (text.length() + 1); i++) {
            for (int j = 1; j < (counter + 1); j++) {
                if (patternarr[j - 1] == '?' || patternarr[j - 1] == textarr[i - 1]) {
                    arrmatch[i][j] = arrmatch[i - 1][j - 1];
                } else if (patternarr[j - 1] == '*') {
                    arrmatch[i][j] = arrmatch[i][j - 1] || arrmatch[i - 1][j];
                } else {
                    arrmatch[i][j] = false;
                }
            }
        }

        return arrmatch[text.length()][counter];

    }


}
