package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 31/10/16.
 * http://www.programcreek.com/2014/05/leetcode-first-bad-version-java/
 */
public class FirstBadVerion {

    public static void main(String[] args) {
        System.out.print(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int i = 1, j = n;
        while(i<j){
            int m = i+(j-i)/2;
            if(isBadVersion(m)){
                j=m;
            }else{
                i=m+1;
            }
        }

        if(isBadVersion(i)){
            return i;
        }
        return j;
    }

    public static boolean isBadVersion(int i){
        return false;
    }
}
