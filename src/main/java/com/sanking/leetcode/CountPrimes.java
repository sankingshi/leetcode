package com.sanking.leetcode;

/**
 Count the number of prime numbers less than a non-negative number, n.

 Example:

 Input: 10
 Output: 4
 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 */
public class CountPrimes {

    public int countPrimes(int n) {

        if(n<=2){
            return 0;
        }

        int[] result = new int[n+1];
        result[0] = 0 ;
        result[1] = 0 ;
        result[2] = 1 ;

        for(int i = 3 ; i <= n ; i ++){
            result[i] = result[i-1] + (isPrimary(i)?1:0);
        }

        return result[n];
    }

    private boolean isPrimary(int n){

        int i = 2;
        int size = n/i;

        for( ; i <= size; i++ ){
            if( n%i==0 ){
                return false;
            } else {
                size = n/i;
            }
        }
        return true;

    }

}


class CountPrimes1 {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}
