package com.sanking.leetcode;

/**
 Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".

 Example 1:

 Input: ["flower","flow","flight"]
 Output: "fl"
 Example 2:

 Input: ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.
 Note:

 All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0 ) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length ; i ++){
            String pre = "";
            for(int j = 0 ; j < Math.min(prefix.length(), strs[i].length()); j++){
                if( prefix.charAt(j) == strs[i].charAt(j) ){
                    pre = prefix.substring(0, j+1);
                    if(pre.isEmpty()){
                        return "";
                    }
                } else {
                    break;
                }
            }
            prefix = pre;
        }

        return prefix;

    }
}
