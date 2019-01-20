package com.sanking.leetcode;

/**
 Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like . or *.
 Example 1:

 Input:
 s = "aa"
 p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 Example 2:

 Input:
 s = "aa"
 p = "a*"
 Output: true
 Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 Example 3:

 Input:
 s = "ab"
 p = ".*"
 Output: true
 Explanation: ".*" means "zero or more (*) of any character (.)".
 Example 4:

 Input:
 s = "aab"
 p = "c*a*b"
 Output: true
 Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 Example 5:

 Input:
 s = "mississippi"
 p = "mis*is*p*."
 Output: false
 */
public class RegularExpressionMatching {


    public boolean isMatch(String s, String p){
        /*
        处理空的情况
         */
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        /**
         * 看第一个字符是不是匹配
         */
        boolean isFirstMatch = (!s.isEmpty() && ( p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if(p.length()>=2 && p.charAt(1) == '*'){
            /**
             * 有*的情况
             * 1. 去除“*”，看是否匹配
             * 2. 再看如果第一个字符匹配，下面的是否匹配。
             */
            return ( isMatch(s, p.substring(2))
                        || (isFirstMatch && isMatch(s.substring(1), p)) );
        } else {
            /**
             * 没有*的情况
             * 如果第一个字符不匹配，返回false
             * 如果第一个字符匹配，查看下一个
             */
            return isFirstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public boolean isMatch_001(String s, String p) {


        if(p == null || p.length() == 0){
            if( s == null || s.length() == 0){
                return true;
            } else {
                return false;
            }
        }

        char[] sc;
        if(s == null || s.length() == 0){
            sc = new char[]{' '};
        } else {
            sc = s.toCharArray();
        }
        int si =0;
        int sl = sc.length;

        char[] pc = p.toCharArray();
        int pl = pc.length;
        int pi = 0;

        while(pi<pl ){

            if(si<sl){
                return false;
            }

            boolean zeroOrMore = false;
            if(pi+1 < pl && pc[pi+1] == '*'){
                zeroOrMore = true;
            }

            if( zeroOrMore ){
                /*
                做不下去了。。。需要dp或者recursion
                 */

            } else {
                if(pc[pi] == '.'){
                    if(sc[si] == ' ') {
                        return false;
                    }
                } else {
                    if(sc[si] != pc[pi]){
                        return false;
                    }
                }

                pi++;
                si++;
            }

        }
        return true;
    }

    public static void main(String[] args){
        System.out.println( Boolean.FALSE );
        Boolean b1 = new Boolean(false);
        System.out.println( b1.equals(Boolean.FALSE) );
        System.out.println( b1 == Boolean.FALSE );
    }
}


class RegularExpressionMatching_DP {

    /**
     * 从左到右的遍历字符串和相应的pattern
     * 前面的依赖于后面的匹配
     */
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length()+1][p.length()+1];
        return dp(0,0, s, p, memo);
    }

    private boolean dp(int si, int pi, String s, String p, Boolean[][] memo){
        if( memo[si][pi] != null ){
            return memo[si][pi].equals(Boolean.TRUE);
        }
        boolean ans;
        if( pi == p.length() ){
            ans = (si == s.length());
        } else {
            boolean isFirstMatch = ( si < s.length() && ( p.charAt(pi) == '.' || p.charAt(pi) == s.charAt(si) ));
            if( pi +1 < p.length() && p.charAt(pi+1) == '*' ){
                ans = dp(si, pi+2, s, p, memo)
                        || ( isFirstMatch && dp(si+1, pi, s, p, memo) );
            } else {
                ans = isFirstMatch && dp(si+1, pi+1, s, p, memo);
            }
        }
        memo[si][pi] = new Boolean(ans);
        return ans;
    }


}



class RegularExpressionMatching_DP02 {

    /**
     * 从后面开始遍历
     *
     */
    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        boolean[][] memo = new boolean[sl+1][pl+1];
        memo[sl][pl] = true;

        for(int si = sl; si >= 0 ; si --){
            for(int pi = pl-1; pi >= 0; pi --){
                boolean isFirstMatch = ( si < sl && ( p.charAt(pi) == '.' || p.charAt(pi) == s.charAt(si) ) );
                if( pi+1 < pl && p.charAt(pi+1) == '*' ){
                    memo[si][pi] = memo[si][pi+2] || (isFirstMatch && memo[si+1][pi]);
                } else {
                    memo[si][pi] = isFirstMatch && memo[si+1][pi+1];
                }
            }
        }
        return memo[0][0];
    }
}
class RegularExpressionMatching_DP03 {

    /**
     * 从前面遍历
     *
     */
    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        boolean[][] memo = new boolean[sl+1][pl+1];
        memo[0][0] = true;

        for(int si = 0; si >= sl ; si ++ ){
            for(int pi =0 ; pi >= pl; pi ++ ){



                boolean isFirstMatch = ( si < sl && ( p.charAt(pi) == '.' || p.charAt(pi) == s.charAt(si) ) );
                if( pi+1 < pl && p.charAt(pi+1) == '*' ){
                    memo[si][pi] = memo[si][pi+2] || (isFirstMatch && memo[si+1][pi]);
                } else {
                    memo[si][pi] = isFirstMatch && memo[si+1][pi];
                }
            }
        }
        return memo[sl][pl];
    }
}
