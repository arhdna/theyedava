package com.sai.one.algorithms.arrays;

/**
 * Created by shravan
 */
public class ReverseString {
    public static void main(String args[]) {
        char[] string = {'s', 'a', 'i', ' ', 'f', 'u', 'c', 'k', ' ', 'y', 'o', 'u'};
        reverseString(string);
    }

    public static void reverseString(char[] chr) {
        char[] ch = reverse(chr,0,chr.length);
        int tempj=0;
        for(int i=0;i<=ch.length;i++){
            if(i==(ch.length) || ch[i]==' ' )
            {
                ch = reverse(chr,tempj,i);
                tempj = i+1;
            }
        }

        for(int i=0;i<ch.length;i++){
            System.out.print(ch[i]);
        }
    }

    public static char[] reverse(char[] ch, int start, int end){
        for(int i=0;i<(end-start)/2;i++){
            char temp  = ch[start+i];
            ch[start+i] = ch[end-1-i];
            ch[end-1-i] = temp;
        }
        return ch;
    }
}
