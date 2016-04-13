package com.mrsun.hackerrank.easyTrack;

import java.util.*;


/**
 * https://www.hackerearth.com/tracks/pledge-2015-easy/panda-and-xor/
 *
 * @author sundeep
 */
public class PandaAndXOR {

    public static Set<Set<Integer>> powerSet(Set<Integer> inputSet) {
        Set<Set<Integer>> result = new HashSet<>();
        if (inputSet.isEmpty()) {
            result.add(new HashSet<Integer>());
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

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        Set<Integer> dataSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            dataSet.add(in.nextInt());
        }

        Map<Long, Integer> countMap = new HashMap<>();
        int result = 0;

        for (Set<Integer> set : powerSet(dataSet)) {

            if (set.isEmpty()) {
                continue;
            }

            List<Integer> dataList = new ArrayList<>(set);
            long temp = dataList.get(0);
            for (int i = 1; i < dataList.size(); i++) {
                temp ^= dataList.get(i);
            }
            if (countMap.containsKey(temp)) {
                countMap.put(temp, countMap.get(temp) + 1);
            } else {
                countMap.put(temp, 1);
            }
        }
        Collection c = countMap.values();
        Iterator it = c.iterator();
        while (it.hasNext()) {
            if ((Integer) it.next() > 1) {
                result++;
            }
        }
        System.out.println("Result:"+result);
    }
}
