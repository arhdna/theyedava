package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 4/11/16.
 * http://www.programcreek.com/2014/07/leetcode-guess-number-higher-or-lower-java/
 */
public class GuessNumber {

    public static void main(String[] args) {
        System.out.print(guessNumber(30));
    }


    public static int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int match = guess(mid);
            if (match == 0) {
                return mid;
            } else if (match == 1) {
                low = mid + 1;
            } else if (match == -1) {
                high = mid - 1;
            }
        }
        return 0;
    }

    public static int guess(int num) {
        return 0;
    }
}
