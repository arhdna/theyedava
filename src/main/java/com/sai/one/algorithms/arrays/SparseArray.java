package com.sai.one.algorithms.arrays;

import java.util.*;

/**
 * Created by shravan
 */
public class SparseArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dataSize = Integer.parseInt(in.nextLine());
        Map<String, Integer> list = new HashMap<String, Integer>();

        for (int i = 0; i < dataSize; i++) {
            String val = in.nextLine();
            if (list.get(val) == null) {
                list.put(val, 1);
            } else {
                list.put(val, list.get(val) + 1);
            }
        }

        int querySize = Integer.parseInt(in.nextLine());
        List<String> query = new ArrayList<String>();

        for (int i = 0; i < querySize; i++) {
            String val = in.nextLine();
            query.add(val);
        }

        // reading completed
        for (int i = 0; i < query.size(); i++) {
            if (list.get(query.get(i)) != null) {
                System.out.print(list.get(query.get(i)) + "\n");
            } else {
                System.out.print(0 + "\n");
            }
        }
    }
}
