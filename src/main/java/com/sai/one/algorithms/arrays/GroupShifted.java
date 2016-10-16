package com.sai.one.algorithms.arrays;

import java.util.*;

/**
 * Created by shravan on 10/16/2016.
 * http://www.programcreek.com/2014/05/leetcode-group-shifted-strings-java/
 */
public class GroupShifted {
    public static void main(String[] args) {
        String[] val = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};

        System.out.print(groupStrings(val));
    }

    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map
                = new HashMap<String, ArrayList<String>>();

        for (int i = 0; i < strings.length; i++) {
            char[] charr = strings[i].toCharArray();
            if (charr.length > 0) {
                int diff = charr[0] - 'a';
                for (int j = 0; j < charr.length; j++) {
                    if (charr[j] - diff < 'a') {
                        charr[j] = (char) (charr[j] - diff + 26);
                    } else {
                        charr[j] = (char) (charr[j] - diff);
                    }

                }
                String ns = new String(charr);
                if (map.containsKey(ns)) {
                    map.get(ns).add(strings[i]);
                } else {
                    ArrayList<String> al = new ArrayList<String>();
                    al.add(strings[i]);
                    map.put(ns, al);
                }
            }
        }
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        result.addAll(map.values());
        return result;
    }
}
