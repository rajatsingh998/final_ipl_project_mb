package com.company;

import java.util.*;

public class SortByTheValues {
    HashMap<String, Float> sortByValueFun(HashMap<String, Float> temp) {
        List<Map.Entry<String, Float>> list = new LinkedList<>(temp.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));

        HashMap<String, Float> map = new LinkedHashMap<>();
        for (Map.Entry<String, Float> tempp : list) {
            map.put(tempp.getKey(), tempp.getValue());
        }
        return map;
    }
}
