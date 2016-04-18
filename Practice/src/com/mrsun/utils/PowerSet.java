package com.mrsun.utils;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author sundeep
 */
public class PowerSet {
    
    public static Set<Set<Integer>> powerSet(Set<Integer> inputSet) {
        Set<Set<Integer>> result = new HashSet<>();
        if (inputSet.isEmpty()) {
            result.add(new HashSet<>());
            return result;
        }
        List<Integer> list = new ArrayList<>(inputSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(set);
            result.add(newSet);
            result.add(set);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] data = {1, 2, 3,4};
        Set<Integer> dataSet = new HashSet<>();
        for (int d : data) {
            dataSet.add(d);
        }
        
        for (Set<Integer> set : powerSet(dataSet)) {
            System.out.println(set);
        }
         
    }
}
