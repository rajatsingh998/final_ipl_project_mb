package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class NoOfPlayerOfTheMatch {
    HashMap<String, Integer> noOfPlayerOfTheMatchFun(ArrayList<HashMap<String, String>> data){
        HashMap<String, Integer> map= new HashMap<>();
        String playerOfTheMatch;
        for(HashMap<String, String> i :data){
            playerOfTheMatch=i.get("player_of_match");
            if(playerOfTheMatch.length()>0) {
                if (map.containsKey(playerOfTheMatch)) {
                    int val = map.get(playerOfTheMatch);
                    val = val + 1;
                    map.replace(playerOfTheMatch, val);
                } else {

                    map.put(playerOfTheMatch, 1);
                }
            }
        }
        return map;
    }
}
