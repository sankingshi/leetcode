package com.sanking.leetcode;

import java.util.*;

/**
 * Created by Sanking on 12/20/2018.
 */
public class ShuffleAnArray {

    private int[] original;

    public ShuffleAnArray(int[] nums) {
        this.original = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {

        Map<Object, Integer> map = new HashMap<>();
        for(int i : this.original){
            map.put(Math.random(), i);
        }

        int i = 0 ;
        int[] result = new int[this.original.length];
        for(Object o : map.keySet()){
            result[i] = map.get(o);
            i++;
        }
        return result;
    }
}


class ShuffleAnArray1 {
    private int[] array;
    private int[] original;

    Random rand = new Random();
    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public ShuffleAnArray1(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}


class ShuffleAnArray2 {
    private int[] array;
    private int[] original;

    private Random rand = new Random();

    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            asList.add(array[i]);
        }
        return asList;
    }

    public ShuffleAnArray2(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    public int[] shuffle() {
        List<Integer> aux = getArrayCopy();

        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }

        return array;
    }
}