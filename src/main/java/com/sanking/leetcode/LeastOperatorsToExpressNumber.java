package com.sanking.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given a single positive integer x, we will write an expression of the form x (op1) x (op2) x (op3) x ... where each operator op1, op2, etc. is either addition, subtraction, multiplication, or division (+, -, *, or /).  For example, with x = 3, we might write 3 * 3 / 3 + 3 - 3 which is a value of 3.

 When writing such an expression, we adhere to the following conventions:

 The division operator (/) returns rational numbers.
 There are no parentheses placed anywhere.
 We use the usual order of operations: multiplication and division happens before addition and subtraction.
 It's not allowed to use the unary negation operator (-).  For example, "x - x" is a valid expression as it only uses subtraction, but "-x + x" is not because it uses negation.
 We would like to write an expression with the least number of operators such that the expression equals the given target.  Return the least number of expressions used.



 Example 1:

 Input: x = 3, target = 19
 Output: 5
 Explanation: 3 * 3 + 3 * 3 + 3 / 3.  The expression contains 5 operations.
 Example 2:

 Input: x = 5, target = 501
 Output: 8
 Explanation: 5 * 5 * 5 * 5 - 5 * 5 * 5 + 5 / 5.  The expression contains 8 operations.
 Example 3:

 Input: x = 100, target = 100000000
 Output: 3
 Explanation: 100 * 100 * 100 * 100.  The expression contains 3 operations.


 Note:

 2 <= x <= 100
 1 <= target <= 2 * 10^8
 */
public class LeastOperatorsToExpressNumber {

    public static int leastOpsExpressTarget(int x, int target) {

        int t = target;
        int ops = 0;
        int r = t%x;
        if( r <= x/2 ){
            ops += r * 2;
            t = t - r;
        } else {
            ops += (x-r) *2;
            t = t + (x-r);
        }

        List<Integer> power = new ArrayList<>();
        power.add(1); // 0次方
        int p = 1;
        int index = 0;
        do{
            index ++;
            p *= x;
            power.add(p);
        }while(p<=t);

        while( index-1 > 0 ){
            if( (t - power.get(index-1)) <= (power.get(index) - t) ){
                ops += Math.max(((index-1) -1),0); // a*a
                t = t - power.get(index-1);
            } else {
                ops += (index -1);
                t = power.get(index) - t;
            }

            if( t==0 ){
                break;
            }

            for( int k = 0 ; k <= index; k++ ){
                if( power.get(k)>= t ){
                    index = k;
                    ops +=1;
                    break;
                }
            }
        }

        return ops ;
    }

    public static void main(String[] args) {
//        System.out.println(Math.log(8)/Math.log(2));
//        System.out.println(Math.log(624)/Math.log(5));
//        System.out.println(Math.log(18)/Math.log(6));
//        System.out.println(Math.log(4)/Math.log(5));


//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(5, 501)); // 8
////        //5 * 5 * 5 * 5 - 5 * 5 * 5 + 5 / 5
//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 19)); // 5
//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(100, 100000000)); // 3
//
//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(6, 18)); // 2

//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(6, 24)); //3

//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 365)); //17

//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 907)); //19

//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 6)); // 3+3 1
//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 12)); // 3*3+3 2
//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 15)); // 3*3+3+3 3
//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 18)); // 3*3+3*3 3
//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 21)); // 3*3+3*3+3 4
//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 24)); // 3*3*3-3 3
//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 27)); // 3*3*3 2

        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 177)); // 3*3*3 2
//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 178)); // 14
//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 66)); //
//        System.out.println(LeastOperatorsToExpressNumber.leastOpsExpressTarget(3, 906)); //

//        System.out.println((new LeastOperatorsToExpressNumber1()).leastOpsExpressTarget(3, 906)); //19
        System.out.println((new LeastOperatorsToExpressNumber1()).leastOpsExpressTarget(3, 177)); //19
    }
}


class LeastOperatorsToExpressNumber1 {
    Map<String, Integer> memo;
    int x;
    public int leastOpsExpressTarget(int x, int target) {
        memo = new HashMap();
        this.x = x;
        return dp(0, target) - 1;
    }

    public int dp(int i, int target) {
        String code = "" + i + "#" + target;
        if (memo.containsKey(code))
            return memo.get(code);

        int ans;
        if (target == 0) {
            ans = 0;
        } else if (target == 1) {
            ans = cost(i);
        } else if (i >= 39) {
            ans = target + 1;
        } else {
            int t = target / x;
            int r = target % x;
            ans = Math.min(r * cost(i) + dp(i+1, t),
                    (x-r) * cost(i) + dp(i+1, t+1));
        }

        memo.put(code, ans);
        return ans;
    }

    public int cost(int x) {
        return x > 0 ? x : 2;
    }
}