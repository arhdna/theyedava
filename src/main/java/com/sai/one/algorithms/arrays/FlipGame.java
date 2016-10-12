package com.sai.one.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shravan on 10/11/2016.
 * http://www.programcreek.com/2014/04/leetcode-flip-game-java/
 */
public class FlipGame {

    public static void main(String[] args) {
        System.out.print(generatePossibleNextMoves("++++"));
    }


    public static List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        char[] ch = s.toCharArray();
        for(int i=0;i<s.length()-1;i++){
            if(ch[i]=='+'&&ch[i+1]=='+'){
                ch[i]='-';
                ch[i+1]='-';
                result.add(new String(ch));
                ch[i]='+';
                ch[i+1]='+';
            }
        }
        return result;
    }
}
