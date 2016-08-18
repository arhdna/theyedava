package com.sai.one.algorithms.arrays;

import java.util.ArrayList;

/**
 * Created by shravan
 */
public class ReverseArrayKSteps {
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

        System.out.print(rotateArray(aa, 3).toString());
    }

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        int index = A.size() - B;

        for (int i = 0; i < A.size(); i++) {
            if ((i + index) >= A.size()) {
                ret.add(A.get((i + index) - A.size()));
            } else {
                ret.add(A.get(i + index));
            }
        }
        return ret;
    }

}
