package com.sanking.leetcode.util;

/**
 * Created by Sanking on 1/4/2019.
 */
public class ArrayTest {

    public static void main(String[] args) {
        Box<String>[] bsa = new Box[3]; // new Box<String>[3];
        Object[] oa = bsa;
        oa[0] = new Box<Integer>(3); // error not caught by array store check
        String s = bsa[0].x; // BOOM!
    }
}


class Box<T> {
    final T x;
    Box(T x) {
        this.x = x;
    }
}

//class Loophole {
//    public static void main(String[] args) {
//        Box<String>[] bsa = new Box[3]; // new Box<String>[3];
//        Object[] oa = bsa;
//        oa[0] = new Box<Integer>(3); // error not caught by array store check
//        String s = bsa[0].x; // BOOM!
//    }
//}
