package com.sanking.leetcode.array;

/**
 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?

 Example 1:

 Input: [1,0,2]
 Output: 5
 Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 Example 2:

 Input: [1,2,2]
 Output: 4
 Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
 The third child gets 1 candy because it satisfies the above two conditions.
 */
public class Candy {

    public int candy_1(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        int sum = candies[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }
        return sum;
    }

    public int candy(int[] ratings) {

        if(ratings == null || ratings.length<1){
            return 0;
        }

        int length = ratings.length;
        if(length == 1){
            return 1;
        }

        int[] candies = new int[length];
        candies[0] = 1;
        for(int i = 1 ; i < length; i++ ){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        int[] candies1 = new int[length];
        candies1[length-1] = 1;
        for(int i = length-2; i >= 0 ; i--){
            if(ratings[i] > ratings[i+1]){
                candies1[i] = candies1[i+1] + 1;
            } else {
                candies1[i] = 1;
            }
        }

        int res = 0 ;
        for(int i = 0 ; i < length ; i ++){
            res += Math.max(candies[i],candies1[i]);
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println((new Candy()).candy(new int[]{1,0,2}));
    }
}

class Candy_1 {

    public int count(int n) {
        return (n * (n + 1)) / 2;
    }

    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        int candies = 0;
        int up = 0;
        int down = 0;
        int old_slope = 0;
        for (int i = 1; i < ratings.length; i++) {
            int new_slope = (ratings[i] > ratings[i - 1]) ? 1 : (ratings[i] < ratings[i - 1] ? -1 : 0);
            if ((old_slope > 0 && new_slope == 0) || (old_slope < 0 && new_slope >= 0)) {
                candies += count(up) + count(down) + Math.max(up, down);
                up = 0;
                down = 0;
            }
            if (new_slope > 0)
                up++;
            if (new_slope < 0)
                down++;
            if (new_slope == 0)
                candies++;

            old_slope = new_slope;
        }
        candies += count(up) + count(down) + Math.max(up, down) + 1;
        return candies;
    }
}
