package com.sai.one.algorithms.arrays;

/**
 * Created by shravan on 10/11/2016.
 * http://www.programcreek.com/2014/05/leetcode-flip-game-ii-java/
 */
public class FlipGame2 {


    public static void main(String[] args) {
        System.out.print(canWin("++++++++"));
    }

    public static boolean canWin(String s) {
        if(s==null||s.length()==0){
            return false;
        }

        return canWinHelper(s.toCharArray());
    }

    public static boolean canWinHelper(char[] arr){
        for(int i = 0; i<arr.length-1; i++){
            if(arr[i]=='+'&&arr[i+1]=='+'){
                arr[i] = '-';
                arr[i+1] = '-';
                boolean win  = canWinHelper(arr);
                arr[i] = '+';
                arr[i+1] = '+';
                if(!win) return true;
            }
        }return  false;
    }
}
