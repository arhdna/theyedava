package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 31/8/16.
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ&list=PLrmLmBdmIlpvm7VaC0NTR27A_3i2sU3zd&index=5
 */
public class HayStackString {
    public static void main(String[] args) {

        System.out.print(strStr("mississippi", "issippi"));
    }

//    public static int strStr(String haystack, String needle) {
//        int ind = -1;
//        if(haystack==null && needle==null || needle.length() == 0 && haystack.length() == 0 )
//            return 0;
//
//        if(needle.length() == 0 )
//            return 0;
//
//        if(haystack.length() == 0 || haystack.length() < needle.length())
//            return -1;
//
//        int ncount = 0;
//
//        for(int i=0; i<haystack.length(); i++) {
//            if( haystack.length() < i+needle.length())
//                return ind;
//            ncount = i;
//            for (int j = 0; j < needle.length(); j++) {
//                if (haystack.charAt(ncount) == needle.charAt(j)) {
//                    if(j == needle.length()-1)return i;
//                    ncount++;
//                } else {
//                    break;
//                }
//            }
//
//        }
//        return ind;
//    }

    public static int strStr(String haystack, String needle) {

        if (haystack == null && needle == null || needle.length() == 0 && haystack.length() == 0)
            return 0;

        if (needle.length() == 0)
            return 0;

        if (haystack.length() == 0 || haystack.length() < needle.length())
            return -1;
        int[] temp_arr = computeTemporaryArray(needle);
        return KMP(haystack, needle, temp_arr);
    }

    public static int[] computeTemporaryArray(String needle) {
        int i = 1;
        int j = 0;
        int[] temp = new int[needle.length()];
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(j)) {
                temp[i] = j + 1;
                i++;
                j++;
            } else {
                if (j == 0) {
                    temp[i] = 0;
                    i++;
                } else {
                    j = temp[j - 1];
                }
            }
        }
        return temp;
    }

    public static int KMP(String haystack, String needle, int[] temp_arr) {

        int i = 0;
        int j = 0;
        int ind = 0;
        while (i < haystack.length() && j < needle.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0)
                    j = temp_arr[j - 1];
                else {
                    i++;
                }
            }
        }

        //if(ind!=0)ind--;
        if (j != needle.length()) ind = -1;
        else ind = i - j;
        return ind;
    }

}
