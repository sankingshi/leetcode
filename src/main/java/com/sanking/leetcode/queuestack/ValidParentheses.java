package com.sanking.leetcode.queuestack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.

 Example 1:

 Input: "()"
 Output: true
 Example 2:

 Input: "()[]{}"
 Output: true
 Example 3:

 Input: "(]"
 Output: false
 Example 4:

 Input: "([)]"
 Output: false
 Example 5:

 Input: "{[]}"
 Output: true

 */
public class ValidParentheses {

    private static final Map<Character,Character> map = new HashMap<>();
    static{
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
    }

    public boolean isValid(String s) {

        if(s==null || s.length()==0){
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){

            if( map.keySet().contains(c) ){
                stack.push(c);
            }

            if(stack.size()==0){
                return false;
            }

            if( map.values().contains(c)){

                char ch = stack.pop();
                if( c != map.get(ch) ){
                    return false;
                }
            }
        }

        if(stack.size() > 0){
            return false;
        }

        return true;
    }


    public boolean isValid_1(String s) {
        Stack<Character> s1 = new Stack<>();
        for(char c: s.toCharArray()){
            if(c==')' ) {
                if(s1.isEmpty()) return false;
                if (s1.pop() !='(') return false;
            }
            else if(c=='}'){
                if(s1.isEmpty()) return false;
                if (s1.pop() !='{') return false;
            }
            else if(c==']'){
                if(s1.isEmpty()) return false;
                if (s1.pop() !='[') return false;
            }
            else
                s1.push(c);
        }
        return s1.isEmpty() ;
    }
}
