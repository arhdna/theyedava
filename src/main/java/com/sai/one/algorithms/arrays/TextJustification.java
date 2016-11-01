package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shravan on 31/10/16.
 * http://www.programcreek.com/2014/05/leetcode-text-justification-java/
 */
public class TextJustification {

    public static void main(String[] args) {
        String[] arr = {"This", "is", "an", "example", "of", "text", "v", "just","cation."};
        System.out.print(fullJustify(arr, 16));
    }


    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();

        if (words == null || words.length == 0) {
            return result;
        }

        int count = 0;
        int last = 0;
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < words.length; i++) {
            count = count + words[i].length();

            if (count + i - last > maxWidth) {
                int wlength = count - words[i].length();
                int slength = maxWidth - wlength;
                int eachLen = 0;
                int extraLen = 1;

                if (i - last - 1 > 0) {
                    eachLen = slength / (i - last - 1);
                    extraLen = slength % (i - last - 1);
                }

                StringBuilder sb = new StringBuilder();

                for (int k = last; k < i - 1; k++) {
                    sb.append(words[k]);

                    int ce = 0;
                    while (ce < eachLen) {
                        sb.append(" ");
                        ce++;
                    }

                    if (extraLen > 0) {
                        sb.append(" ");
                        extraLen--;
                    }
                }

                sb.append(words[i - 1]);

                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }

                result.add(sb.toString());

                last = i;
                count = words[i].length();
            }

        }

        StringBuilder sb = new StringBuilder();

        for (int i = last; i < words.length - 1; i++) {
            count = count + words[i].length();
            sb.append(words[i] + " ");
        }

        sb.append(words[words.length - 1]);

        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        result.add(sb.toString());

        return result;
    }
}
