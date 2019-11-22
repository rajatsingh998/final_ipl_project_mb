package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class NoOfMatchesClass {
    public HashMap<String,Integer> noOfMatchesPlayedFun(ArrayList<HashMap<String, String>> data) {
        HashMap<String, Integer> map= new HashMap<>();
        String date;
        for(HashMap<String, String> i :data){
            date=i.get("season");
            if(map.containsKey(date)){
                int val=map.get(date);
                val=val+1;
                map.replace(date,val);
            }
            else{
                map.put(date,1);
            }
        }
        return  map;
    }

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
