package com.sai.one.algorithms.arrays;

import java.util.ArrayList;

/**
 * Created by shravan
 */
public class ReverseArrayPointB {

    public static void main(String args[]) {
        ArrayList<Integer> aa = new ArrayList<Integer>();
        aa.add(28);
        aa.add(68);
        aa.add(100);
        aa.add(90);
        aa.add(46);
        aa.add(58);
        aa.add(54);
        aa.add(74);
        //rotateArray(aa, 3);
        System.out.print(rotateArray(aa, 3).toString());
    }

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (B > A.size()) {
            //int q = B / A.size();
            B = B % A.size();
        }

        for (int i = 0; i < A.size(); i++) {
            if ((i + B) >= A.size()) {
                ret.add(A.get((i + B) - A.size()));
            } else {
                ret.add(A.get(i + B));
            }
        }
        return ret;
    }

}
