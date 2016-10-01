package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 28/9/16.
 * http://www.programcreek.com/2014/03/leetcode-candy-java/
 */
public class Candy {

    public static void main(String[] args) {
        int[] arr1 = {4, 2, 3, 4, 1};
        System.out.print(candy(arr1));
    }

    public static int candy(int[] ratings) {
        int total = 0;
        if (ratings == null || ratings.length == 0) {
            return total;
        }

        int[] count = new int[ratings.length];
        count[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }
        }

        total = count[ratings.length - 1];

        for (int j = ratings.length - 2; j >= 0; j--) {
            if (ratings[j] > ratings[j + 1]) {
                count[j] = Math.max(count[j], count[j + 1] + 1);
            }
            total = total + count[j];
        }
        return total;
    }

}
