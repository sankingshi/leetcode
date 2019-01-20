package com.sanking.leetcode.enumeration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 mapping.put('2', new char[]{'a','b','c'});
 mapping.put('3', new char[]{'d','e','f'});
 mapping.put('4', new char[]{'g','h','i'});
 mapping.put('5', new char[]{'j','k','l'});
 mapping.put('6', new char[]{'m','n','o'});
 mapping.put('7', new char[]{'p','q','r','s'});
 mapping.put('8', new char[]{'t','u','v'});
 mapping.put('9', new char[]{'w','x','y','z'});

 Example:

 Input: "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:

 Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsofaPhoneNumber {

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
