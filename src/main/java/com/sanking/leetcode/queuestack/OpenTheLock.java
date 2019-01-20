package com.sanking.leetcode.queuestack;

import java.util.*;
import java.util.stream.Collectors;

/**
 You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 The lock initially starts at '0000', a string representing the state of the 4 wheels.

 You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

 Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

 Example 1:
 Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 Output: 6
 Explanation:
 A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 because the wheels of the lock become stuck after the display becomes the dead end "0102".
 Example 2:
 Input: deadends = ["8888"], target = "0009"
 Output: 1
 Explanation:
 We can turn the last wheel in reverse to move from "0000" -> "0009".
 Example 3:
 Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 Output: -1
 Explanation:
 We can't reach the target without getting stuck.
 Example 4:
 Input: deadends = ["0000"], target = "8888"
 Output: -1
 Note:
 The length of deadends will be in the range [1, 500].
 target will not be in the list deadends.
 Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.

 */
public class OpenTheLock {

    /**
     *
     */
    public int openLock(String[] deadends, String target) {

        Queue<String> processing = new LinkedList<>();
        Set<String> processed = new HashSet<>();
        Set<String> deadendset = new HashSet<>(Arrays.asList(deadends));

        int depth = 0;
        String marker = "*";
        processing.add("0000");
        processing.add(marker);
        while(true){
            String s = processing.poll();
            if( s.equals(target) ){
                break;
            } else if( deadendset.contains(s) || processed.contains(s) ){
                continue;
            } else if( s.equals(marker) && processing.isEmpty() ){
                return -1;
            } else if( s.equals(marker)){
                depth ++;
                processing.add(marker);
            } else {
                processed.add(s);
                addNextStep(processing, s);
            }
        }
        return depth;
    }

    private void addNextStep(Queue<String> processing, String curr){
        for(int i = 0 ; i < curr.length() ; i ++ ){
            char[] cs = curr.toCharArray();
            cs[i] = cs[i] == '0' ? '9' :  (char)(((int)cs[i])-1);
            processing.add(  String.copyValueOf(cs) );
            cs = curr.toCharArray();
            cs[i] = cs[i] == '9' ? '0' :  (char)(((int)cs[i])+1);
            processing.add(  String.copyValueOf(cs) );
        }
    }


    /**
     *  用两个队列来交替存储每一步的可能性
     *  对每一步骤的队列进行一个排序，把距离结果近的放在前面
     *  这样就可以最快的找到目标
     *
     *  如何排序
     *  选项的每一位和目标项的每一位进行相减，并求出绝对值，然后求和，数值小的距离目标近。
     *  这里有个小问题，在临界条件下，计算稍有不同，0 和 9 的时候
     *  把diff存为map的key, map的key需要按照大小排序，所以可以选用treemap
     */

    public int openLock_number(String[] deadends, String target) {

        Queue<Integer> processing = new LinkedList<>();
        Map<Integer, List<Integer>> toBeProcessed = new TreeMap<>();
        Set<Integer> deadendset = Arrays.stream(deadends).map(Integer::parseInt).collect(Collectors.toSet());
        Integer targetValue = Integer.parseInt(target);
        processing.add(0);

        return -1;
    }



    public int openLock_fastest(String[] deadends, String target) {
        int[] arr = new int[10000];
        for (String str : deadends) {
            arr[Integer.parseInt(str)] = -1;
        }
        int steps = 0, t, labelQ = 1, labelLQ=2, label = labelLQ; // label用来标记当前是哪个遍历队列, 不能使用同向遍历的结果，作为结束依据
        int tar = Integer.parseInt(target);
        if (tar == 0) return 0;
        if (arr[tar] == -1 || arr[0] == -1) return -1;

        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> lq = new LinkedList<Integer>();
        Queue<Integer> curQ;
        q.add(0);
        arr[0] = labelQ;
        lq.add(tar);
        arr[tar] = labelLQ;
        while(!q.isEmpty()) {
            if (q.size() > lq.size()) {
                curQ = q;
                q = lq;
                lq = curQ;
                label = labelQ;
                labelQ = labelLQ;
                labelLQ = label;
            }
            curQ = new LinkedList<Integer>();
            while(!q.isEmpty()) {
                int val = q.remove();
                if (arr[val] == -1) continue;

                for (int i=1,radix = 1; i<=4; i++,radix*=10) {
                    int j = val % (radix*10) /radix;
                    t = (j==0 ? val-radix+radix*10 : val-radix);
                    if (arr[t] == labelLQ) return steps + 1;
                    if (arr[t] == 0) {
                        arr[t] = labelQ;
                        curQ.add(t);
                    }

                    t = (j==9 ? val+radix-radix*10 : val+radix);
                    if (arr[t] == labelLQ) return steps + 1;
                    if (arr[t] == 0) {
                        arr[t] = labelQ;
                        curQ.add(t);
                    }
                }
            }
            steps++;
            q = curQ;
        }
        return -1;
    }



    public static void main(String[] args) throws Exception {
        System.out.println( (new OpenTheLock()).openLock( new String[]{"0201","0101","0102","1212","2002"}, "0202" ) );
    }

}
