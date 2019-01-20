package com.sanking.leetcode;

import java.util.*;

/**
 You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 Example 1:

 Input:
 s = "barfoothefoobarman",
 words = ["foo","bar"]
 Output: [0,9]
 Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 The output order does not matter, returning [9,0] is fine too.
 Example 2:

 Input:
 s = "wordgoodgoodgoodbestword",
 words = ["word","good","best","word"]
 Output: []
 */
public class SubstringwithConcatenationofAllWords {

    /**
     是否会出现 "abc", "def", "bcd" ?
     */
    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new LinkedList<>();

        if(words == null || words.length == 0 || s == null || s.isEmpty() ){
            return res;
        }

        Map<String, Integer> wordsmap = new HashMap<>();
        for(String ss: words){
            if(wordsmap.get(ss) == null){
                wordsmap.put(ss, 1);
            } else {
                wordsmap.put(ss, wordsmap.get(ss)+1);
            }
        }

        Map<String, Integer> processedmap = new HashMap<>();

//        Set<String> wordset = new HashSet<>(Arrays.asList(words));
//        Set<String> processedSet = new HashSet<>();
        int wordLength = words[0].length();
        int size = words.length;
        int slength = s.length();
        for(int i = 0 ; i + size*wordLength <= slength; i++){
            int j = i;
            while(true){

                if( j+wordLength > slength ){
                    break;
                }
                String word = s.substring(j, j+wordLength);
                if( toBeProcessed(wordsmap, processedmap, word) ){
//                    processedSet.add(word);
                    j = j+wordLength;

                    if( isProcessed(wordsmap, processedmap) ){
                        res.add(i);
                        processedmap.clear();
                        break;
                    }
                } else {
                    processedmap.clear();
                    break;
                }
            }
        }
        return res;
    }

    private static boolean toBeProcessed(Map<String, Integer> wordsmap, Map<String, Integer> processedmap, String word){
        Integer wmv = wordsmap.get(word);
        if(wmv == null){
            return false;
        } else {
            Integer pmv = processedmap.get(word);
            if(pmv != null && pmv.equals(wmv)){
                return false;
            } else if ( pmv == null){
                processedmap.put(word, 1);
            } else {
                processedmap.put(word, pmv+1);
            }
        }
        return true;
    }

    private static boolean isProcessed(Map<String, Integer> wordsmap, Map<String, Integer> processedmap){
        for(String word : wordsmap.keySet()){
            if( wordsmap.get(word) != null && processedmap.get(word) != null && wordsmap.get(word).equals(processedmap.get(word))){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
//        System.out.println("0123456789".substring(0,3));
//        System.out.println("0123456789".substring(3,6));
//        System.out.println("0123456789".substring(9,10));
//        System.out.println(SubstringwithConcatenationofAllWords.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
//        System.out.println(SubstringwithConcatenationofAllWords.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
//        System.out.println(SubstringwithConcatenationofAllWords.findSubstring("wgoodgoodbestword", new String[]{"word","good","best","good"}));
        System.out.println(SubstringwithConcatenationofAllWords.findSubstring("aaa", new String[]{"a","a"}));
    }

}
