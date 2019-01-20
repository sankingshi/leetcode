package com.sanking.leetcode;

import java.util.*;

/**
 * Created by Sanking on 12/12/2018.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if(s== null ){
            return 0;
        }

        int result = 0;
        Queue<Character> queue = new LinkedList<Character>();
        for( char c : s.toCharArray() ){

            if( queue.contains(c) ){
                while(true){
                    if( c != queue.peek() ){
                        queue.poll();
                    } else {
                        queue.poll();
                        queue.add(c);
                        break;
                    }
                }

            } else {
                queue.add(c);
            }

            result = result<= queue.size() ? queue.size() : result;
        }

        return result;
    }


    public int lengthOfLongestSubstring_1(String s) {

        if(s== null ){
            return 0;
        }

        int result = 0;
        Queue<Character> queue = new LinkedList<Character>();
        for( char c : s.toCharArray() ){

            if( queue.contains(c) ){
                while(true){
                    if( c != queue.peek() ){
                        queue.poll();
                    } else {
                        queue.poll();
                        queue.add(c);
                        break;
                    }
                }

            } else {
                queue.add(c);
            }

            result = result<= queue.size() ? queue.size() : result;
        }

        return result;
    }

    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_best(String s) {
        int start = 0;
        int result = 0;
        boolean[] map = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map[c]) {
                map[c] = true;
            } else {
                while (map[c]) {
                    map[s.charAt(start)] = false;
                    start++;
                }
                map[c] = true;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }


    public int lengthOfLongestSubstring_best_1(String s) {
        int start = 0;
        int result = 0;
        boolean[] map = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map[c]) {
                map[c] = true;
            } else {
                while (map[c]) {
                    map[s.charAt(start)] = false;
                    start++;
                }
                map[c] = true;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }


    public int lengthOfLongestSubstring_001(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * The previous implements all have no assumption on the charset of the string s.

     If we know that the charset is rather small, we can replace the Map with an integer array as direct access table.

     Commonly used tables are:

     int[26] for Letters 'a' - 'z' or 'A' - 'Z'
     int[128] for ASCII
     int[256] for Extended ASCII

     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_003(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[Math.min(n, 256)]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {

        int[] index = new int[2];
        Arrays.stream(index).forEach(System.out::println);

        boolean[] booleans = new boolean[1];
        System.out.println(booleans[0]);
    }

}
