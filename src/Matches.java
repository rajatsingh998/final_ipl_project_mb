package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Matches {
    public static AllSolution noOfMatchesPlayedFun(ArrayList<HashMap<String, String>> data) {
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
        HashMap<String,String> answer;
        answer= funToString(map);
        AllSolution obj= new AllSolution(answer);
        return  (obj);
    }

    static AllSolution noOfMatchesWonFun(ArrayList<HashMap<String, String>> data){
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
        HashMap<String,String> answer= funToString(map);;
        AllSolution obj= new AllSolution(answer);
        return  (obj);
    }

    static AllSolution noOfPlayerOfTheMatchFun(ArrayList<HashMap<String, String>> data){
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
        HashMap<String,String> answer= funToString(map);
        AllSolution obj= new AllSolution(answer);
        return  (obj);
    }

    static HashMap<String, String> funToString(HashMap<String, Integer> map){
        HashMap<String, String> temp= new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int x = entry.getValue();
                temp.put(entry.getKey(), Integer.toString(x));
            }

        return temp;
    }
}
