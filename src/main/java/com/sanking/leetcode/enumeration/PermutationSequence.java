package com.sanking.leetcode.enumeration;

import java.util.ArrayList;
import java.util.List;

/**

 The set [1,2,3,...,n] contains a total of n! unique permutations.
 By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.
 Note:
 Given n will be between 1 and 9 inclusive.
 Given k will be between 1 and n! inclusive.
 Example 1:

 Input: n = 3, k = 3
 Output: "213"
 Example 2:

 Input: n = 4, k = 9
 Output: "2314"

 https://baike.baidu.com/item/%E5%BA%B7%E6%89%98%E5%B1%95%E5%BC%80
 */
public class PermutationSequence {

    public static final int[] factorial = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

    public String getPermutation(int n, int k) {
        List<Integer> l = new ArrayList<>();
        for(int i = 1; i <= n ; i++){
            l.add(i);
        }
        k=k-1;
        int quotient = 0;
        int remainder = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = n; i > 0 ; i--){
            quotient = k/factorial[i-1];
            remainder = k%factorial[i-1];
            sb.append(l.get(quotient));
            l.remove(quotient);
            k=remainder;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println((new PermutationSequence()).getPermutation(3,3));
    }

}


/**

 康托展开举例
 再举个例子说明。
 　　在{1,2,3,4,5}  5个数的排列组合中，计算 34152的康托展开值。
 首位是3，则小于3的数有两个，为1和2，a[5]=2 ，则首位小于3的所有排列组合为 a[5]*(5-1)!
 第二位是4，则小于4的数有两个，为1和2，注意这里3并不能算，因为3已经在第一位，所以其实计算的是在第二位之后小于4的个数。因此 a[4]=2 。
 第三位是1，则在其之后小于1的数有0个，所以 a[3] = 0  。
 第四位是5，则在其之后小于5的数有1个，为2，所以 a[2] = 1 。
 最后一位就不用计算啦，因为在它之后已经没有数了，所以 a[1] 固定为0
 根据公式：
 X = a[5]*4! + a[4]*3! + a[3]*2! + a[2]*1! + a[1]*0! = 61
 　　所以比34152小的组合有61个，即34152是排第62。

 逆康托展开举例
 一开始已经提过了，康托展开是一个全排列到一个自然数的双射，因此是可逆的。即对于上述例子，在  给出61可以算出起排列组合为34152。由上述的计算过程可以容易的逆推回来，具体过程如下：
 用 61 / 4! = 2余13，说明 a[5]=2 ,说明比首位小的数有2个，所以首位为3。
 用 13 / 3! = 2余1，说明 a[4]=2，说明在第二位之后小于第二位的数有2个，所以第二位为4。
 用 1 / 2! = 0余1，说明 a[3]=0 ，说明在第三位之后没有小于第三位的数，所以第三位为1。
 用 1 / 1! = 1余0，说明 a[2]=1 ，说明在第二位之后小于第四位的数有1个，所以第四位为5。
 最后一位自然就是剩下的数2。
 通过以上分析，所求排列组合为 34152。

 **/