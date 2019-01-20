package com.sanking.leetcode.enumeration;

import java.util.*;
import java.util.stream.Collectors;

/**
 Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 Note: The solution set must not contain duplicate subsets.

 Example:
 Input: [1,2,2]
 Output:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class SubsetsII {

    private class Item{
        public final int last;
        public final List<Integer> list = new ArrayList<>();
        public Item(int last){
            this.last = last;
        }
        public Item add(Integer i){
            this.list.add(i);
            return this;
        }
        public Item addAll(List<Integer> l){
            this.list.addAll(l);
            return this;
        }
        public List<Integer> getList(){
            return this.list;
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Item> queue = new LinkedList<>();
        Item n = new Item(-1);
        queue.add( n );
        res.add(n.getList());

        for(int i = 0; i < nums.length ; i ++){
            List<Item> newQueue = new LinkedList<>();
            for(Item item: queue){
                for(int j = item.last+1; j < nums.length; j++ ){
                    if(j == item.last+1 || nums[j] != nums[j-1]){
                        n = new Item(j).addAll(item.getList()).add(nums[j]);
                        newQueue.add(n);
                        res.add(n.getList());
                    }
                }
            }
            queue = newQueue;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println( "[" +
                (new SubsetsII_1())
                        .subsetsWithDup(new int[]{1, 2,2})
                        .stream()
                        .map(e -> e.stream().map(Object::toString).collect(Collectors.joining(",")))
                        .collect(Collectors.joining("]\n["))
            +"]"
        );
    }
}

/**

[1,4,4]

 []  --- previous size = 0
 [] [1] --- previous size = 1
 [] [1] [4] [1,4] --- previous size = 2
 //[] [1] [4] [1,4] [4] [1,4] [4,4] [1, 4, 4]
 [] [1] [4] [1,4] [4,4] [1, 4, 4] --- previous size = 4

 */
class SubsetsII_1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // 必须排序
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int previous_size = 0;
        for (int i = 0; i < nums.length; ++i) {
            final int size = result.size();
            for (int j = 0; j < size; ++j) {
                if (i == 0 || nums[i] != nums[i-1] || j >= previous_size) {
                    result.add(new ArrayList<>(result.get(j)));
                    result.get(result.size() - 1).add(nums[i]);
                }
            }
            previous_size = size;
        }
        return result;
    }
}