package com.company.youzan;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-11 14:53
 **/

public class Main1 {
    LinkedHashMap<Integer, Integer> map;


    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU (int[][] operators, int k) {
        // write code here
         map = new LinkedHashMap<Integer, Integer>(k, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return map.size() > k;
            }
        };
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1){
                map.put(operators[i][1], operators[i][2]);
            }else if (operators[i][0] == 2){
                list.add(map.getOrDefault(operators[i][1], -1));
            }
        }
        return list.stream().mapToInt(x->x).toArray();
    }
}
