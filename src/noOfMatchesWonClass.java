package com.company;

import java.util.ArrayList;
import java.util.HashMap;

class noOfMatchesWonClass {
    HashMap<String, Integer> noOfMatchesWonFun(ArrayList<HashMap<String, String>> data){
        String team;
        HashMap<String, Integer> map= new HashMap<>();
        for(HashMap<String, String> i :data){
            team=i.get("winner");
            if(team.length()>0) {
                if (map.containsKey(team)) {
                    int val = map.get(team);
                    val = val + 1;
                    map.put(team, val);
                } else {
                    map.put(team, 1);
                }
            }
        }
        return map;
    }
}
