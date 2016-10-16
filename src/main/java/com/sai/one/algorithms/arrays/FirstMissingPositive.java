package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 10/13/2016.
 * http://www.programcreek.com/2014/05/leetcode-first-missing-positive-java/
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        System.out.print(firstMissingPositive(arr));
    }

    public static int firstMissingPositiveAnd0(int A[]) {
        int n = A.length;
        for (int i = 0; i < A.length; i++) {
            while (A[i] != i) {
                if (A[i] < 0 || A[i] >= n) {
                    break;
                }
                if (A[i] == A[A[i]]) {
                    break;
                }
                int temp = A[i];
                A[i] = A[temp];
                A[temp] = temp;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i) {
                return i;
            }
        }
        return n;
    }

    public static int firstMissingPositive(int[] A) {
        int n = A.length;

        for (int i = 0; i < n; i++) {
            while (A[i] != i + 1) {
                if (A[i] <= 0 || A[i] >= n)
                    break;

                if(A[i]==A[A[i]-1])
                    break;

                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++){
            if (A[i] != i + 1){
                return i + 1;
            }
        }

        return n + 1;
    }

}
