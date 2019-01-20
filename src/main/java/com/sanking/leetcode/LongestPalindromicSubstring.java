package com.sanking.leetcode;

/**
 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if(s == null || s.length() <= 1 ){
            return s;
        }
        char[] chars = s.toCharArray();
        String longestString = ""+chars[0];
        int longest = 1;
        for(int i = 1 ; i < chars.length ; i ++){
            int j = 1 ;
            while( (i-j)>=0 && (i+j) <chars.length && chars[i-j] == chars[i+j]  ){
                j++;
            }
            j--;
            int l = 2*j+1;
            if( longest < l ){
                longest = l;
                longestString = s.substring(i-j,i+j+1);
            }
            j=1;
            while( (i-j)>=0 && (i+(j-1)) <chars.length && chars[i-j] == chars[i+j-1] ){
                j++;
            }
            j--;
            l = 2*j;
            if( longest < l ){
                longest = l;
                longestString = s.substring(i-j,i+j);
            }
        }
        System.out.println(longest);
        return longestString;
    }

    public static void main(String[] args) {
        System.out.println(LongestPalindromicSubstring.longestPalindrome("aa"));
        System.out.println(LongestPalindromicSubstring.longestPalindrome("abaabc"));
        System.out.println(LongestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(LongestPalindromicSubstring.longestPalindrome("cbbd"));
        System.out.println(LongestPalindromicSubstring.longestPalindrome("abcdbbfcba"));
    }

}
