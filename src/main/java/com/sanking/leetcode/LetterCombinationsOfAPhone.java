package com.sanking.leetcode;

import java.util.*;

/**
 * Created by Sanking on 12/27/2018.
 */
public class LetterCombinationsOfAPhone {

    public static final Map<Character, char[]> mapping = new HashMap<>();
    static {
        mapping.put('2', new char[]{'a','b','c'});
        mapping.put('3', new char[]{'d','e','f'});
        mapping.put('4', new char[]{'g','h','i'});
        mapping.put('5', new char[]{'j','k','l'});
        mapping.put('6', new char[]{'m','n','o'});
        mapping.put('7', new char[]{'p','q','r','s'});
        mapping.put('8', new char[]{'t','u','v'});
        mapping.put('9', new char[]{'w','x','y','z'});

    }

    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        res.add("");
        for(int i = 0 ; i < digits.length() ;  i++){
            res = parse(digits.charAt(i), res);
        }
        return res;
    }


    private List<String> parse(char n, List<String> preList){

        char[] c = mapping.get(n);

        List<String> res = new ArrayList<>(c.length * preList.size());
        for(String s : preList ){
            for(int j = 0 ; j < c.length ; j++){
                res.add( s + c[j] );
            }
        }
        return res;
    }
}


class LetterCombinationsOfAPhone_1 {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    public List<String> letterCombinations_1(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while(ans.peek().length()!=digits.length()){
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length())-'0'];
            for(char c: map.toCharArray()){
                ans.addLast(remove+c);
            }
        }
        return ans;
    }
}