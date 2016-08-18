package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by shravan
 */
public class DyamicArrayFormula {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrSize = in.nextInt();
        int queries = in.nextInt();
        int lastAns = 0;
        int[][] qudata = new int[queries][3];
        for (int i = 0; i < queries; i++) {
            for (int j = 0; j < 3; j++) {
                qudata[i][j] = in.nextInt();
            }
        }
        //read completed

        constructArray(queries, qudata, lastAns, arrSize);
    }

    public static void constructArray(int queries, int[][] qudata, int lastAns, int arrSize) {
        HashMap<Integer, ArrayList<Integer>> heart = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < queries; i++) {
            if (qudata[i][0] == 1) {
                int q1 = ((qudata[i][1] ^ lastAns) % arrSize);
                if (heart.get(q1) == null) {
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(qudata[i][2]);
                    heart.put(q1, l);
                } else {
                    heart.get(q1).add(qudata[i][2]);
                }

            } else {
                int q2 = ((qudata[i][1] ^ lastAns) % arrSize);
                int index = qudata[i][2] % heart.get(q2).size();
                if (heart.get(q2) != null) {
                    lastAns = heart.get(q2).get(index);
                    System.out.print(lastAns+"\n");
                }
            }
        }

    }
}
