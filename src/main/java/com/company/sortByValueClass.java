package com.company;

import java.util.*;

class sortByValueClass {
    HashMap<String, Integer> sortByValueFun(HashMap<String, Integer> temp) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(temp.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));

        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> tempp : list) {
            map.put(tempp.getKey(), tempp.getValue());
        }
        return map;
    }
}
