package com.mrsun.comparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * http://www.programcreek.com/2013/03/java-sort-map-by-value/
 * @author sundeep
 */
public class SortMapByValue {
    
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put("a",10);
        map.put("b",30);
        map.put("c",50);
        map.put("d",40);
        map.put("e",20);
        
        TreeMap<String, Integer> result = sortMapByValue(map);
        System.out.println(result);
    }
    
    public static TreeMap<String, Integer> sortMapByValue(HashMap<String,Integer> map){
        Comparator<String> comparator = new ValueComparator(map);
        TreeMap<String, Integer> result = new TreeMap<>(comparator);
        
        result.putAll(map);
        return result;
    }
    
    public static class ValueComparator implements Comparator<String>{

        Map<String, Integer> map = new HashMap<>();
        
        public ValueComparator(Map<String, Integer> map) {
            this.map.putAll(map);
        }
        
        @Override
        public int compare(String t, String t1) {
            if(map.get(t) >= map.get(t1)){
                    return 1;
                }else{
                    return -1;
                }
        }
        
    }
}
