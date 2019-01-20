package com.sanking.leetcode.queuestack;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Sanking on 12/12/2018.
 */
public class OpenTheLock_1 {

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

    public int openLock(String[] deadends, String target) {

        Queue<String> processing = new LinkedList<>();
        Map<Integer, List<String>> toBeProcessed = new TreeMap<>();
        Set<String> deadendset = new HashSet<>(Arrays.asList(deadends));

        int depth = 0;
        String marker = "*";
        processing.add("0000");
        processing.add(marker);
        char[] t = target.toCharArray();
        while(true){
            String s = processing.poll();
            if( s.equals(target) ){
                break;
            } else if( deadendset.contains(s)  ){
                continue;
            } else if( s.equals(marker) && processing.isEmpty() && toBeProcessed.isEmpty() ){
                return -1;
            } else if( s.equals(marker)){
                depth ++;
                //processing = new LinkedList<>(toBeProcessed.values().stream().flatMap(Collection::stream).collect(Collectors.toList()));

                processing = new LinkedList<>();

                for( List<String> list : toBeProcessed.values() ){
                    processing.addAll(list);
                }

                processing.add(marker);
                toBeProcessed = new TreeMap<>();
            } else {
                deadendset.add(s);
                addNextStep(toBeProcessed, s, t);
            }
        }
        return depth;
    }

    private void addNextStep(Map<Integer, List<String>> toBeProcessed, String curr, char[] target){
        for(int i = 0 ; i < curr.length() ; i ++ ){
            char[] cs = curr.toCharArray();
            cs[i] = cs[i] == '0' ? '9' :  (char)(((int)cs[i])-1);
            addToBeProcessed(toBeProcessed, diff(cs, target),  String.copyValueOf(cs) );
            cs = curr.toCharArray();
            cs[i] = cs[i] == '9' ? '0' :  (char)(((int)cs[i])+1);
            addToBeProcessed(toBeProcessed, diff(cs, target),  String.copyValueOf(cs) );
        }
    }

    private void addToBeProcessed(Map<Integer, List<String>> toBeProcessed, int diff, String nextString){
        List<String> list = toBeProcessed.get(diff);
        if( list == null){
            list = new ArrayList<>();
            toBeProcessed.put(diff, list);
        }
        list.add(nextString);
    }

    private int diff(char[] cs , char[] target){
        int diff = 0 ;
        for(int i = 0 ; i < target.length ; i ++){
            int c = Integer.parseInt( ""+cs[i]);
            int t = Integer.parseInt( ""+target[i]);
            diff += Math.min(Math.abs(c-t), ( c>t ? ( t+10-c) : (c+10-t)));
        }
        return diff;
    }


    public static void main(String[] args) throws Exception {
        System.out.println( (new OpenTheLock_1()).openLock( new String[]{"0201","0101","0102","1212","2002"}, "0202" ) );
    }

}
