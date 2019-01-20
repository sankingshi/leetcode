package com.sanking.leetcode.queuestack;

import java.util.Stack;

/**
 * Created by Sanking on 12/16/2018.
 */
public class DecodeString {

    public static String decodeString(String s) {
        if( s == null || s.length()==0){
            return "";
        }

        Stack<Integer> nStack = new Stack<>();
        Stack<String> sStack = new Stack<>();

        String number = "";
        String strings = "";
        for( char c: s.toCharArray() ){

            if( c >= '0' && c <= '9' ){
                number += c;
            } else if( c != '[' && c!= ']' ){
                strings += c;
            } else {

                if( strings.length() > 0 ){
                    sStack.push(strings);
                    strings = "";
                }

                if( c == '[' ){
                    sStack.push("[");
                    nStack.push(Integer.parseInt(number));
                    number = "";
                }

                if( c== ']'){

                    while( !sStack.peek().equals("[") ){
                        strings = sStack.pop() + strings;
                    }
                    sStack.pop(); // pop [
                    int m = nStack.pop();
                    String temp = "";
                    for(int i = 0 ; i < m ; i ++){
                        temp +=strings;
                    }

                    sStack.push(temp);
                    strings = "";
                }
            }
        }
        if(strings.length()>0){
            sStack.push(strings);
        }
        strings = "";
        while( !sStack.isEmpty() && !sStack.peek().equals("[") ){
            strings = sStack.pop() + strings;
        }
        return strings;
    }

    public static void main(String[] args) {
        System.out.println( DecodeString.decodeString("3[a]2[bc]"));
        System.out.println( DecodeString.decodeString("3[a2[bc]]xxx"));
        System.out.println( DecodeString.decodeString("3[a1[bc]]xxx10[Q]"));
    }

}
