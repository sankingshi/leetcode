package com.sanking.leetcode;

import java.util.*;

/**
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        if(n <=0 ){
            return new LinkedList<>();
        }

        List<String>[] res = new List[n+1];
        res[0] = Arrays.asList("");
        for(int i = 1 ; i <= n ; i ++){
            List<String> list = new ArrayList<String>();
            for(int l = 0 ; l <= i-1 ; l ++){
                for(String ls : res[l]){
                    for(String rs: res[i-1-l]){
                        list.add("("+ls+")"+rs);
                    }
                }
            }
            res[i] = list;
        }
        return res[n];
    }


    public List<String> generateParenthesis_wrong(int n) {


        LinkedList<String> res = new LinkedList<>();
        if(n <=0 ){
            return res;
        }

        Set<String> set = new HashSet<>();
        res.offer("()");
        for(int i = 2 ; i <= n ; i ++){
            res.offer("#");
            set.clear();

            while(true){
                String s = res.pop();
                if(s.equals("#")){
                    break;
                }
                if( set.add("()"+s) ) res.offer("()"+s);
                if( set.add("("+s+")") ) res.offer("("+s+")");
                if( set.add(s+"()")) res.offer(s+"()");
            }

        }

        return res;
    }

    public static void main(String[] args){
        System.out.println((new GenerateParentheses()).generateParenthesis(1));
    }
}
