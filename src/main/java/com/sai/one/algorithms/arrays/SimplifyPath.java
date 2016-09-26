package com.sai.one.algorithms.arrays;

import java.util.LinkedList;

/**
 * Created by shravan on 22/9/16.
 * http://www.programcreek.com/2014/04/leetcode-simplify-path-java/
 */
public class SimplifyPath {
    public static void main(String[] args) {

        System.out.print(simplifyPath("/n/Qz/../../ZWuLz/./R/.//"));
    }

    public static String simplifyPath(String path) {
        LinkedList<String> st = new LinkedList<String>();
        StringBuilder resp = new StringBuilder();
        String[] arr = path.split("/");
        for (String ar : arr) {

            if (ar.equalsIgnoreCase("") || ar.equalsIgnoreCase(".")) {
                continue;
            }

            if (ar.equalsIgnoreCase("..")) {
                if (!st.isEmpty())
                    st.removeLast();
                continue;
            }

            st.add(ar);

        }

        while (!st.isEmpty()) {
            resp.append("/" + st.removeFirst());
        }

        return resp.toString().length() > 0 ? resp.toString() : "/";
    }
}
