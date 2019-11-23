package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static com.company.ConstantValues.*;
class Matches {
    static AllSolution noOfMatchesPlayedFun(ArrayList<HashMap<String, String>> data) {
        HashMap<String, Integer> map= new HashMap<>();
        String date;
        for(HashMap<String, String> i :data){
            date=i.get(SEASON);
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
        return  (new AllSolution(answer));
    }

    static AllSolution noOfMatchesWonFun(ArrayList<HashMap<String, String>> data){
        String team;
        HashMap<String, Integer> map= new HashMap<>();
        for(HashMap<String, String> i :data){
            team=i.get(WINNER);
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
        HashMap<String,String> answer= funToString(map);
        return  (new AllSolution(answer));
    }

    static AllSolution noOfPlayerOfTheMatchFun(ArrayList<HashMap<String, String>> data){
        HashMap<String, Integer> map= new HashMap<>();
        String playerOfTheMatch;
        for(HashMap<String, String> i :data){
            playerOfTheMatch=i.get(PLAYER_OF_THE_MATCH);
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
        return  (new AllSolution(answer));
    }

    private static HashMap<String, String> funToString(HashMap<String, Integer> map){
        HashMap<String, String> temp= new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int x = entry.getValue();
                temp.put(entry.getKey(), Integer.toString(x));
            }

        return temp;
    }
}
