package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 10/9/16.
 * http://www.programcreek.com/2014/05/leetcode-add-binary-java/
 */
public class AddBinary {

    public static void main(String[] args) {

        System.out.print(addBinary("111", "11"));
    }

    public static String addBinary(String a, String b) {
        int s1l = a.length() - 1;
        int s2l = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (s1l >= 0 || s2l >= 0) {


            int na1 = 0;
            int nb2 = 0;

            if (s1l >= 0) {
                char one = a.charAt(s1l);
                na1 = one == '1' ? 1 : 0;
                s1l--;
            }
            if (s2l >= 0) {
                char two = b.charAt(s2l);
                nb2 = two == '1' ? 1 : 0;
                s2l--;
            }


            int tmp = na1 + nb2 + carry;
            if (tmp >= 2) {
                sb.append(tmp - 2);
                carry = 1;
            } else {
                sb.append(tmp);
                carry = 0;
            }

        }

        if (carry == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
