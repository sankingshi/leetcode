package com.sanking.leetcode.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: nums = [1,2,3]
 Output:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 */
public class Subsets {

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

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Item> queue = new LinkedList<>();
        Item n = new Item(-1);
        queue.add( n );
        res.add(n.getList());

        for(int i = 0; i < nums.length ; i ++){
            List<Item> newQueue = new LinkedList<>();
            for(Item item: queue){
                for(int j = item.last+1; j < nums.length; j++ ){
                    n = new Item(j).addAll(item.getList()).add(nums[j]);
                    newQueue.add(n);
                    res.add(n.getList());
                }
            }
            queue = newQueue;
        }

        return res;
    }

}

// Subsets
// 迭代版，时间复杂度O(2^n)，空间复杂度O(1)
class Subsets_1 {
    public List<List<Integer>> subsets(int[] nums) {
        //Arrays.sort(nums); // 输出要求有序
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // empty subset
        for (int elem : nums) {
            final int n = result.size();
            for (int i = 0; i < n; ++i) { // copy itself
                result.add(new ArrayList<>(result.get(i)));
            }
            for (int i = n; i < result.size(); ++i) {
                result.get(i).add(elem);
            }
        }
        return result;
    }
}


class Subsets_2 {

    public List<List<Integer>> subsets(int[] nums) {
        //Arrays.sort(nums); // 输出要求有序
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        subsets(nums, path, 0, result);
        return result;
    }


    private void subsets(int[] nums, List<Integer> path, int step, List<List<Integer>> res){

        if( step == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        //每个元素，都有两种选择，选或者不选。
        subsets(nums, path, step+1, res);

        path.add(nums[step]);
        subsets(nums, path, step+1, res);
        path.remove(path.size()-1);
    }
}

class Subsets_3 {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);  // 输出要求有序

        List<List<Integer>> result = new ArrayList<>();
        boolean[] selected = new boolean[nums.length];
        subsets(nums, selected, 0, result);
        return result;
    }

    private static void subsets(int[] nums, boolean[] selected, int step,
                                List<List<Integer>> result) {
        if (step == nums.length) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (selected[i]) subset.add(nums[i]);
            }
            result.add(subset);
            return;
        }
        // 不选S[step]
        selected[step] = false;
        subsets(nums, selected, step + 1, result);
        // 选S[step]
        selected[step] = true;
        subsets(nums, selected, step + 1, result);
    }


}

/**
 二进制法
 本方法的前提是：集合的元素不超过int位数。用一个int整数表示位向量，第i位为1，则表示选择S[i]，为0则不选择。例如 S={A,B,C,D}，则0110=6表示子集 {B,C}。
 这种方法最巧妙。因为它不仅能生成子集，还能方便的表示集合的并、交、差等集合运算。设两个集合的位向量分别为B_1B
 ​1
 ​​ 和B_2B
 ​2
 ​​ ，则B_1\cup B_2, B_1 \cap B_2, B_1 \triangle B_2B
 ​1
 ​​ ∪B
 ​2
 ​​ ,B
 ​1
 ​​ ∩B
 ​2
 ​​ ,B
 ​1
 ​​ △B
 ​2
 ​​ 分别对应集合的并、交、对称差。
 二进制法，也可以看做是位向量法，只不过更加优化。
 */
class Subsets_4 {
    public List<List<Integer>> subsets(int[] nums) {
        //Arrays.sort(nums);  // 输出要求有序

        List<List<Integer>> result = new ArrayList<>();
        final int n = nums.length;

        ArrayList<Integer> v = new ArrayList<>();
        for(int i = 0 ; i < 1<< n; i++){
            for(int j = 0 ; j < n ; j ++){
                if( (i & 1<< j) > 0 ) v.add(nums[j]);
            }
            result.add(new ArrayList<>(v));
            v.clear();
        }
        return result;
    }

}
